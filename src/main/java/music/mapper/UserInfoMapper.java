package music.mapper;

import java.util.List;

import music.beans.UserInfoBean;


public interface UserInfoMapper {
	   /**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUserInfo(UserInfoBean user) throws Exception;
    /**
     * 修改用戶
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    public int updateUserInfo (UserInfoBean user) throws Exception;
     /**
      * 刪除用戶
      * @param username
      * @return
      * @throws Exception
      */
    public int deleteUserInfo (String username) throws Exception;
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public UserInfoBean selectUserByUsername(String username) throws Exception;
     /**
      * 查询所有的用户信息
      * @return
      * @throws Exception
      */
    public List<UserInfoBean> selectAllUserInfo() throws Exception;
}
