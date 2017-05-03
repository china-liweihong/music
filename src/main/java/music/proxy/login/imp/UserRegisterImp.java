package music.proxy.login.imp;

import org.apache.ibatis.session.SqlSession;

import music.beans.UserBean;
import music.mapper.UserMapper;
import music.service.UserService;
import music.pb.Music.LoginOrRegMessage;
import music.proxy.login.inf.UserRegisterI;
import music.tools.DBTools;

public class UserRegisterImp implements UserRegisterI{
	
	public boolean isExistUser(UserBean user) {
		// TODO Auto-generated method stub
		SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        	UserBean isExist=    mapper.selectUserByUsername(user.getUsername());
        	if(isExist != null && isExist.getUsername().equals(user.getUsername())){
        		return true;
        	}
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
		return false;
	}

	public LoginOrRegMessage.Builder register(UserBean user) {
		// TODO Auto-generated method stub
		LoginOrRegMessage.Builder result = LoginOrRegMessage.newBuilder();
		if(this.isExistUser(user)){
			result.setStatus(0);
			result.setMessage("用户已经存在！");
		}else{
			UserService us = new UserService();
			us.insertUser(user.getUsername(), user.getPassword());
			result.setStatus(1);
			result.setMessage("注册用户成功");
			
		}
		return result;
	}

	public static void main(String[] args){
		UserBean user = new UserBean("灿杰","123456");
		UserRegisterImp uri = new UserRegisterImp();
		LoginOrRegMessage.Builder lr = uri.register(user);
		System.out.println(lr.getStatus());
		System.out.println(lr.getMessage());
	
	}
}
