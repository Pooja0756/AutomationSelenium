package E_Cap_Project.AutomationProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			 WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		        Username.sendKeys("Admin");
		        WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		        Password.sendKeys("admin123");
		        WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
		        Login.click();
		        WebElement MyInfo = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[6]/a[1]"));
		        MyInfo.click();
		        
		       			Thread.sleep(5000);
          driver.close();
    
    
    }
}
