package com.yesmynet.page.dto;

import java.util.List;

/**
 * 表示可以在页面上显示的组件
 * @author liuqingzhi
 *
 */
public interface PageViewComponent {
	public String getId();
	/**
	 * 得到用来显示的html.也就是自己负责把自己显示出来。
	 * @return
	 */
	public String getViewHtml();
	public List<PageViewComponent> getChildren();
	public String getParentValue();
	public List<Node> getNodeTree();
	/**
	 * 是否让父元素把自己隐藏
	 * @return
	 */
	public boolean isHideByParent();
}
