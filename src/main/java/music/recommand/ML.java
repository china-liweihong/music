package music.recommand;

/**
 * 
* @ClassName: ML 
* @Description: TODO(算法常用接口) 
* @author A18ccms a18ccms_gmail_com 
* @date 2017年4月14日 下午3:05:52 
*
 */
public interface ML {
	/**
	 * 
	* @Title: load 
	* @Description: TODO(加载数据) 
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	public Object load();
	
	/**
	 * 
	* @Title: format 
	* @Description: TODO(解析数据) 
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	public Object format();
	
	/**
	 * 
	* @Title: model 
	* @Description: TODO(获取模型) 
	* @param @return    设定文件 
	* @return byte[]    返回类型 
	* @throws
	 */
	public byte[] model();
	
	/**
	 * 
	* @Title: predictOne 
	* @Description: TODO(预测) 
	* @param @return    设定文件 
	* @return Object    返回类型 
	* @throws
	 */
	public Object predictOne();
}
