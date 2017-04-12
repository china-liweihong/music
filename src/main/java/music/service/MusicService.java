package music.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import music.beans.MusicBean;
import music.beans.UserBean;
import music.mapper.MusicMapper;
import music.mapper.UserMapper;
import music.tools.DBTools;
import music.tools.Utils;

public class MusicService {

    public static void main(String[] args) {
         MusicService ms  = new MusicService();
         
         ms.deleteMusic("一纸流年");
    }

    
    /**
     * 新增用户, 密码使用md5 加密
     */
    public  void insertMusic(MusicBean mb) {
        SqlSession session = DBTools.getSession();
        MusicMapper mapper = session.getMapper(MusicMapper.class);
        try {
            mapper.insertMusic(mb);
            System.out.println(mb.toString());
             session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    
    
    /**
     * 删除用户
     */
    public void deleteMusic(String musicname){
        SqlSession session=DBTools.getSession();
        MusicMapper mapper=session.getMapper(MusicMapper.class);
        try {
            mapper.deleteMusic(musicname);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    
    
    /**
     * 根据id查询用户
     */
    public void selectMusicByMusicname(String musicname){
        SqlSession session=DBTools.getSession();
        MusicMapper mapper=session.getMapper(MusicMapper.class);
        try {
        MusicBean music=    mapper.selectMusicByMusicname(musicname);
        System.out.println(music.toString());
            
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    
    /**
     * 查询所有的用户
     */
    public void selectAllMusic(){
        SqlSession session=DBTools.getSession();
        MusicMapper mapper=session.getMapper(MusicMapper.class);
        try {
        List<MusicBean> music=mapper.selectAllMusic();
        System.out.println(music.toString());
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    
}