package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ListPage extends BasePage {

    static public int priorWishlistSize;

    static public int currentWishlistSize;

    @FindBy(css = "input[class='a-button-input']")
    public WebElement createAListButton;

    @FindBy(id = "list-name")
    public WebElement shoppingListNameInput;

    @FindBy(xpath = "//span[.='Liste Oluştur']/input")
    public WebElement createAListButtonFinal;

    @FindBy(xpath = "//span[.='1 ürün şuraya eklendi:']")
    public WebElement textOfAddedProduct;

    @FindBy(id = "continue-shopping")
    public WebElement continueToShoppingButton;

    @FindBy(css = "div[role='heading']")
    public WebElement titleOfWishlist;

    @FindBy(xpath = "//div[@class='a-fixed-right-grid-inner']//input[@name='submit.deleteItem']")
    public WebElement deleteProductFromWishlist;

    @FindBy(xpath = "//img[@alt='Daha fazlası']")
    public WebElement blablabla;

    @FindBy(id = "editYourList")
    public WebElement editYourList;

    @FindBy(xpath = "(//span[.='Listeyi sil']//span)[1]")
    public WebElement deleteWishlistButton;

    @FindBy(xpath = "//input[@name='submit.save']")
    public WebElement submitSaveButton;

    @FindBy(xpath = "//div[@id='your-lists-nav']/div")
    public List<WebElement> wishlists;

    public void createAList(String shoppingListName) {
        BrowserUtils.clickWithJS(createAListButton);
        shoppingListNameInput.clear();
        shoppingListNameInput.sendKeys(shoppingListName);
        createAListButtonFinal.click();
    }

    public void getDeleteProductFromWishlist() {
        BrowserUtils.clickWithJS(deleteProductFromWishlist);
    }

    public void getDeleteWishlist() {
        priorWishlistSize = wishlists.size();
        System.out.println("priorWishlistSize = " + priorWishlistSize);
        BrowserUtils.clickWithJS(blablabla);
        BrowserUtils.waitForClickablility(editYourList, 3);
        BrowserUtils.clickWithJS(editYourList);
        BrowserUtils.scrollToElement(deleteWishlistButton);
        BrowserUtils.clickWithJS(deleteWishlistButton);
        BrowserUtils.waitForPresenceOfElement(By.xpath("//input[@name='submit.save']"),5);
        BrowserUtils.clickWithJS(submitSaveButton);
        BrowserUtils.waitForPresenceOfElement(By.xpath("//div[@id='your-lists-nav']/div"), 3);
        currentWishlistSize = wishlists.size();
        System.out.println("currentWishlistSize = " + currentWishlistSize);
    }


}
