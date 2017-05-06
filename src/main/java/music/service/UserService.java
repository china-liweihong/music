package music.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import music.beans.UserBean;
import music.mapper.UserMapper;
import music.tools.DBTools;
import music.tools.Utils;

public class UserService {

    public static void main(String[] args) {
          /*UserService us = new UserService();
          us.deleteUser("灿杰");*/
    }
    
    
    /**
     * update
     */
    public void updateUser(String username,String password){
    	  SqlSession session = DBTools.getSession();
          UserMapper mapper = session.getMapper(UserMapper.class);
          UserBean user = new UserBean(username,Utils.getMD5(password));
          try {
              mapper.updateUser(user);
              System.out.println(user.toString());
               session.commit();
          } catch (Exception e) {
              e.printStackTrace();
              session.rollback();
          }
    }

    
    /**
     * 新增用户, 密码使用md5 加密
     */
    public  void insertUser(String username,String password) {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserBean user = new UserBean(username,Utils.getMD5(password));
        try {
            mapper.insertUser(user);
            System.out.println(user.toString());
             session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    
    
    /**
     * 删除用户
     */
    public void deleteUser(String username){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(username);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    
    
    /**
     * 根据id查询用户
     */
    public void selectUserByUsername(String username){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        UserBean user=    mapper.selectUserByUsername(username);
        System.out.println(user.toString());
            
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    
    /**
     * 查询所有的用户
     */
    public List<UserBean> selectAllUser(){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        List<UserBean> user = null;
        try {
        user=mapper.selectAllUser();
        System.out.println(user.toString());
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return user;
    }
    
}