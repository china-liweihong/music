package music.mapper;

import java.util.List;

import music.beans.MusicBean;



public interface MusicMapper {
    /**
     * 新增用戶
     * @param user
     * @return
     * @throws Exception
     */
    public int insertMusic(MusicBean user) throws Exception;
    /**
     * 修改用戶
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    public int updateMusic (MusicBean user) throws Exception;
     /**
      * 刪除用戶
      * @param username
      * @return
      * @throws Exception
      */
    public int deleteMusic(String musicname) throws Exception;
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public MusicBean selectMusicByMusicname(String musicname) throws Exception;
     /**
      * 查询所有的用户信息
      * @return
      * @throws Exception
      */
    public List<MusicBean> selectAllMusic() throws Exception;
}