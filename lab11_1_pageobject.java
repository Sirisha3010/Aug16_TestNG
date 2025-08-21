package TestNG_programs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class lab11_1_pageobject {
	WebDriver driver;
	public lab11_1_pageobject(WebDriver driver2) {
		// TODO Auto-generated constructor stub
			this.driver=driver2;
	}
	
	 By desktopsMenu = By.linkText("Desktops");
	 By macOption = By.linkText("Mac (1)");
	 By sortDropdown = By.id("input-sort");
	 By addToCartButton = By.xpath("//button[contains(@onclick,'cart.add')]");
	 By searchBox = By.name("search");
	 By searchButton = By.cssSelector("button.btn.btn-default.btn-lg");
	 By descriptionCheckbox = By.name("description");
	 
	 
	 public void clickDesktops() {
	        driver.findElement(desktopsMenu).click();
	    }
	    public void clickMac() {
	        driver.findElement(macOption).click();
	    }
	    public void selectSortAZ() {
	        driver.findElement(sortDropdown).click();
	        driver.findElement(By.xpath("//option[contains(text(),'Name (A - Z)')]")).click();
	    }
	    public void clickAddToCart() {
	        driver.findElement(addToCartButton).click();
	    }
	    public void searchItem(String item) {
	        driver.findElement(searchBox).clear();
	        driver.findElement(searchBox).sendKeys(item);
	        driver.findElement(searchButton).click();
	    }
	    public void searchWithDescription(String item) {
	        driver.findElement(searchBox).clear();
	        driver.findElement(searchBox).sendKeys(item);
	        driver.findElement(descriptionCheckbox).click();
	        driver.findElement(searchButton).click();
	    }

}