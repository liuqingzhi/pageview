package com.yesmynet.page.dto;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * 表示一个要显示的对象，它有多个字段。
 * @author liuqingzhi
 *
 */
public class PageObject implements PageViewComponent {
	private String id;
	private String title;
	/**
	 * 所有的字段
	 */
	private List<PageViewComponent> fields;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<PageViewComponent> getFields() {
		return fields;
	}
	public void setFields(List<PageViewComponent> fields) {
		this.fields = fields;
	}

	public String getViewHtml() {
		StringBuilder sb=new StringBuilder();
		sb.append("<fieldset id='").append(id).append("'>");
		sb.append("<legend>").append(title).append("</legend>");
		if(CollectionUtils.isNotEmpty(fields))
		{
			for(PageViewComponent f:fields)
			{
				sb.append(f.getViewHtml());
			}
		}
		
		sb.append("</fieldset>");
		return sb.toString();
	}

}
