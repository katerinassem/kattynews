package entity;

import java.util.Date;

public class Author {

	private Integer authorID;
	private String authorName;
	private Date expired;
	
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Date getExpired() {
		return expired;
	}
	public void setExpired(Date expired) {
		this.expired = expired;
	}	
	
}