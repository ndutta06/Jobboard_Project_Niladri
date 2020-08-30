package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Activity2 {

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
	public void VerifyWebsiteHeading() {
		String Heading = driver.findElement(By.id("post-16"))
				.findElement(By.tagName("h1")).getText();
		System.out.println(Heading);
		String expectedTitle = "Welcome to Alchemy Jobs";
		if (Heading.equalsIgnoreCase(expectedTitle))
			System.out.println("Heading matched");
		else
			System.out.println("Heading didn't match");

	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
