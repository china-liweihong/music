package music.recommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import music.tools.RedisUtils;

/**
 * 
* @ClassName: UserCF 
* @Description: TODO(计算基于用户的协同过滤) 
* 注： 只计算用户在某一个指标上的相似度
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月14日 下午2:46:34 
*
 */
public class UserCF implements ML{
	
	private RedisUtils redis;
	
	public UserCF(){
		this.redis = new RedisUtils("127.0.0.1",6379);
	}

	//从redis 中加载实时数据
	//用户点击数据存储格式   usename -> musicname;musicname;musicname;.....
	public Object load() {
		// TODO Auto-generated method stub
		//音乐库  musicname;musicname;musicname;....
		String musicPool = this.redis.get("music_pool");
		String[] musicArr = musicPool.split(";");
		
		//map user -> 特征向量（关于点击数据）
		HashMap<String,ArrayList<Integer>> dataset = new HashMap<String,ArrayList<Integer>>();
		Map<String,String> hset = this.redis.hgetall("click");  //点击数据
		
		//用户点击数据向量化
		for(String username : hset.keySet()){
			String clickDate = hset.get(username);
			
			ArrayList<Integer> userVec = new ArrayList<Integer>();
			for(int i = 0;i < musicArr.length;i++){
				if(clickDate.contains(musicArr[i])){
					userVec.add(1);
				}else{
					userVec.add(0);
				}
			}
			dataset.put(username, userVec);
		}
		
		return dataset;
	}

	public Object format() {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] model() {
		// TODO Auto-generated method stub
		//加载数据
		HashMap<String,ArrayList<Integer>> dataset = (HashMap<String,ArrayList<Integer>>) this.load();
		
		//计算不同用户之间的相似度
		//结果为 username -> username:weight;username:weight;.....
		ArrayList<String> us = s2a(dataset.keySet());

		//计算缓存
		Map<String,Double> cache = new HashMap<String,Double>();
		
		//保存model
		Map<String,String> mdl = new HashMap<String,String>();
		
		for(int i = 0;i < us.size() - 1;i++){
			
			ArrayList<Integer> me = dataset.get(us.get(i));
			String result = "";
			for(int j = 0;j < us.size();j++){
				if(i == j) continue;  //同一个人不计算
				
				ArrayList<Integer> your = dataset.get(us.get(j));
				
				String key = us.get(i) + "#" + us.get(j);
				double weight = 0;
				//判断是否已经计算过
				if(cache.containsKey(key)){
					weight = cache.get(key);
				}else{
					weight = similar(me,your);
					cache.put(us.get(i) + "#" + us.get(j), weight);
					cache.put(us.get(j) + "#" + us.get(i), weight);
				}
				result += (us.get(j) + ":" + weight);
			}
			//保存结果
			mdl.put(us.get(i), result);
		}
		
		//持久化到redis
		this.redis.hmset("usercf", mdl);
		
 		return  null;
	}
	
	//余弦相似度计算
	public double similar(ArrayList<Integer> a,ArrayList<Integer> b){
		double numerator = 0;
		double denominators = 0;
		
		//计算分子
		for(int i = 0;i < a.size();i++){
			for(int j = 0;j < b.size();j++){
				numerator += (a.get(i) * b.get(j));
			}
		}
		
		//计算分母
		double tmp1 = 0, tmp2= 0;
		for(int i = 0;i < a.size();i++){
			tmp1 += Math.pow(a.get(i), 2);
			tmp2 += Math.pow(b.get(i), 2);
		}
		denominators += (Math.sqrt(tmp1) * Math.sqrt(tmp2));
		
		return numerator / denominators;
	}
	
	
	public static ArrayList<String> s2a(Set<String> st){
		ArrayList<String> tmp =new  ArrayList<String>();
		for(String item : st){
			tmp.add(item);
		}
		return tmp;
	}

	public Object predictOne() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
