package com.yesmynet.page.dto.htmlinput;

import com.yesmynet.page.dto.PageViewComponent;

public class InputText extends AbstractControl{
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	protected String getHtmlTemplate() {
		return "<input type=''text'' name=''{1}'' id=''{2}'' style=''{3}'' class=''{4}'' {5} value=''{0}''>";
	}
	@Override
	protected Object[] getHtmlDatas() {
		return new Object[] {value,name,"","","",""};
	}

}
