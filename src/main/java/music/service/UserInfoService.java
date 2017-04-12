package music.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import music.beans.UserInfoBean;
import music.mapper.UserInfoMapper;
import music.tools.DBTools;

public class UserInfoService {

    public static void main(String[] args) {
         UserInfoService us = new UserInfoService();
         
         UserInfoBean userinfo = new UserInfoBean("灿杰",24,"男","北京理工大学珠海学院","客色青青柳色轻","null",1);
         
         us.deleteUserInfo("灿杰");
    }

    
    /**
     * 新增用户信息
     */
    public  void insertUserInfo(UserInfoBean userinfo) {
        SqlSession session = DBTools.getSession();
        UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
        try {
            mapper.insertUserInfo(userinfo);
            System.out.println(userinfo.toString());
             session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    
    
    /**
     * 删除用户
     */
    public void deleteUserInfo(String username){
        SqlSession session=DBTools.getSession();
        UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
        try {
            mapper.deleteUserInfo(username);
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
        UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
        try {
        UserInfoBean user=    mapper.selectUserByUsername(username);
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
    public void selectAllUserInfo(){
        SqlSession session=DBTools.getSession();
        UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
        try {
        List<UserInfoBean> user=mapper.selectAllUserInfo();
        System.out.println(user.toString());
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    
}