package com.yesmynet.page.dto;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * 表示一个要显示的对象，它有多个字段。
 * @author liuqingzhi
 *
 */
public class PageObject implements PageViewComponent {
	private String title;
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
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public String getViewHtml() {
		StringBuilder sb=new StringBuilder();
		sb.append("<fieldset>");
		sb.append("<legend>").append(title).append("</legend>");
		if(CollectionUtils.isNotEmpty(fields))
		{
			for(Field f:fields)
			{
				sb.append(f.getTitle()).append(":").append(f.getViewHtml()).append("<br>");
			}
		}
		
		sb.append("</fieldset>");
		return sb.toString();
	}

}
