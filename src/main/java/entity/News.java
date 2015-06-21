package entity;

import java.util.Date;

public class News implements Entity {

	private static final long serialVersionUID = -93255043726172454L;
	
	private Integer newsID;
	private String shortText;
	private String fullText;
	private Date creationDate;
	
	public int getNewsID() {
		return newsID;
	}
	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}
	public String getShortText() {
		return shortText;
	}
	public void setShortText(String shortText) {
		this.shortText = shortText;
	}
	public String getFullText() {
		return fullText;
	}
	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	private Date modificationDate;
}
