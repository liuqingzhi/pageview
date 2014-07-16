package com.yesmynet.page.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.yesmynet.page.dto.Node;
import com.yesmynet.page.dto.PageViewComponent;

public class PageViewService {
	public String showHtml(Node<? extends PageViewComponent> data)
	{
		List<Node<? extends PageViewComponent>> datas=new ArrayList<Node<? extends PageViewComponent>>();
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
	private void showHtmlInternal(List<Node<? extends PageViewComponent>> datas,StringBuilder sb)
	{
		List<Node<? extends PageViewComponent>> allChildren=new ArrayList<Node<? extends PageViewComponent>>();
		if(CollectionUtils.isNotEmpty(datas))
		{
			for(Node<? extends PageViewComponent> node:datas)
			{
				allChildren.addAll(node.getChildren());
				
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
