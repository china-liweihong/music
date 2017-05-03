package music.proxy.login.imp;

import org.apache.ibatis.session.SqlSession;

import music.beans.UserBean;
import music.mapper.UserMapper;
import music.pb.Music.LoginOrRegMessage;
import music.proxy.auth.SetCookie;
import music.proxy.login.inf.UserLoginI;
import music.tools.DBTools;
import music.tools.RedisUtils;
import music.tools.Utils;

/**
 * 
* @ClassName: UserLoginImp 
* @Description: TODO(用于用户登陆使用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月13日 下午4:03:12 
*
 */
public class UserLoginImp implements UserLoginI,SetCookie{
	
	private RedisUtils redis;
	private String username;
	private String password;
	
	public UserLoginImp(){
		this.redis = new RedisUtils("127.0.0.1",6379);
	}

	public boolean isLogin(UserBean user) {
		// TODO Auto-generated method stub
		boolean isExist = false;
		SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        	UserBean us=    mapper.selectUserByUsername(user.getUsername()); 
        	if(us != null && us.getUsername().equals(user.getUsername()) && us.getPassword().equals(Utils.getMD5(user.getPassword()))){
        		isExist = true;
        	}
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return isExist;
	}

	public LoginOrRegMessage.Builder login(UserBean user) {
		// TODO Auto-generated method stub
		LoginOrRegMessage.Builder result = LoginOrRegMessage.newBuilder();
		if(!this.isLogin(user)){
			result.setStatus(0);
			result.setMessage("登陆失败,用户名或密码失败");
		}else{
			result.setStatus(1);
			result.setMessage("登陆成功！");
			
			//保存状态
			String cookie = Utils.getMD5(user.getUsername() + "#1");
			int expire = 3600 * 3;
			this.setCookie(user.getUsername(), cookie, expire);
		}
		return result;
	}
	
	/**
	 * 默认cookie有效期为3个小时
	 */
	public String setCookie(String username, String cookie, int expire) {
		// TODO Auto-generated method stub
		//String token = username + Math.random();
		try{
			this.redis.setex(username, cookie, expire);
		} catch(Exception e){
			this.redis = new RedisUtils("127.0.0.1",6379);
			this.redis.setex(username, cookie, expire);
		}
		return cookie;
	}

	public boolean delCookie(String username) {
		// TODO Auto-generated method stub
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

	
	/*public static void main(String[] args){
		UserLoginImp ulp = new UserLoginImp();
		UserBean us = new UserBean("灿杰","123456");
		LoginOrRegMessage.Builder lr = ulp.login(us);
		System.out.println(lr.getStatus());
		System.out.println(lr.getMessage());
	}*/
}
