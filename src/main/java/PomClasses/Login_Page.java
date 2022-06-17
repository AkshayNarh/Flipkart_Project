package PomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.UtilClass1;

public class Login_Page extends UtilClass1{
	
WebDriver driver;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement loginButton;
	
	
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public void putEmail() throws IOException
	{
		email.sendKeys(getDataFromPropertyFile("email"));
	}
	
	public void putPassword() throws IOException
	{
		password.sendKeys(getDataFromPropertyFile("password"));
	}
	
	public void clickLoginBtn()
	{
		loginButton.click();
	}
	
	
}
