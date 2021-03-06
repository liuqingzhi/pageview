package com.yesmynet.page.dto;

import java.util.ArrayList;
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
	private String parentValue;
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
	public String getParentValue() {
		return parentValue;
	}
	public void setParentValue(String parentValue) {
		this.parentValue = parentValue;
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
	public List<PageViewComponent> getChildren() {
		List<PageViewComponent> re=new ArrayList<PageViewComponent>();
		if(CollectionUtils.isNotEmpty(fields))
		{
			for(PageViewComponent c:fields)
			{
				List<PageViewComponent> children = c.getChildren();
				if(CollectionUtils.isNotEmpty(children))
					re.addAll(children);
			}
		}
		return re;
	}
	public List<Node> getNodeTree() {
		return null;
	}
	public boolean isHideByParent() {
		return true;
	}
}
