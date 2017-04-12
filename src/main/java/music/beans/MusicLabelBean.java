package music.beans;


/**
 * 
* @ClassName: MusicLabelBean 
* @Description: TODO(音乐标签特征) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月12日 下午2:29:12 
*
 */
public class MusicLabelBean {
	
	private String musicname;
	private String singer;
	private String languages;
	private String style;
	private String scene;
	private String emotion;
	private String theme;
	
	public MusicLabelBean(){}
	
	public MusicLabelBean(String musicname,String singer,String languages,String style,
				String scene,String emotion,String theme){
		this.musicname = musicname;
		this.singer = singer;
		this.languages  = languages;
		this.style = style;
		this.scene = scene;
		this.emotion = emotion;
		this.theme  = theme;
	}
	
	
	public String getMusicname() {
		return musicname;
	}
	public void setMusicname(String musicname) {
		this.musicname = musicname;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getScene() {
		return scene;
	}
	public void setScene(String scene) {
		this.scene = scene;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.musicname + "," + this.singer + "," + this.languages + "," + this.style +
					"," + this.scene + "," + this.emotion + "," + this.theme + "]";
	}
	
	

}
