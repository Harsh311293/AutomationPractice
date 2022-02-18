package com.automation.practice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.practice.base.TestBase;

public class Authentication extends TestBase {

	@FindBy(xpath="//*[@id=\"login_form\"]/h3")
	WebElement loginHeader;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement email;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[2]/span/input")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]/span")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"email_create\"]")
	WebElement e_mail;
	
	@FindBy(xpath="//*[@id=\"SubmitCreate\"]/span")
	WebElement button;
	
	
	
	public Authentication() {
		PageFactory.initElements(driver, this);
	}
	
	public String title() {
		return driver.getTitle();
	}
	
	public void login(String un, String pass)
	{
		email.sendKeys(un);
		password.sendKeys(pass);
		loginButton.click();
	}
	public void register(String mail)
	{
		e_mail.sendKeys(mail);
		button.click();
	}

	
	
}
