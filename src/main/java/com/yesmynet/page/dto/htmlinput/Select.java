package com.yesmynet.page.dto.htmlinput;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class Select extends AbstractControl{
	private List<Option> options;
	private List<String> values;
	@Override
	protected String getHtmlTemplate() {
		return "<select name=''{1}'' id=''{2}'' style=''{3}'' class=''{4}'' {5} >{0}</select>";
	}
	@Override
	protected Object[] getHtmlDatas() {
		return new Object[] {getOptionsHtml(),name,"","","",""};
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
     * 得到下拉框的所有选项的html字符串
     * @return
     */
    private String getOptionsHtml()
    {
        StringBuilder re=new StringBuilder();
        List<Option> value2 = this.getOptions();
        String optionTempalte="<option value='%1$s' data-parentValue='%4$s' %2$s>%3$s</option>\n";
        re.append(String.format(optionTempalte, "","",""));
        
        if(!CollectionUtils.isEmpty(value2))
        {
            for(Option option:value2)
            {
                String selected=isOptionSelected(option,values)?"selected":"";
                String parentValue=this.isHideByParent()?this.getParentValue():"";
                String format = String.format(optionTempalte, option.getValue(),selected,option.getTitle(),parentValue);
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
    private boolean isOptionSelected(Option curOption,List<String> allSelected )
    {
        boolean re=false;
        if(CollectionUtils.isNotEmpty(allSelected))
        {
        	re=allSelected.contains(curOption.getValue());
        }
        return re;
    }
	
}
