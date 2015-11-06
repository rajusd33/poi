package com.paxovision.framework.kw;

public class TestObject {
	
	private String objectId;
	private String page;
	private String element;
	private String findBy;
	private String using;
	
	public TestObject(){
	}
	
	public TestObject(String objectId, String page, String element,
			String findBy, String using) {
		super();
		this.objectId = objectId;
		this.page = page;
		this.element = element;
		this.findBy = findBy;
		this.using = using;
	}

	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public String getFindBy() {
		return findBy;
	}
	public void setFindBy(String findBy) {
		this.findBy = findBy;
	}
	public String getUsing() {
		return using;
	}
	public void setUsing(String using) {
		this.using = using;
	}

	
	@Override
	public String toString() {
		return "TestObject [objectId=" + objectId + ", page=" + page
				+ ", element=" + element + ", findBy=" + findBy + ", using="
				+ using + "]";
	}
	
}
