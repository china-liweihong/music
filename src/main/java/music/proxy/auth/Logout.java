package music.proxy.auth;

import com.mysql.jdbc.StringUtils;

import music.tools.RedisUtils;

/**
 * 
* @ClassName: Logout 
* @Description: TODO(简单模拟注销操作) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月14日 下午2:08:15 
*
 */
public class Logout implements SetCookie{
	private RedisUtils redis;
	
	public Logout(){
		this.redis = new RedisUtils("127.0.0.1",6379);
	}

	public String setCookie(String username, String cookie, int expire) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delCookie(String username) {
		// TODO Auto-generated method stub
		if(!StringUtils.isNullOrEmpty(username)){
			try{
				if(this.redis.exists(username)){
					this.redis.del(username);
				}
			} catch(Exception e){
				this.redis = new RedisUtils("127.0.0.1",6379);
				if(this.redis.exists(username)){
					this.redis.del(username);
				}
			}
		}
		return false;
	}

	public String updateCookie(String username, String cookie, int expire) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCookie(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
