package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//span[.='Liste Oluşturun']")
    public WebElement creatingListButton;

    @FindBy (css = ".nav-text")
    public WebElement myWishlist;

    @FindBy(xpath = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']//span")
    public WebElement secondProduct;

    @FindBy(id = "add-to-wishlist-button")
    public WebElement addToWishlistButton;

    @FindBy(xpath = "//ul[@id='atwl-dd-ul']/li[1]")
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

    public void addProductToWishList(WebElement product){
        BrowserUtils.clickWithJS(product);
        BrowserUtils.clickWithJS(addToWishlistButton);
        BrowserUtils.clickWithJS(lastWishList);
    }

    public void clickLogOutButton(){
        BrowserUtils.hover(userAccountName);
        BrowserUtils.waitForClickablility(logOutButton,5);
        BrowserUtils.clickWithJS(logOutButton);

    }


}
