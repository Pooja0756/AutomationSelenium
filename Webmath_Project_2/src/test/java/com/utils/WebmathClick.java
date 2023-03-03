package com.utils;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebmathClick {
	 WebDriver driver;
	@Test
	public void Click () throws IOException {
		
		  WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			  driver.manage().window().maximize();
			 FileReader reader = new FileReader ("D:\\Anudip Foundation\\Programs\\Webmath_Project_2\\src\\test\\java\\Data.properties");
			 Properties props = new Properties ();
			 props.load (reader);
			  driver.get(props.getProperty("search"));
			  WebElement K8 = driver.findElement(By.xpath (props.getProperty("K8")));
			  K8.click();
					  
			  
		
	}
}