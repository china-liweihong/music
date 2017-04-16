package music.personal;

/**
 * 
* @ClassName: PersonalBehavior 
* @Description: TODO(个人操作接口) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月16日 下午4:45:36 
*
 */
public interface PersonalBehavior {
	
	/**
	 * 
	* @Title: played 
	* @Description: TODO(保存播放历史) 
	* @param @param content    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void savePlayed(String content);
	
	
	/**
	 * 
	* @Title: getPlayed 
	* @Description: TODO(获取播放历史) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String getPlayed(String username);

}
