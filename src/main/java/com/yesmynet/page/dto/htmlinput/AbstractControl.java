package com.yesmynet.page.dto.htmlinput;

import java.text.MessageFormat;

import com.yesmynet.page.dto.PageViewComponent;

public abstract class AbstractControl implements PageViewComponent {
	protected String id;
	protected String name;
	protected String title;
	protected String description;
	
	protected abstract String getHtmlTemplate();
	protected abstract Object[] getHtmlDatas();
	protected boolean isShowTitle()
	{
		return true;
	}
	public String getViewHtml() {
		String re=null;
        String htmlTemplate = this.getHtmlTemplate();
        Object[] htmlDatas = this.getHtmlDatas();
        re=MessageFormat.format(htmlTemplate, htmlDatas);
        if(this.isShowTitle())
        {
        	re="<div id='"+ id +"'><label>"+ title +"</label>"+re+"</div>";
        }
        return re;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
