package com.utils;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.testng.annotations.BeforeMethod;

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

public class helptyping {
	WebDriver driver ;
	Properties prop = new Properties();
  @Test
  public void helpTyping() {
	  
	  try {
	  
	  WebElement contactUs = driver.findElement(By.xpath(prop.getProperty("contactUs")));
	  contactUs.click();
	  
	  WebElement helpTyping = driver.findElement(By.xpath(prop.getProperty("helpTyping")));
	  helpTyping.click();
	  Thread.sleep(3000);
	  
	  //Verifying the page is visible
	  String expectedTitle = prop.getProperty("title");
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(expectedTitle, actualTitle);
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  
	  FileInputStream input = new FileInputStream("D:\\Anudip Foundation\\Programs\\Webmath_Project_2\\src\\test\\java\\Properties\\WebmathHelpTyping.properties");
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