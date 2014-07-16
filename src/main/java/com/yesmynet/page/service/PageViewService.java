package com.yesmynet.page.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.yesmynet.page.dto.Node;
import com.yesmynet.page.dto.PageViewComponent;

public class PageViewService {
	public String showHtml(Node<PageViewComponent> data)
	{
		List<Node<PageViewComponent>> datas=new ArrayList<Node<PageViewComponent>>();
		datas.add(data);
		StringBuilder sb=new StringBuilder();
		showHtmlInternal(datas,sb);
		return sb.toString();
	}
	/**
	 * 以广度优先，遍历树的所有结点
	 * @param datas
	 * @return
	 */
	private void showHtmlInternal(List<Node<PageViewComponent>> datas,StringBuilder sb)
	{
		List<Node<PageViewComponent>> allChildren=new ArrayList<Node<PageViewComponent>>();
		if(CollectionUtils.isNotEmpty(datas))
		{
			for(Node<PageViewComponent> node:datas)
			{
				List<Node<PageViewComponent>> children = node.getChildren();
				if(CollectionUtils.isNotEmpty(children)) allChildren.addAll(children);
				
				PageViewComponent data = node.getData();
				if(data!=null)
				{
					String viewHtml = data.getViewHtml();
					sb.append(viewHtml);
				}
			}
			showHtmlInternal(allChildren,sb);
		}
	}
}
