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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Areaconversion {
	WebDriver driver ;
	Properties prop = new Properties();
	
  @Test
  public void Areaconversion() {
	  
	  try {
	  
	  WebElement mathForEveryone = driver.findElement(By.xpath(prop.getProperty("mathForEveryone")));
	  mathForEveryone.click();
	  
	  WebElement area = driver.findElement(By.xpath(prop.getProperty("area")));
	  area.click();
	  
	  WebElement value = driver.findElement(By.xpath(prop.getProperty("value")));
	  value.sendKeys(prop.getProperty("sendValue"));
	  
	  WebElement unit = driver.findElement(By.xpath(prop.getProperty("unit")));
	  Select drop = new Select (unit);
	  drop.selectByIndex(2);
	  
	  WebElement convert = driver.findElement(By.xpath(prop.getProperty("convert")));
	  convert.click();
	  
	  //Verifying that the correct result is visible
	  
	  driver.switchTo().frame(prop.getProperty("iFrame"));
	  
	  WebElement result = driver.findElement(By.xpath(prop.getProperty("result")));
	  String resultText = result.getText();
	  if(resultText.contains(prop.getProperty("sendResultText"))) {
		  System.out.println("Sucessfully displayed correct result");
	  }
	  else {
		  System.out.println("Unable to display correct result");
	  }
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  
	  FileInputStream input = new FileInputStream("D:\\Anudip Foundation\\Programs\\Webmath_Project_2\\src\\test\\java\\Properties\\WebmathAreaConversion.properties");
	  prop.load(input);
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
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