package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConvertKmToMiles {
	Properties prop = new Properties();
	WebDriver driver ;
  @Test
  public void convertKmtoMiles() throws InterruptedException {
	  
	  try {
		  

	  WebElement math = driver.findElement(By.xpath(prop.getProperty("math")));
	  Select drop = new Select(math);
	  drop.selectByValue(prop.getProperty("value"));
	  
	  WebElement kilometerInput =driver.findElement(By.xpath(prop.getProperty("kilometerInput")));
	  kilometerInput.sendKeys(prop.getProperty("sendKilometerInput"));
	  
	  WebElement convert =driver.findElement(By.xpath(prop.getProperty("convert")));
	  convert.click();
	  
	  //verifying the result
	  driver.switchTo().frame(prop.getProperty("frameId"));
	  
	  
	  WebElement result = driver.findElement(By.xpath(prop.getProperty("result")));
	  String resultText = result.getText();
	  if(resultText.contains(prop.getProperty("sendResultText"))) {
		  System.out.println("The correct result is visible");
	  }
	  else{
		  System.out.println("Result is not visible");
	  }
	  
	  }catch(Exception e) {
		  System.out.println(e);
	  }
	 
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  try {
	  FileInputStream input = new FileInputStream("D:\\Anudip Foundation\\Programs\\Webmath_Project_2\\src\\test\\java\\Properties\\toMiles.properties");
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
