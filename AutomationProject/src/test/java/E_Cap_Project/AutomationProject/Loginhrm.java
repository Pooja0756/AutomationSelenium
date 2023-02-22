package E_Cap_Project.AutomationProject;


import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;




public class Loginhrm {
	WebDriver driver ;

	  @Test
	  public void Login() {

		  //Entering user name password and clicking on Login
		  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	      Username.sendKeys("Admin");
	      WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	      Password.sendKeys("admin123");
	      WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
	      Login.click();

	      //Verifying the home page is visible
	      String Expected_Title = "OrangeHRM" ;
	      String Actual_Title = driver.getTitle();
	      Assert.assertEquals(Expected_Title, Actual_Title);
	  }


	  @BeforeMethod
	  public void beforeMethod() {

		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }

	}
	
	
	

