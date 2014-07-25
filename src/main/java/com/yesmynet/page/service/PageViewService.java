package com.yesmynet.page.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.yesmynet.page.dto.PageViewComponent;

public class PageViewService {
	public String showHtml(PageViewComponent data)
	{
		List<PageViewComponent> datas=new ArrayList<PageViewComponent>();
		datas.add(data);
		StringBuilder sb=new StringBuilder();
		showHtmlInternal(datas,sb);
		return sb.toString();
	}
	public String showTreeJson(PageViewComponent data)
	{
		StringBuilder sb=new StringBuilder();
		showTreeInternal(data,sb);
		return sb.toString();
	}
	/**
	 * 以广度优先，遍历树的所有结点
	 * @param datas
	 * @return
	 */
	private void showHtmlInternal(List<PageViewComponent> datas,StringBuilder sb)
	{
		List<PageViewComponent> allChildren=new ArrayList<PageViewComponent>();
		if(CollectionUtils.isNotEmpty(datas))
		{
			for(PageViewComponent node:datas)
			{
				List<PageViewComponent> children =null;
				children =node.getChildren();
				if(CollectionUtils.isNotEmpty(children)) allChildren.addAll(children);
				
				String viewHtml = node.getViewHtml();
				sb.append(viewHtml);
			}
			showHtmlInternal(allChildren,sb);
		}
	}
	/**
	 * 深度优先，遍历树，得到一个Json
	 * @param currentDatas
	 */
	private void showTreeInternal(PageViewComponent currentDatas,StringBuilder sb)
	{
		sb.append("\n{\"id\":\"").append(currentDatas.getId()).append("\",\n");
		sb.append("\"children\":[");
		List<PageViewComponent> children = currentDatas.getChildren();
		if(CollectionUtils.isNotEmpty(children))
		{
			for(PageViewComponent c:children)
			{
				showTreeInternal(c,sb);			
			}
		}
		
		sb.append("]\n");
		sb.append("}\n");
	}
}
