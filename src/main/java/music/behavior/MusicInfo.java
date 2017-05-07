package music.behavior;

import java.util.Map;

import com.mysql.jdbc.StringUtils;

import music.tools.RedisUtils;

public class MusicInfo {
	
	private RedisUtils redis;
	
	public MusicInfo(){
		this.redis = new RedisUtils("127.0.0.1",6379);
	}
	
	
	/**
	 * 
	* @Title: set 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param musicname
	* @param @param bean    设定文件 
	* @return void    返回类型 
	* @throws
	* bean = img#title#nb#src#time#name#singer#album
	 */
	public void set(String musicname,String bean){
		
		if(!StringUtils.isNullOrEmpty(musicname) && !StringUtils.isNullOrEmpty(bean)){
			
			this.redis.hset("musicinfo", musicname, bean);
		}
		
	}
	
	
	public String get(String musicname){
		return this.redis.hget("musicinfo", musicname);
	}
	
	public Map<String,String> getall(){
		return this.redis.hgetall("musicinfo");
	}
	

}
