package com.yesmynet.page.dto;

import java.text.MessageFormat;
import java.util.List;

/**
 * 表示一个字段，即一个输入框。
 * @author liuqingzhi
 *
 */
public class Field implements PageViewComponent {
	/**
	 * 表示显示字段时要使用的html输入框的类型
	 * @author liuqingzhi
	 *
	 */
	public enum HtmlType
	{
		/**
		 * 单行文本框
		 */
		InputText("单行文本",true,"<input type=''text'' name=''{1}'' style=''{2}'' class=''{3}'' value=''{0}'' {4}>"),
		/**
		 * 多行文本框
		 */
		TextArea("多行文本",true,"<textarea name=''{1}'' style=''{2}'' class=''{3}'' {4}>{0}</textarea>"),
		/**
	     * html中的hidden输入控件 
	     */
	    InputHidden("Hidden输入控件",true,"<input type=''hidden'' name=''{1}''  style=''{2}'' class=''{3}'' value=''{0}'' {4}>"),
	    /**
	     * html中的select输入控件 
	     */
	    Select("下拉框",false,"<select name=''{1}''  style=''{2}'' class=''{3}'' {4}>{0}</select>"),
	    /**
		 * 单选radio
		 */
		Radio("单选",true,"<input type=''radio'' name=''{1}'' value=''{0}'' style=''{2}'' class=''{3}'' {4} {6}>{5}</input>\n"),
		/**
		 * 多选checkbox
		 */
		Checkbox("多选",false,"<input type=''checkbox'' name=''{1}'' value=''{0}'' style=''{2}'' class=''{3}'' {4} {6}>{5}</input>\n"),
		/**
		 * 按钮Button
		 */
		Button("按钮",true,"<input type=''button'' name=''{1}'' value=''{0}'' style=''{2}'' class=''{3}'' {4}/>\n"),
		/**
		 * 文件上传
		 */
		File("文件上传",true,"<input type=''file'' name=''{1}'' value=''{0}'' style=''{2}'' class=''{3}'' {4}/>\n")
	    ;
		/**
		 * 显示在界面上的类型名称
		 */
	    private String title;
	    /**
	     * 是否只有一个值。
	     * 因为html中有些输入框有些只能输入一个值，有些可以输入多个值；前者如：单行文本框、多行文本框，后者如
	     * checkbox框，多选的下拉框。
	     */
	    private boolean onlyOneValue;
	    /**
	     * 显示本类型的参数时的html模板
	     */
	    private String htmlTemplate;
	    private HtmlType(String title,boolean onlyOneValue,String htmlTemplate)
	    {
	        this.title=title;
	        this.htmlTemplate=htmlTemplate;
	        this.onlyOneValue=onlyOneValue;
	    }
	    /**
	     * 得到显示的名称
	     * @return
	     * @author 刘庆志
	     */
	    public String getTitle()
	    {
	        return title;
	    }
	    /**
	     * 得到显示本类型的参数时的html模板
	     *
	     * @return
	     */
		public String getHtmlTemplate() {
			return htmlTemplate;
		}
		/**
		 * 是否只有一个值。
		 * 因为html中有些输入框有些只能输入一个值，有些可以输入多个值；前者如：单行文本框、多行文本框，后者如
	     * checkbox框，多选的下拉框。
		 * @return true表示只能有一个值，false表示可以有多个值
		 */
		public boolean isOnlyOneValue() {
			return onlyOneValue;
		}
	}
	/**
	 * 表示下拉框中的选项
	 * @author liuqingzhi
	 *
	 */
	public static class Option
	{
		private String title;
		private String value;
		private Boolean selected;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Boolean getSelected() {
			return selected;
		}
		public void setSelected(Boolean selected) {
			this.selected = selected;
		}
		
	}
	private String id;
	private HtmlType htmlType;
	private String title;
	private String description;
	private String value;
	private List<Option> options;
	
	public String getViewHtml() {
		String htmlTemplate = htmlType.getHtmlTemplate();
		MessageFormat.format(htmlTemplate,datas);
		return null;
	}

}
