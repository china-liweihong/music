package music.beans;

/**
 * 
* @ClassName: MusicBean 
* @Description: TODO(音乐本身对象) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月12日 下午2:23:37 
*
 */
public class MusicBean {
	
	private String musicname;
	private String musiclyric;
	private String duration;
	private String composer;
	private String singer;
	private String album;
	private String path;
	
	public MusicBean(){}
	
	public MusicBean(String musicname,String musiclyric,String duration,String composer,
				String singer,String album,String path){
		this.musicname = musicname;
		this.musiclyric = musiclyric;
		this.duration  = duration;
		this.composer = composer;
		this.singer  = singer;
		this.album  = album;
		this.path = path;
	}
	
	public String getMusicname() {
		return musicname;
	}
	public void setMusicname(String musicname) {
		this.musicname = musicname;
	}
	public String getMusiclyric() {
		return musiclyric;
	}
	public void setMusiclyric(String musiclyric) {
		this.musiclyric = musiclyric;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.musicname + "," + this.musiclyric + "," + this.duration + "," + this.composer + "," +
					this.album + "," + this.path + "]";
	}
	
	

}
