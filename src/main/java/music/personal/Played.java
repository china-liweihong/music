package music.personal;

import com.mysql.jdbc.StringUtils;

import music.tools.RedisUtils;

public class Played implements PersonalBehavior{

	private RedisUtils redis;
	
	public Played(){
		this.redis = new RedisUtils("127.0.0.1",6379);
	}
	
	//username#mp3,singer,album
	public void savePlayed(String content) {
		// TODO Auto-generated method stub
		if(!StringUtils.isNullOrEmpty(content)){
			String[] items = content.split("#");
			String oldPlayed = "";
			try{
				oldPlayed = this.redis.hget("played", items[0]);
				if(oldPlayed == null) oldPlayed = items[1] + "#";
				else{
					//是否已经存在
					if(!oldPlayed.contains(items[1]))
						oldPlayed += items[1] + "#";
				}
				this.redis.hset("played", items[0], oldPlayed);
			} catch(Exception e){
				this.redis = new RedisUtils("127.0.0.1",6379);
				this.redis.hset("played", items[0], oldPlayed);
			}
		}
		
		
	}

	public String getPlayed(String username) {
		// TODO Auto-generated method stub
		String played = "";
		try{
			played = this.redis.hget("played", username);
		} catch(Exception e){
			this.redis = new RedisUtils("127.0.0.1",6379);
			played = this.redis.hget("played", username);
		}
		return played;
	}

}
