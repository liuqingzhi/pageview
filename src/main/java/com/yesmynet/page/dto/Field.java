package com.yesmynet.page.dto;

import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

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
	private String name;
	private HtmlType htmlType;
	private String title;
	private String description;
	private String value;
	private List<Option> options;
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
	public HtmlType getHtmlType() {
		return htmlType;
	}
	public void setHtmlType(HtmlType htmlType) {
		this.htmlType = htmlType;
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public String getViewHtml() {
		return toHtml();
	}
	/**
     * 转成html代码
     * @return
     */
    public String toHtml()
    {
        String re=null;
        HtmlType htmlType2 = this.getHtmlType();
        String parameterName = this.getName();
        switch(htmlType2)
        {
        case InputText:
        case TextArea:
        case InputHidden:
        case Button:
        case File:
        	String inputValue=getValue();
        	if(HtmlType.Button.equals(htmlType2))
        	{
        		inputValue=getTitle();
        	}
            re=MessageFormat.format(htmlType2.getHtmlTemplate(), inputValue,parameterName,"","","");//style,styleClass,elementHtml);
            break;
        case Select:
            re=MessageFormat.format(htmlType2.getHtmlTemplate(), getOptionsHtml(),parameterName,"","","");//style,styleClass,elementHtml);
            break;
        case Radio:
        case Checkbox:
            re=toHtmlCheckBoxRadio();
            break;
        }
        
        
        return re;
    }
    private String toHtmlCheckBoxRadio()
    {
        StringBuilder re=new StringBuilder();
        HtmlType htmlType2 = this.getHtmlType();
        String htmlTemplate = htmlType2.getHtmlTemplate();
        List<Option> value2 = this.getOptions();
        String parameterName=this.getName();
        
        if(!CollectionUtils.isEmpty(value2))
        {
            for(Option option:value2)
            {
                String selected=isOptionSelected(option,this.getValue())?"checked":"";
                re.append(MessageFormat.format(htmlTemplate, option.getValue(),parameterName,"","","",option.getTitle(),selected));//style,styleClass,elementHtml,option.getText(),selected));
            }
        }
        return re.toString();
    }
    /**
     * 对于只有一个值的输入框（如：单选文本框，多行文本框等），得到输入的值
     * @return
     */
    public String getFieldValue()
    {
        return this.getValue();
    }
    /**
     * 得到下拉框的所有选项的html字符串
     * @return
     */
    private String getOptionsHtml()
    {
        StringBuilder re=new StringBuilder();
        List<Option> value2 = this.getOptions();
        if(!CollectionUtils.isEmpty(value2))
        {
            String optionTempalte="<option value='%1$s' %2$s>%3$s</option>\n";
            for(Option option:value2)
            {
                String selected=isOptionSelected(option,this.getValue())?"selected":"";
                String format = String.format(optionTempalte, option.getValue(),selected,option.getTitle());
                re.append(format);
            }
        }
        return re.toString();
    }
    /**
     * 判断选项是否选中
     * @param curOption
     * @param allSelected
     * @return
     */
    private boolean isOptionSelected(Option curOption,String allSelected )
    {
        boolean re=false;
        if(StringUtils.isNotBlank(curOption.getValue()) && StringUtils.isNotBlank(allSelected) && curOption.getValue().equals(allSelected))
            re=true;
        
        return re;
    }  
	
}
