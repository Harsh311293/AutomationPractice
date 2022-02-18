package com.automation.practice.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.practice.base.TestBase;
import com.automation.practice.pages.Authentication;
import com.automation.practice.pages.Index;

public class Authentication_LoginTest extends TestBase{
	
	Authentication auth;
	Index index;
	
	public Authentication_LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		auth= new Authentication();
		index = new Index();
		index.signIn();
	}
	@Test
	public void validateTitle() {
		String title = auth.title();
		Assert.assertEquals(title, "Login - My Store");
	}
	
	@Test
	public void login() {
		auth.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void shut() {
		driver.quit();
	}
}
