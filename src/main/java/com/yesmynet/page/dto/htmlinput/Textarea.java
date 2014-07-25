package com.yesmynet.page.dto.htmlinput;

public class Textarea extends AbstractControl{
	private String value;
	@Override
	protected String getHtmlTemplate() {
		return "<textarea name=''{1}'' id=''{2}'' style=''{3}'' class=''{4}'' {5}>{0}</textarea>";
	}
	@Override
	protected Object[] getHtmlDatas() {
		return new Object[] {value,name,"","","",""};
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
