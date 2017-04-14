package music.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import music.beans.MusicBean;
import music.beans.MusicLabelBean;
import music.beans.UserBean;
import music.mapper.MusicLabelMapper;
import music.mapper.MusicMapper;
import music.mapper.UserMapper;
import music.tools.DBTools;
import music.tools.Utils;

public class MusicLabelService {

    public static void main(String[] args) {
         MusicLabelService ms  = new MusicLabelService();
         
         MusicLabelBean ml = new MusicLabelBean("一纸流年","古墨","国语","古风","江湖","飘逸","古风");
         
         ms.insertMusicLabel(ml);
    }

    
    /**
     * 新增用户, 密码使用md5 加密
     */
    public  void insertMusicLabel(MusicLabelBean mb) {
        SqlSession session = DBTools.getSession();
        MusicLabelMapper mapper = session.getMapper(MusicLabelMapper.class);
        try {
            mapper.insertMusicLabel(mb);
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
    public void deleteMusicLabel(String musicname){
        SqlSession session=DBTools.getSession();
        MusicLabelMapper mapper=session.getMapper(MusicLabelMapper.class);
        try {
            mapper.deleteMusicLabel(musicname);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    
    
    /**
     * 根据id查询用户
     */
    public void selectMusicLabelByMusicname(String musicname){
        SqlSession session=DBTools.getSession();
        MusicLabelMapper mapper=session.getMapper(MusicLabelMapper.class);
        try {
        MusicLabelBean music=    mapper.selectMusicLabelByMusicname(musicname);
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
    public void selectAllMusicLabel(){
        SqlSession session=DBTools.getSession();
        MusicLabelMapper mapper=session.getMapper(MusicLabelMapper.class);
        try {
        List<MusicLabelBean> music=mapper.selectAllMusicLabel();
        System.out.println(music.toString());
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
    
}