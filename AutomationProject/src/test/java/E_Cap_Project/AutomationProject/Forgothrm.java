package E_Cap_Project.AutomationProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;


public class Forgothrm {
	WebDriver driver ;

	  @Test
	  public void Forgot_Password() {
		  //Entering invalid Username password and clicking on Login
		  WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	      Username.sendKeys("Pooja");
	      WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	      Password.sendKeys("rajput1234");
	      WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
	      Login.click();

	      //Verify that the invalid credentail is visible
	      WebElement error = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
	      String Expected_Error = "Invalid credentials" ;
	      String Actual_Error = error.getText();
	      Assert.assertEquals(Expected_Error, Actual_Error);



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
	
	

