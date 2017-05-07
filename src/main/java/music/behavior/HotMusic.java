package music.behavior;

import music.tools.RedisUtils;

/**
 * 
* @ClassName: HotMusic 
* @Description: TODO(获取热门歌曲) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年5月7日 下午3:13:52 
*
 */
public class HotMusic {
	private RedisUtils redis;
	
	public HotMusic(){
		this.redis = new RedisUtils("127.0.0.1",6379);
	}
	

}
