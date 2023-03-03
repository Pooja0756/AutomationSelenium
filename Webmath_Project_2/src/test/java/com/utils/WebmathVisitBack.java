package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebmathVisitBack {
	WebDriver driver ;
	Properties prop = new Properties();
  @Test
  public void WebmathvisitBack() {
	  
	  try {
	  
	  
	  WebElement math = driver.findElement(By.xpath(prop.getProperty("math")));
	  Select drop = new Select(math);
	  drop.selectByValue(prop.getProperty("value"));
	  
	  WebElement kilometerInput =driver.findElement(By.xpath(prop.getProperty("kilometerInput")));
	  kilometerInput.sendKeys(prop.getProperty("sendKilometerInput"));
	  
	  WebElement convert =driver.findElement(By.xpath(prop.getProperty("convert")));
	  convert.click();
	  
	  WebElement back = driver.findElement(By.xpath(prop.getProperty("back")));
	  back.click();
	  
	  //verifying Speed page is visited back
	  String expectedTitle = prop.getProperty("expectedTitle");
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(expectedTitle, actualTitle);
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  
	  FileInputStream input = new FileInputStream("D:\\Anudip Foundation\\Programs\\Webmath_Project_2\\src\\test\\java\\Properties\\WebmathVisitBackData.properties");
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