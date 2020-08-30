package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Activity6 {

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
	public void ApplytoaJob() throws InterruptedException {
		driver.findElement(By.linkText("Jobs")).click();
		Thread.sleep(2000);
		WebElement searchbox1 = driver.findElement(By
				.xpath("//input[@id=\"search_keywords\"]"));
		searchbox1.click();
		Thread.sleep(2000);
		searchbox1.sendKeys("AutomationSDET");

		WebElement searchbox2 = driver.findElement(By
				.xpath("//input[@id=\"search_location\"]"));
		searchbox2.click();
		Thread.sleep(2000);
		searchbox2.sendKeys("Kolkata");

		WebElement searchjobs = driver.findElement(By
				.xpath("//input[@value='Search Jobs']"));
		searchjobs.click();
		Thread.sleep(2000);

		WebElement result = driver.findElement(By
				.xpath("(//article[@id='post-7']//h3)[2]"));
		result.click();
		Thread.sleep(2000);

		WebElement applyforjob = driver.findElement(By
				.xpath("//input[@value='Apply for job']"));
		applyforjob.click();
		Thread.sleep(2000);

		WebElement email = driver.findElement(By.xpath("//strong[contains(text(),'email your')]/following-sibling::a"));
		System.out.println(email.getText());

	}


	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
