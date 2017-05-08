package music.qk;

import java.util.Map;

import music.tools.RedisUtils;

public class QkService {
	
	private  RedisUtils redis;
	
	public QkService(){
		this.redis = new RedisUtils("127.0.0.1",6379);
	}
	
	public void set(String order,String bean){
		this.redis.hset("qk", order, bean);
	}
	
	public String get(String order){
		return this.redis.hget("qk", order);
	}
	
	public Map<String,String> getall(){
		return this.redis.hgetall("qk");
	}

}
