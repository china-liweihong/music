package music.proxy.login.inf;

import music.beans.UserBean;
import music.pb.Music.LoginOrRegMessage;

public interface UserLoginI {
	
	/**
	 * @deprecated 判断是否登陆
	 * @param UserBean
	 * @return Boolean
	 */
	public boolean isLogin(UserBean user);
	
	
	/**
	 * @deprecated 登陆
	 * @param UserBean
	 * @return  LoginOrRegMessage
	 */
	public LoginOrRegMessage.Builder login(UserBean user);

}
