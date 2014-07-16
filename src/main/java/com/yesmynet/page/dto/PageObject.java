package com.yesmynet.page.dto;

import java.util.List;

/**
 * 表示一个要显示的对象，它有多个字段。
 * @author liuqingzhi
 *
 */
public class PageObject implements PageViewComponent {
	private String title;
	private String value;
	private Boolean selected;
	/**
	 * 所有的字段
	 */
	private List<Field> fields;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public String getViewHtml() {
		// TODO Auto-generated method stub
		return null;
	}

}
