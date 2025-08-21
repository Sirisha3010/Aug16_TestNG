package TestNG_programs;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class lab11_2_3_pagefactory {
	@FindBy(linkText = "Desktops")
    WebElement desktopsMenu;

    @FindBy(linkText = "Mac (1)")
    WebElement macOption;

    @FindBy(id = "input-sort")
    WebElement sortDropdown;

    @FindBy(xpath = "//option[contains(text(),'Name (A - Z)')]")
    WebElement sortAZOption;

    @FindBy(xpath = "//button[contains(@onclick,'cart.add')]")
    WebElement addToCartButton;

    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    WebElement searchButton;

    @FindBy(name = "description")
    WebElement descriptionCheckbox;

    

    
    public void clickDesktops() {
        desktopsMenu.click();
    }

    public void clickMac() {
        macOption.click();
    }

    public void selectSortAZ() {
        sortDropdown.click();
        sortAZOption.click();
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void searchItem(String item) {
        searchBox.clear();
        searchBox.sendKeys(item);
        searchButton.click();
    }

    public void searchWithDescription(String item) {
        searchBox.clear();
        searchBox.sendKeys(item);
        descriptionCheckbox.click();
        searchButton.click();
    }
}