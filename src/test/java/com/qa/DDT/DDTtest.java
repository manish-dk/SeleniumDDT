package com.qa.DDT;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DDTtest {
	WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	
	@BeforeClass
	public static void beforeClass() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\ddtreport.html",true);
	}
	
	@Before
	public void setup() throws Exception {
		ExcelUtils.setExcelFile(Constants.pathTestData + Constants.filesTestData, 0);
		System.setProperty("webdriver.chrome.driver", "C:/testing/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		driver.close();;
	}
	
	@AfterClass
	public static void afterClass() {
		report.flush();
		report.close();
	}
	
	@Test
	public void addTest() {
		
		for(int i=1;i<ExcelUtils.getExcelWSheet().getPhysicalNumberOfRows();i++) {
			
			test = report.startTest("Test" +i);
			driver.get(Constants.websiteURL);
			driver.manage().window().maximize();
			LogPage logPage = PageFactory.initElements(driver, LogPage.class);
			AddPage addPage = PageFactory.initElements(driver, AddPage.class);
			
			addPage.enterUser(ExcelUtils.getCellData(i, 0));
			addPage.enterPass(ExcelUtils.getCellData(i, 1));
			addPage.sendPass();
			
			addPage.getLogLink().click();
			
			logPage.enterUser(ExcelUtils.getCellData(i, 0));
			logPage.enterPass(ExcelUtils.getCellData(i, 1));
			
			if(logPage.checkText()) {
				test.log(LogStatus.PASS, "Login successful");
			}
			else {
				test.log(LogStatus.FAIL, "Login failed");
			}

			report.endTest(test);
		}
		
	}
	
}
