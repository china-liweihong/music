package music.beans;


/**
 * 
* @ClassName: UserInfoBean 
* @Description: TODO(用户信息表) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月12日 下午1:32:57 
*
 */
public class UserInfoBean {
	private String username;
	private int age;
	private String sex;
	private String address;
	private String motto;
	private String photo;
	private int userType;
	
	public UserInfoBean(){}
	
	public UserInfoBean(String username,int age,String sex,String address,
						String motto,String photo,int userType){
		this.username = username;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.motto = motto;
		this.photo = photo;
		this.userType = userType;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.username + "," + this.age + "," + this.sex + "," + this.address + "," + this.motto + "," +
					this.photo + "," + this.userType + "]";
	}
	
}
