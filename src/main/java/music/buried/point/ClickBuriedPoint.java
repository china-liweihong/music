package music.buried.point;

import music.pb.Music.BuriedPoint.Builder;
import music.tools.RedisUtils;

/**
 * 
* @ClassName: ClickBuriedPoint 
* @Description: TODO(点击埋点) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月14日 下午5:16:23 
*
 */
public class ClickBuriedPoint implements ReciverI{
	
	private RedisUtils redis;
	
	public ClickBuriedPoint(){
		this.redis = new RedisUtils("127.0.0.1",6379);
	}
	
	
	//保存埋点信息 -- username -> musicname;musicname;...
	public void save(Builder eItem) {
		// TODO Auto-generated method stub
		String username = eItem.getUsername();
		String oldEvent = "";
		if(( oldEvent = this.redis.hget("click_buriedpoint", username)) != null){
			oldEvent += (eItem.getEMsg() + ";");
		}else{
			oldEvent = eItem.getEMsg() + ";";
		}
		this.redis.hset("click_buriedpoint", username, oldEvent);
	}

}
