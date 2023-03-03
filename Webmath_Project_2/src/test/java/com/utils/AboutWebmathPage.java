package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AboutWebmathPage {
	  WebDriver driver;
      Properties p = new Properties();

@Test
public void webMathPage() throws IOException {

   WebElement webMath = driver.findElement(By.xpath(p.getProperty("webMath")));
   
   webMath.click();
}

@BeforeClass
public void launchURL() throws IOException {


  WebDriverManager.chromedriver().setup();

      driver = new ChromeDriver();
	
  FileInputStream fis = new FileInputStream("D:\\Anudip Foundation\\Programs\\Webmath_Project_2\\src\\test\\java\\Properties\\AboutWebmath.properties");
 
  p.load(fis);
  
  driver.get(p.getProperty("url"));
  driver.manage().window().maximize();
	
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

}

@AfterClass
public void closeBrowser() {

      driver.close();

}
}
