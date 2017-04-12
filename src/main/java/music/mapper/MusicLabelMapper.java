package music.mapper;

import java.util.List;

import music.beans.MusicBean;
import music.beans.MusicLabelBean;



public interface MusicLabelMapper {
    /**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertMusicLabel(MusicLabelBean user) throws Exception;
    /**
     * 修改用戶
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    public int updateMusicLabel (MusicLabelBean user) throws Exception;
     /**
      * 刪除用戶
      * @param username
      * @return
      * @throws Exception
      */
    public int deleteMusicLabel(String musicname) throws Exception;
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public MusicLabelBean selectMusicLabelByMusicname(String musicname) throws Exception;
     /**
      * 查询所有的用户信息
      * @return
      * @throws Exception
      */
    public List<MusicLabelBean> selectAllMusicLabel() throws Exception;
}