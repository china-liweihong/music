package music.proxy.login.imp;

import org.apache.ibatis.session.SqlSession;

import music.beans.UserBean;
import music.mapper.UserMapper;
import music.pb.Music.LoginOrRegMessage;
import music.proxy.login.inf.UserLoginI;
import music.tools.DBTools;

public class UserLoginImp implements UserLoginI{

	public boolean isLogin(UserBean user) {
		// TODO Auto-generated method stub
		boolean isExist = false;
		SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        	UserBean us=    mapper.selectUserByUsername(user.getUsername()); 
        	if(us != null && us.getUsername().equals(user.getUsername()) && us.getPassword().equals(user.getPassword())){
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
		}
		return result;
	}
	
	/*public static void main(String[] args){
		UserLoginImp ulp = new UserLoginImp();
		UserBean us = new UserBean("灿杰","123456");
		LoginOrRegMessage.Builder lr = ulp.login(us);
		System.out.println(lr.getStatus());
		System.out.println(lr.getMessage());
	}*/
}
