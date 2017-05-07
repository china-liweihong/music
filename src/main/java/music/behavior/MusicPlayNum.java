package music.behavior;

import java.util.ArrayList;
import java.util.Map;

import music.tools.RedisUtils;

/**
 * 
* @ClassName: MusicPlayNum 
* @Description: TODO(音乐播放次数) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年5月6日 上午11:15:37 
*
 */
public class MusicPlayNum {
	
	private RedisUtils redis;
	
	public MusicPlayNum(){
		this.redis = new RedisUtils("127.0.0.1",6379);
	}
	
	//增加播放次数
	public void inc(String musicname){
		String init;
		int add = 0;
		if(( init = this.redis.hget("musicplaynum", musicname)) != null){
			add = Integer.parseInt(init) + 1;
		}else{
			add = add + 1;
		}
		this.redis.hset("musicplaynum", musicname, add + "");
	}
	
	public String get(String musicname){
		return this.redis.hget("musicplaynum", musicname);
	}
	
	//获取全部
	public Map<String,String> getall(){
		return this.redis.hgetall("musicplaynum");
	}
	

}
