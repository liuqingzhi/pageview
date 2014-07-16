package com.yesmynet.page.service;

import java.util.ArrayList;
import java.util.List;

import com.yesmynet.page.dto.Field;
import com.yesmynet.page.dto.Field.HtmlType;
import com.yesmynet.page.dto.Node;
import com.yesmynet.page.dto.PageObject;
import com.yesmynet.page.dto.PageViewComponent;

import junit.framework.TestCase;

public class PageViewServiceTest extends TestCase {

	public void testShowHtml() {
		PageViewService service=new PageViewService();
		Node<PageViewComponent> datas = getDatas();
		String showHtml = service.showHtml(datas);
		System.out.println(showHtml);
	}
	private Node<PageViewComponent> getDatas()
	{
		Node<PageViewComponent> datas=new Node<PageViewComponent>();
		PageObject pageObject=new PageObject();
		List<Field> fields=new ArrayList<Field>();
		pageObject.setTitle("页面测试1");
		pageObject.setFields(fields);
		Field f1=new Field();
		f1.setDescription("这是描述");
		f1.setHtmlType(HtmlType.InputText);
		f1.setId("id1");
		f1.setName("name1");
		f1.setTitle("这是标题");
		f1.setValue("field1Value");
		fields.add(f1);
		
		datas.setData(pageObject);
		return datas;
	}
}
