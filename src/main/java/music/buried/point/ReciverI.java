package music.buried.point;

import music.pb.Music.BuriedPoint;

/**
 * 
* @ClassName: ReciverI 
* @Description: TODO(定义埋点采集接口) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月14日 下午5:05:32 
*
 */
public interface ReciverI {
	
	/**
	 * 
	* @Title: save 
	* @Description: TODO(按一定格式保存埋点信息) 
	* @param @param eItem    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void save(BuriedPoint.Builder eItem);

}
