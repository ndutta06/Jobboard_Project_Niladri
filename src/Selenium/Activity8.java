package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Activity8 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\NiladriDutta\\Desktop\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test
	public void LogintoWebsiteBackend() throws InterruptedException {
		
		WebElement userLogin = driver.findElement(By.xpath("//input[@id='user_login']"));
		userLogin.click();
		Thread.sleep(2000);
		userLogin.sendKeys("root");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='user_pass']"));
		password.click();
		Thread.sleep(2000);
		password.sendKeys("pa$$w0rd");	
		
		
		WebElement loginClick = driver.findElement(By.xpath("//input[@id='wp-submit']"));
		loginClick.click();
		Thread.sleep(2000);
		
		boolean verifyElement = driver.findElement(By.xpath("//div[contains(text(),'Dashboard')]")).isDisplayed();
		if (verifyElement) {
	          System.out.println("Logged in successfully");
	          
	      } else {
	          System.out.println("Log in not successfully done.");
	      }
			
	
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}