package com.automation.practice.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.practice.util.TestUtil;



public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		// Read the config.properties file
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Harsh\\eclipse-workspace\\AutomationPractice\\src\\main\\resources\\com"
													+"\\automation\\practice\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		
	public static void initialization() {
		String browser = prop.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Harsh\\OneDrive\\Desktop\\Eclipse\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitlyWait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static void swtichWindow(String url) {
		
		Set<String> s = driver.getWindowHandles();
		for(String e : s) {
			driver.switchTo().window(e);
			String actualurl = driver.getCurrentUrl();
			if(actualurl==url)
				break;
		}
	}
}
