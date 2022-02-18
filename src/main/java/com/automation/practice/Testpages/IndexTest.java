package com.automation.practice.Testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.practice.base.TestBase;
import com.automation.practice.pages.ContactPage;
import com.automation.practice.pages.Index;

public class IndexTest extends TestBase{
	
	Index index;
	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		index = new Index();
	}
	
	@Test
	public void validateTitle() {
		String title = index.title();
		Assert.assertEquals(title, "My Store");
	}
	
	@Test
	public void contactusClickable() {
		index.contactUs();
		Assert.assertEquals(driver.getTitle(), "Contact us - My Store");
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
