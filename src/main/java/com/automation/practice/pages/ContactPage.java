package com.automation.practice.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.practice.base.TestBase;

public class ContactPage extends TestBase{
	@FindBy(xpath="//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[1]/label")
	WebElement title_Mr;
	@FindBy(xpath="//*[@id=\"account-creation_form\"]/div[1]/div[1]/div[2]")
	WebElement title_Mrs;
	@FindBy(xpath="//*[@id=\"customer_firstname\"]")
	WebElement firstname;
	@FindBy(xpath="//*[@id=\"customer_lastname\"]")
	WebElement lastName;
	@FindBy(xpath="//*[@id=\"passwd\"]")
	WebElement password;
	@FindBy(xpath="//*[@id=\"days\"]")
	WebElement day;
	@FindBy(xpath="//*[@id=\"months\"]")
	WebElement month;
	@FindBy(xpath="//*[@id=\"years\"]")
	WebElement year;
	
	@FindBy(xpath="//*[@id=\"firstname\"]")
	WebElement address_FirstName;
	@FindBy(xpath="//*[@id=\"lastname\"]")
	WebElement address_LastName;
	@FindBy(xpath="//*[@id=\"address1\"]")
	WebElement address_address1;
	@FindBy(xpath="//*[@id=\"city\"]")
	WebElement address_city;
	@FindBy(xpath="//*[@id=\"id_state\"]")
	WebElement address_state;
	@FindBy(xpath="//*[@id=\"postcode\"]")
	WebElement address_post;
	@FindBy(xpath="//*[@id=\"id_country\"]")
	WebElement address_country;
	@FindBy(xpath="//*[@id=\"phone_mobile\"]")
	WebElement address_phone;
	@FindBy(xpath="//*[@id=\"alias\"]")
	WebElement address_alias;
	
	@FindBy(xpath="//*[@id=\"submitAccount\"]/span")
	WebElement submitButton;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String title() {
		return driver.getTitle();
		
	}
	
	public void filloutForm(String Title, String FirstName, String LastName, String Password, String DateOfBirth, String Address,
							String City, String State, String ZipCode, String Country, String MobilePhone, String ref_add)
	{
		if(Title=="Mr")
			title_Mr.click();
		else
			title_Mrs.click();
		
		firstname.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		password.sendKeys(Password);
		String[] dob = DateOfBirth.split("-");
		String cal_day = dob[0];
		String cal_month = dob[1];
		String cal_year = dob[2];
		
		day.sendKeys(cal_day);
		
		Select objselect = new Select(month);
		switch (cal_month) {
		case "01":	objselect.selectByIndex(1);  		break;
        case "02":  objselect.selectByIndex(2);      	break;
        case "03":  objselect.selectByIndex(3);         break;
        case "04":  objselect.selectByIndex(4);         break;
        case "05":  objselect.selectByIndex(5);         break;
        case "06":  objselect.selectByIndex(6);         break;
        case "07":  objselect.selectByIndex(7);         break;
        case "08":  objselect.selectByIndex(8);      	break;
        case "09":  objselect.selectByIndex(9);     	break;
        case "10": objselect.selectByIndex(10);     	break;
        case "11": objselect.selectByIndex(11);     	break;
        case "12": objselect.selectByIndex(12);     	break;
    }
		
		Select sel = new Select(year);
		sel.selectByValue(cal_year);
		
		address_FirstName.sendKeys(FirstName);
		address_LastName.sendKeys(LastName);
		address_address1.sendKeys(Address);
		address_city.sendKeys(City);
		Select selst = new Select(address_state);
		selst.selectByVisibleText(State);
		
		address_post.sendKeys(ZipCode);
		
		Select selcou = new Select(address_country);
		selcou.selectByVisibleText(Country);

		address_phone.sendKeys(MobilePhone);
		address_alias.sendKeys(ref_add);
		
		
	}
	
	public void submitForm() {
		submitButton.click();
	}

}
