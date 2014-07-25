package com.yesmynet.page.dto.htmlinput;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class CheckBoxOrRadio extends AbstractControl{
	private Type type=Type.Checkbox; 
	private List<Option> options;
	private List<String> values;
	@Override
	protected String getHtmlTemplate() {
		StringBuilder re=new StringBuilder();
		int optionLength=CollectionUtils.isNotEmpty(options)?options.size():0;
		for(int i=0;i<optionLength;i++)
		{
			re.append("{");
			re.append(i);
			re.append("}");
		}
		
		return re.toString();
	}
	@Override
	protected Object[] getHtmlDatas() {
		int optionLength=CollectionUtils.isNotEmpty(options)?options.size():0;
		List<String> datas=new ArrayList<String>(optionLength+2);
		final String htmlTemplate="<input type=''"+ type.getHtmlType() +"'' name=''{1}'' id=''{2}'' value=''{0}'' style=''{3}'' class=''{4}'' {5} {7}>{6}</input>\n";
		if(CollectionUtils.isNotEmpty(options))
        {
            for(Option option:options)
            {
                String selected=isOptionSelected(option,values)?"checked":"";
                datas.add(MessageFormat.format(htmlTemplate, option.getValue(),name,"","","","",option.getTitle(),selected));
            }
        }
		
		return datas.toArray();
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	/**
     * 判断选项是否选中
     * @param curOption
     * @param allSelected
     * @return
     */
    private boolean isOptionSelected(Option curOption,List<String> allSelected )
    {
        boolean re=false;
        if(CollectionUtils.isNotEmpty(allSelected))
        {
        	re=allSelected.contains(curOption.getValue());
        }
        return re;
    }
    public enum Type
    {
    	Radio("radio"),
    	Checkbox("checkbox");
    	private String htmlType;
    	private Type(String htmlType)
    	{
    		this.htmlType=htmlType;
    	}
		public String getHtmlType() {
			return htmlType;
		}
		
    	
    }
}
