package E_Cap_Project.AutomationProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class salaryfromMyInfo {

	
	
	WebDriver driver ;
	
	  @Test
	  public void Employ_Review() throws InterruptedException {
		  
		  //Entering Username password and clicking on Login
		  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	      Username.sendKeys("Admin");
	      WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	      Password.sendKeys("admin123");
	      WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
	      Login.click();
	      WebElement MyInfo = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[6]/a[1]"));
	        MyInfo.click();
	        WebElement salary= driver.findElement(By.xpath("//a[contains(text(),'Salary')]"));
	        salary.click();
	        WebElement Save = driver.findElement(By.xpath("//button[@type='save']"));
		  	  Save.click();
		  	  Thread.sleep(5000);
		  }
		  @BeforeMethod
		  public void beforeMethod() {
			  WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
			  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		  }

		  @AfterMethod
		  public void afterMethod() {
			  driver.close();
		  }

		

		        
	

}


