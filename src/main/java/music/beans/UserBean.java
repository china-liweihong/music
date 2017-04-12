package music.beans;

import java.io.Serializable;

public class UserBean implements Serializable {

	/**
	 *  @deprecated  用户登陆表
	 *  @author canjie
	 *  @time 2017-02-18
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int type;
	
	public UserBean(){
		//默认
	}
	
	public UserBean(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserBean[type,username,password] = [" + this.type + "," + 
					this.username + "," + this.password +"]";
	}

}
