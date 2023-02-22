package E_Cap_Project.AutomationProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logouthrm {

	WebDriver driver ;

	  @Test
	  public void Log_out() {

		  // login to page by entering credential
		  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	      Username.sendKeys("Admin");
	      WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	      Password.sendKeys("admin123");
	      WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
	      Login.click();

	      //Logout 
	      WebElement ellipses = driver.findElement(By.xpath("//span[@class=\"oxd-userdropdown-tab\"]"));
	      ellipses.click();
	      WebElement Logoutt = driver.findElement(By.xpath("//a[@href=\"/web/index.php/auth/logout\"]"));
	      Logoutt.click();

	      //Verify that the user is landed on login page
	      String Expected_title = "OrangeHRM";
	      String Actual_Title = driver.getTitle();
	      Assert.assertEquals(Expected_title, Actual_Title);


	  }
	  @BeforeMethod
	  public void beforeMethod() {

		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
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

