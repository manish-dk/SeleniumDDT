package com.qa.DDT;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPage {
	
		@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
		private WebElement userField;
		
		@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
		private WebElement passField;
		
		@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
		private WebElement logLink;
		
		public void enterUser(String user) {
			userField.sendKeys(user);
		}
		
		public void enterPass(String pass) {
			passField.sendKeys(pass);
		}
		
		public void sendPass() {
			passField.submit();
		}
		
		public WebElement getLogLink() {
			return logLink;
		}

	


}
