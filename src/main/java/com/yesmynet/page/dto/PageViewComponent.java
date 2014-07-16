package com.yesmynet.page.dto;
/**
 * 表示可以在页面上显示的组件
 * @author liuqingzhi
 *
 */
public interface PageViewComponent {
	/**
	 * 得到用来显示的html.也就是自己负责把自己显示出来。
	 * @return
	 */
	public String getViewHtml();
}
