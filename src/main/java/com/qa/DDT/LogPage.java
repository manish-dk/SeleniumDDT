package com.qa.DDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogPage {
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userField;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passField;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement text;
	
	public void enterUser(String user) {
		userField.sendKeys(user);
	}
	
	public void enterPass(String pass) {
		passField.sendKeys(pass);
		passField.submit();
	}
	
	public boolean checkText() {
		if(text.getText().equals("**Successful Login**")) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

