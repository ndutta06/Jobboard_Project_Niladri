package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Activity1 {

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
	public void VerifyWebsiteTitle() {
		String Title = driver.getTitle();
		System.out.println(Title);
		String expectedTitle = "Alchemy Jobs – Job Board Application";
		if (Title.equalsIgnoreCase(expectedTitle))
			System.out.println("Title matched");
		else
			System.out.println("Title didn't match");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
