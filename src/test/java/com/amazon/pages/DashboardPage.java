package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//span[.='Liste Oluşturun']")
    public WebElement creatingListButton;

    @FindBy (css = ".nav-text")
    public WebElement myWishlist;

    @FindBy(xpath = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']//span[@class='a-size-base-plus a-color-base a-text-normal']")
    public WebElement secondProduct;

    @FindBy(id = "add-to-wishlist-button")
    public WebElement addToWishlistButton;

    @FindBy(xpath = "//ul[@id='atwl-dd-ul']/li[1]//span[contains(text(),'SetCard List')]")
    public WebElement lastWishList;

    @FindBy(css = "#nav-item-signout")
    public WebElement logOutButton;

    public void clickCreatingListButton(){
        BrowserUtils.hover(userAccountName);
        BrowserUtils.clickWithJS(creatingListButton);
    }

    public void clickMyWishlist(){
        BrowserUtils.hover(userAccountName);
        BrowserUtils.clickWithJS(myWishlist);
    }

    public void addProductToWishList(WebElement product, String nameOfWishlist){
        BrowserUtils.clickWithJS(product);
        BrowserUtils.clickWithJS(addToWishlistButton);
        WebElement element = Driver.get().findElement(By.xpath("//ul[@id='atwl-dd-ul']/li[1]//span[contains(text(),'" + nameOfWishlist + "')]"));
        BrowserUtils.clickWithJS(element);
    }

    public void clickLogOutButton(){
        BrowserUtils.hover(userAccountName);
        BrowserUtils.waitForClickablility(logOutButton,5);
        BrowserUtils.clickWithJS(logOutButton);

    }


}
