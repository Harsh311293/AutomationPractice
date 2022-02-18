package com.automation.practice.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.practice.base.TestBase;
import com.automation.practice.pages.Authentication;
import com.automation.practice.pages.ContactPage;
import com.automation.practice.pages.Index;
import com.automation.practice.util.TestUtil;

public class ContactsPageTest extends TestBase{

	ContactPage cont;
	Index in;
	Authentication auth;
	
	@BeforeMethod
	public void setup() {
		initialization();
		in = new Index();
		in.signIn();
		auth = new Authentication();
		
		cont = new ContactPage();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] ob = TestUtil.getTestData("Data");
		return ob;
	}
	

	@Test(dataProvider = "getData")
	public void contactfillForm(String Title, String FirstName, String LastName, String Password, String DateOfBirth, String Address,
								String City, String State, String ZipCode, String Country, String MobilePhone, String ref_add, String mail_id) 
	{
	auth.register(mail_id);
	cont.filloutForm(Title, FirstName, LastName, Password, DateOfBirth, Address, City, State, ZipCode, Country, MobilePhone, ref_add);	
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}
	
}
