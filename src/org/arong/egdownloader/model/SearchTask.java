package org.arong.egdownloader.model;
/**
 * 搜索绅士站漫画列表任务模型
 * @author dipoo
 * @since 2015-03-11
 */
public class SearchTask {
	
	private String url;//下载地址
	
	private String name;//名称
	
	private String type;//分类
	
	private String coverUrl;//封面路径
	
	private String date;//发布时间
	
	private String btUrl;//bt下载地址
	
	private String uploader;//上传者
	
	private String author;
	
	public String getAuthor() {
		return author;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setBtUrl(String btUrl) {
		this.btUrl = btUrl;
	}

	public String getBtUrl() {
		return btUrl;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public String getUploader() {
		return uploader;
	}

	public String toString() {
		return "SearchTask [btUrl=" + btUrl + ", date=" + date + ", uploader="
				+ uploader + ", coverUrl=" + getCoverUrl()
				+ ", name=" + getName() + ", type=" + getType()
				+ ", url=" + getUrl() + "]";
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setName(String name) {
		this.name = name;
		if(name != null){
			if(name.indexOf("[") != -1 && name.indexOf("]") != -1 && name.indexOf("[") < name.indexOf("]")){
				author = name.substring(name.indexOf("[") + 1, name.indexOf("]"));
			}else if(name.indexOf("【") != -1 && name.indexOf("】") != -1 && name.indexOf("【") < name.indexOf("】")){
				author = name.substring(name.indexOf("【") + 1, name.indexOf("】"));
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public String getCoverUrl() {
		return coverUrl;
	}
	
}
