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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class lab11_2_4_TestNG_pagefactory {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String searchItem) throws InterruptedException {
	  
	  lab11_2_3_pagefactory pf1=PageFactory.initElements(driver, lab11_2_3_pagefactory.class);

      pf1.clickDesktops();
      pf1.clickMac();
      pf1.selectSortAZ();
      pf1.clickAddToCart();

      Thread.sleep(3000);

      pf1.searchItem(searchItem);
      pf1.searchWithDescription(searchItem);

      System.out.println("Search completed for: " + searchItem);
	
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
	  driver.quit();
	  
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	new Object[] { "Mobile" },
        new Object[] { "Monitors" }
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
