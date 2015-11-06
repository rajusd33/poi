package com.paxovision.framework.kw;

public class TestStep {
	
	private String stepId;
	private String page;
	private String element;
	private String keyword;
	private String data;
	
	
	public TestStep(){
	}
	
	public TestStep(String stepId, String page, String element, String keyword,
			String data) {
		super();
		this.stepId = stepId;
		this.page = page;
		this.element = element;
		this.keyword = keyword;
		this.data = data;
	}
	
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TestStep [stepId=" + stepId + ", page=" + page + ", element="
				+ element + ", keyword=" + keyword + ", data=" + data + "]";
	}
	

	
}
