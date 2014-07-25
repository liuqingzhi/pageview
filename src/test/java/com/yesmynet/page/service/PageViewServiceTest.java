package com.yesmynet.page.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yesmynet.page.dto.Node;
import com.yesmynet.page.dto.PageObject;
import com.yesmynet.page.dto.PageViewComponent;
import com.yesmynet.page.dto.htmlinput.CheckBoxOrRadio;
import com.yesmynet.page.dto.htmlinput.InputText;
import com.yesmynet.page.dto.htmlinput.Option;
import com.yesmynet.page.dto.htmlinput.Select;

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
		Node<PageViewComponent> datasChild=new Node<PageViewComponent>();
		
		PageObject pageObject=new PageObject();
		List<PageViewComponent> fields=new ArrayList<PageViewComponent>();
		pageObject.setId("pageObject1");
		pageObject.setTitle("页面测试1");
		pageObject.setFields(fields);
		InputText f1=new InputText();
		f1.setDescription("这是描述");
		f1.setId("id1");
		f1.setName("name1");
		f1.setTitle("这是field标题");
		f1.setValue("field1Value");
		fields.add(f1);
		
		
		
		CheckBoxOrRadio f2=new CheckBoxOrRadio();
		List<Option> options=new ArrayList<Option>();
		f2.setOptions(options);
		f2.setDescription("这是描述");
		f2.setId("id2");
		f2.setName("name2");
		f2.setTitle("选项标题");
		f2.setValues(Arrays.asList("o1Value","o3Value"));
		
		Option o1=new Option();
		o1.setTitle("选项1");
		o1.setValue("o1Value");
		options.add(o1);

		Option o2=new Option();
		o2.setTitle("选项2");
		o2.setValue("o2Value");
		options.add(o2);

		Option o3=new Option();
		o3.setTitle("选项3");
		o3.setValue("o3Value");
		options.add(o3);
		
		fields.add(f2);
		
		Select f3=new Select();
		f3.setOptions(options);
		f3.setDescription("这是描述");
		f3.setId("id3");
		f3.setName("name3");
		f3.setTitle("下拉框标题");
		f3.setValues(Arrays.asList("o1Value","o3Value"));
		fields.add(f3);
		
		
		datas.setData(pageObject);
		datasChild.setData(pageObject);
		datas.setChildren(Arrays.asList(datasChild));
		
		
		return datas;
	}
}
