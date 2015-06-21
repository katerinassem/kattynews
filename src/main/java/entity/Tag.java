package entity;

public class Tag implements Entity {

	private static final long serialVersionUID = -8637226865173147234L;
	
	private Integer tagId;
	private String tagName;
	
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
}
