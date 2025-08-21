package TestNG_programs;


import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Lab11_2_3_TestNG_pagefactory {
	 WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String a,String b) throws InterruptedException {
	 /* WebDriverManager.chromedriver().setup();
		//WebDriver driver;
		String title=driver.getTitle();
		System.out.println("The Title is:"+title);*/
	  lab11_2_3_pagefactory pf=PageFactory.initElements(driver, lab11_2_3_pagefactory.class);
     pf.clickDesktops();
      pf.clickMac();
      pf.selectSortAZ();
      pf.clickAddToCart();

      Thread.sleep(2000);
      System.out.println("Test executed with data: " + a + ", " + b);
	
     
   
	}
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		System.out.println("Application launched successfully");
  }

  @AfterMethod
  public void afterMethod() {
	 // driver.quit();
		
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	new Object[] { "1","a" },
        new Object[] { "2","b" }
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }

}