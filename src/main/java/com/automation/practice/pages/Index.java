package com.automation.practice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.practice.base.TestBase;

public class Index extends TestBase{
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/span")
	WebElement number;
	
	@FindBy(xpath="//*[@id=\"contact-link\"]/a")
	WebElement contact;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"header_logo\"]/a/img")
	WebElement logo;
	
	@FindBy(xpath="//*[@id=\"search_query_top\"]")
	WebElement searchText;
	
	@FindBy(xpath="//*[@id=\"searchbox\"]/button")
	WebElement searchButton;

	public Index() {
		PageFactory.initElements(driver, this);
	}
	
	public String title() {
		return driver.getTitle();
	}
	
	public String Number() {
		return number.getText();
	}
	
	public ContactPage contactUs() {
		contact.click();
		return new ContactPage();
	}
	public Authentication signIn() {
		login.click();
		return new Authentication();
	}
	public void search(String s) {
		searchText.sendKeys(s);
		searchButton.click();
	}
	public String logoPage() {
		return logo.getText();
	}



}
