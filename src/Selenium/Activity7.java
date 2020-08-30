package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Activity7 {

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
	public void CreateaNewJobListing() throws InterruptedException {

		String jobName = "AutomationSDET";

		driver.findElement(By.linkText("Post a Job")).click();
		Thread.sleep(2000);
		WebElement signin = driver.findElement(By
				.xpath("//a[text()='Sign in']"));
		signin.click();
		Thread.sleep(2000);

		WebElement userlogin = driver.findElement(By
				.xpath("//input[@id='user_login']"));
		userlogin.click();
		Thread.sleep(2000);
		userlogin.sendKeys("root");

		WebElement password = driver.findElement(By
				.xpath("//input[@id='user_pass']"));
		password.click();
		Thread.sleep(2000);
		password.sendKeys("pa$$w0rd");

		WebElement loginClick = driver.findElement(By
				.xpath("//input[@id='wp-submit']"));
		loginClick.click();
		Thread.sleep(2000);

		WebElement jobTitle = driver.findElement(By
				.xpath("//input[@id='job_title']"));
		jobTitle.click();
		Thread.sleep(2000);
		jobTitle.sendKeys(jobName);

		WebElement location = driver.findElement(By
				.xpath("//input[@name='job_location']"));
		location.click();
		Thread.sleep(2000);
		location.sendKeys("Kolkata");

		Select jobtype = new Select(driver.findElement(By
				.xpath("//select[@name='job_type']")));
		jobtype.selectByVisibleText("Full Time");
		Thread.sleep(2000);

		driver.switchTo().frame("job_description_ifr");
		driver.findElement(By.tagName("body")).clear();
		Thread.sleep(2000);
		driver.findElement(By.tagName("body")).sendKeys(
				"Job opening for two years of experienced automation tester");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		WebElement applicationEmail = driver.findElement(By
				.xpath("//input[@id='application']"));
		applicationEmail.clear();
		applicationEmail.click();
		Thread.sleep(2000);
		applicationEmail.sendKeys("ndutta06@in.ibm.com");

		WebElement companyName = driver.findElement(By
				.xpath("//input[@id='company_name']"));
		companyName.clear();
		companyName.click();
		Thread.sleep(2000);
		companyName.sendKeys("SDETIBMTRANING");

		WebElement companyWebsite = driver.findElement(By
				.xpath("//input[@id='company_website']"));
		companyWebsite.clear();
		companyWebsite.click();
		Thread.sleep(2000);
		companyWebsite.sendKeys("https://demo.com");

		WebElement companyTagline = driver.findElement(By
				.xpath("//input[@id='company_tagline']"));
		companyTagline.clear();
		companyTagline.click();
		Thread.sleep(2000);
		companyTagline
				.sendKeys("The strength of the team is each individual member. The strength of each member is the team. :) ");

		WebElement video = driver.findElement(By
				.xpath("//input[@id='company_video']"));
		video.clear();
		video.click();
		Thread.sleep(2000);
		video.sendKeys("https://demo.com/watch?v=demo2020");

		WebElement twitterUsername = driver.findElement(By
				.xpath("//input[@id='company_twitter']"));
		twitterUsername.clear();
		twitterUsername.click();
		Thread.sleep(2000);
		twitterUsername.sendKeys("demo_twitter");

		WebElement chooseFile = driver.findElement(By.id("company_logo"));
		chooseFile
				.sendKeys("C:\\Users\\NiladriDutta\\Desktop\\Workspace\\Quick_Guide_Final.pdf");
		Thread.sleep(5000);

		WebElement preview = driver.findElement(By
				.xpath("//input[@name='submit_job']"));
		preview.click();
		Thread.sleep(2000);

		WebElement submitListing = driver.findElement(By
				.xpath("//input[@id='job_preview_submit_button']"));
		submitListing.click();
		Thread.sleep(2000);

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

		WebElement searchResult = driver.findElement(By
				.xpath("//article[@id='post-7']//h3"));
		String nameofJob = searchResult.getText();
		Thread.sleep(2000);
		System.out.println(nameofJob);
		Assert.assertEquals(nameofJob, jobName, "Compairing Job Name");
		System.out.println("Job listing verification completed");

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}