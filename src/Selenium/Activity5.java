package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Activity5 {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\NiladriDutta\\Desktop\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test
	public void NavigatetoJobsPage() throws InterruptedException {
		driver.findElement(By.linkText("Jobs")).click();
		Thread.sleep(2000);
		String Title = driver.getTitle();
		System.out.println(Title);
		
		boolean verifyElement = driver.findElement(By.xpath("//h1[contains(text(),'Jobs')]")).isDisplayed();
		if (verifyElement) {
	          System.out.println("Jobs page verified");
	          
	      } else {
	          System.out.println("Jobs Page verification failed");
	      }

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
