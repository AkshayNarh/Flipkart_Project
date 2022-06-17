package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.BaseClass1;
import ListenersClasses.ListenersClass;
import PomClasses.Home_Page;
import PomClasses.Login_Page;
import PomClasses.ProductDetails_page;

@Listeners(ListenersClass.class)

public class VerifyUserCanRemoverProductsFromCart {
	
	WebDriver driver;
	Login_Page lp;
	Home_Page hp;
	ProductDetails_page pdp;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	
	

	@BeforeClass
	public void beforeClass()
	{
		htmlReporter = BaseClass1.getHtmlReporter();
		report = BaseClass1.getExtentReport();
		test = BaseClass1.getTestForReporter("VerifyUserCanRemoverProductsFromCart");
		driver = BaseClass1.getDriver("chrome");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		lp = new Login_Page(driver);
		hp = new Home_Page(driver);
		pdp = new ProductDetails_page(driver);
	}
	
	@Test
	public void verifyUserCanGoToCart()
	{
		hp.clickCartButton();
		Assert.assertEquals("", "");
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test is passed " + result.getName());
		}
		else
		{
			String path = hp.getScreenShot(driver, result.getName());
			test.log(Status.FAIL, "Test is failed " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	
	@AfterClass
	public void afterClass()
	{
		report.flush();
	}

}
