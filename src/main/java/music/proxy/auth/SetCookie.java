package music.proxy.auth;

/**
 * 
* @ClassName: SetCookie 
* @Description: TODO(用于保存用户的登陆状态，只起模拟作用，对安全性而已，并无大多保障) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月13日 下午3:55:13 
*
 */
public interface SetCookie {
	
	/**
	 * 
	* @Title: setCookie 
	* @Description: TODO(设置cookie) 
	* @param @param username
	* @param @param cookie
	* @param @param expire
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public String setCookie(String username,String cookie,int expire);
	
	/**
	 * 
	* @Title: delCookie 
	* @Description: TODO(删除cookie) 
	* @param @param username
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean delCookie(String username);
	
	
	/**
	 * 
	* @Title: updateCookie 
	* @Description: TODO(更新cookie) 
	* @param @param username
	* @param @param cookie
	* @param @param expire
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public String updateCookie(String username,String cookie,int expire);
	
	/**
	 * 
	* @Title: getCookie 
	* @Description: TODO(获取cookie) 
	* @param @param username
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public String getCookie(String username);

}
