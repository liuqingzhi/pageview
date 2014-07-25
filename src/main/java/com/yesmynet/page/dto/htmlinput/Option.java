package com.yesmynet.page.dto.htmlinput;
/**
 * 表示下拉框中的选项
 * @author liuqingzhi
 *
 */
public class Option
{
	private String title;
	private String value;
	private Boolean selected;
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
	
}