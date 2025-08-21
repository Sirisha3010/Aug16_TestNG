package TestNG_programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest1 {
   WebDriver driver;

  @Test(priority=3)
  public void test1() {
	  
	 System.out.println("this is test1");
	 
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("https://www.amazon.in/");

  }
  @Test(priority=2)
  public void test2() {
	  
		 System.out.println("this is test2");
		 
		  WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("https://mail.yahoo.com/");
}
  @Test(priority=1)
  public void test3() {
	  
		 System.out.println("this is test3");
		 
		  WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("https://www.myntra.com/");
  }
}
