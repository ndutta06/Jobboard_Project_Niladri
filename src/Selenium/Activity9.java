package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Activity9 {

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
	public void CreateJobListingfromBackend() throws InterruptedException {
		
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

	
		WebElement jobListings = driver.findElement(By.xpath("//div[text()='Job Listings']"));
		jobListings.click();
		Thread.sleep(2000);
		
		
		WebElement addNew = driver.findElement(By.xpath("//div[@class='wrap']//a[text()='Add New']"));
		addNew.click();
		Thread.sleep(2000);
		
		try{
			driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
		}catch(Exception E){
			
		}
		
		WebElement position = driver.findElement(By.xpath("//textarea[@id='post-title-0']"));
		position.click();
		Thread.sleep(2000);
		position.sendKeys("Automation Tester");	
		
		WebElement location = driver.findElement(By.xpath("//input[@name='_job_location']"));
		position.click();
		Thread.sleep(2000);
		location.sendKeys("Kolkata");	
		
		WebElement applicationEmail = driver.findElement(By.xpath("//input[@name='_application']"));
		applicationEmail.clear();
		applicationEmail.click();
		Thread.sleep(2000);
		applicationEmail.sendKeys("ndutta06@in.ibm.com");
		
		
		WebElement companyName = driver.findElement(By.xpath("//input[@name='_company_name']"));
		companyName.click();
		Thread.sleep(2000);
		companyName.sendKeys("SDETIBMTRANING");
		
		
		WebElement companyWebsite = driver.findElement(By.xpath("//input[@name='_company_website']"));
		companyWebsite.click();
		Thread.sleep(2000);
		companyWebsite.sendKeys("https://demo.com");
		
		WebElement companyTagline = driver.findElement(By.xpath("//input[@name='_company_tagline']"));
		companyTagline.click();
		Thread.sleep(2000);
		companyTagline.sendKeys("The strength of the team is each individual member. The strength of each member is the team. : )");

		
		WebElement companyTwitter = driver.findElement(By.xpath("//input[@name='_company_twitter']"));
		companyTwitter.click();
		Thread.sleep(2000);
		companyTwitter.sendKeys("demo_twitter");
		
		
		//driver.findElement(By.xpath("//input[@id='_company_video']")).click();
		String URL = "https://www.youtube.com/watch?v=VXqbRNwXC2A";
		driver.findElement(By.xpath("//input[@id='_company_video']")).sendKeys(URL);
		//driver.findElement(By.xpath("//input[@id='_company_video']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@id='_filled']")).click();
		driver.findElement(By.xpath("//input[@id='_featured']")).click();
		driver.findElement(By.xpath("//input[@id='_job_expires']")).sendKeys("August 31, 2021");
		
		driver.findElement(By.xpath("//button[contains(text(),'Publish')]")).click();
		Thread.sleep(3000);
		
		List<WebElement> ele = driver.findElements(By.xpath("//button[contains(text(),'Publish')]"));
		
		//System.out.println(ele.size());
		
		(ele.get(ele.size()-1)).click();
		(ele.get(ele.size()-2)).click();

	
	
}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
