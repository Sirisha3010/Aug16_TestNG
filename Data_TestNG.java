package TestNG_programs;




import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
//import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Data_TestNG {
	WebDriver driver;
	String projectpath=System.getProperty("user.dir");
	
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
		//WebDriver driver;
		String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		//Assert.assertEquals(title, "Amazon");
		ExtentReports extent=new ExtentReports();
		String reportpath=projectpath+"\\Augreport.html";
		ExtentSparkReporter spark=new ExtentSparkReporter(reportpath) ;
		extent.attachReporter(spark);
		ExtentTest test=extent.createTest("Verify the title of the page");
		if(title.equals("OrangeHRM")) {
			test.pass("title is matched");
			
		}
		else {
			test.fail("title is not matched");
		}
		
		extent.flush();
		
		
		
		Thread.sleep(3000);
		//WebElement username=driver.findElement(By.name("username"));
		//username.sendKeys("Admin");
		login_pageobjects obj=new login_pageobjects(driver);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonlogin();
		//driver.findElement(By.name("username")).sendKeys(username);
		//driver.findElement(By.name("password")).sendKeys(password);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
	  driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
	  driver.quit();
  }


  @DataProvider
  
  public Object[][] dp() throws IOException {
	 // String[][] data=new String[3][2];
		  
		  String projectpath=System.getProperty("user.dir")  ;
		  File file1=new File(projectpath+"\\Data.xlsx");
		  FileInputStream fs=new FileInputStream(file1);
		  XSSFWorkbook workbook=new XSSFWorkbook(fs);
		  XSSFSheet worksheet=workbook.getSheetAt(0);
		  int rowcount=worksheet.getPhysicalNumberOfRows();
		  System.out.println("rows:"+rowcount);
		  
		  String[][] data = new String[rowcount][2];
		  
		  for(int i=0;i<rowcount;i++)
		  {
			  data[i][0]=worksheet.getRow(i).getCell(0).getStringCellValue();
		
			  data[i][1]=worksheet.getRow(i).getCell(1).getStringCellValue();
		  }
		  
		  return data;
		  
	    
	    }
			  
    /*return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "aravindi", "Admin@345" },
     // new Object[] { "aswini", "Aswini@345" },
    };*/
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");  }

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