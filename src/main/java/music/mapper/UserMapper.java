package music.mapper;

import java.util.List;

import music.beans.UserBean;



public interface UserMapper {
    /**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(UserBean user) throws Exception;
    /**
     * 修改用戶
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    public int updateUser (UserBean user,int id) throws Exception;
     /**
      * 刪除用戶
      * @param username
      * @return
      * @throws Exception
      */
    public int deleteUser(String username) throws Exception;
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public UserBean selectUserByUsername(String username) throws Exception;
     /**
      * 查询所有的用户信息
      * @return
      * @throws Exception
      */
    public List<UserBean> selectAllUser() throws Exception;
}