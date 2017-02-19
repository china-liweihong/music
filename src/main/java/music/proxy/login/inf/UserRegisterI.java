package music.proxy.login.inf;

import music.beans.UserBean;
import music.pb.Music.LoginOrRegMessage;

public interface UserRegisterI {
	
	/**
	 * @param user
	 * @return boolean
	 * @deprecated 判断是否存在该用户
	 */
	public boolean isExistUser(UserBean user);   //是否存在该用户
	

	/**
	 * @param user
	 * @return LoginOrRegMessage
	 * @deprecated 注册用户
	 */
	public LoginOrRegMessage.Builder register(UserBean user); //注册用户
	
	
}
