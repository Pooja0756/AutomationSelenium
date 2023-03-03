package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebmathNews {
	WebDriver driver ;
	Properties prop = new Properties();
  @Test
  public void news() throws InterruptedException {
	  
	  try {
	  
	  WebElement mathForEveryone = driver.findElement(By.xpath(prop.getProperty("mathForEveryone")));
	  mathForEveryone.click();
	  
	  WebElement privacyPolicy = driver.findElement(By.xpath(prop.getProperty("privacyPolicy")));
	  privacyPolicy.click();
	  
	  Thread.sleep(3000);
	  
	  WebElement webmathnews = driver.findElement(By.xpath(prop.getProperty("webmathnews")));
	  webmathnews.click();
	  
	 
	  
	
	  //Verify that the news page is visible
	  
	  String actualTitle = prop.getProperty("actualTitle");
	  String expectedTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  
	  FileInputStream input = new FileInputStream("D:\\Anudip Foundation\\Programs\\Webmath_Project_2\\src\\test\\java\\Properties\\WebmathNews.properties");
	  prop.load(input);
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  driver.get(prop.getProperty("url"));
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}