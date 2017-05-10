package music.single;

import java.util.HashMap;
import java.util.Map;

import music.tools.RedisUtils;

public class SingleService {
	
	private RedisUtils redis;
	
	public SingleService(){
		this.redis = new RedisUtils("127.0.0.1",6379);
	}
	
	public void set(String order,String bean){
		this.redis.hset("single", order, bean);
	}
	
	public String get(String order){
		return this.redis.hget("single", order);
	}
	
	public Map<String,String> getPage(int first,int second){
		Map<String,String> result = new HashMap<String,String>();
		
		for(int i = first;i <= second;i++){
			result.put(i + "", this.redis.hget("single",i + ""));
		}
		
		return result;
	}
	
	public Map<String,String> getall(){
		return this.redis.hgetall("single");
	}

}
