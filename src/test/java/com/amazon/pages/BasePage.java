package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

//    @FindBy(id = "nav-logo-sprites")
//    public WebElement amazontrTitle;

    @FindBy(id="sp-cc-accept")
    public WebElement cookiesAcceptButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement userAccountName;

    @FindBy(id = "searchDropdownBox")
    public WebElement categoryDropDownBox;

    @FindBy(xpath = "//option[.='Bilgisayarlar']")
    public WebElement computerDropDownMenu;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBoxInput;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchBoxButton;

    public String getUserAccountName(String accountName){
        return Driver.get().findElement(By.xpath("//span[.='"+accountName+"\u200B']")).getText();
    }

    public void clickCookies(){
        BrowserUtils.clickWithJS(cookiesAcceptButton);
    }


    public void clickCategoryDropDownBox(String module){
        Select select = new Select(categoryDropDownBox);
        select.selectByVisibleText(module);
        BrowserUtils.handleToStaleElementAndClick(computerDropDownMenu,By.xpath("//option[.='Bilgisayarlar']"));
//        BrowserUtils.waitForClickablility(getDropDownMenuWebElement(module),3);
//       BrowserUtils.clickWithJS(getDropDownMenuWebElement(module));
    }

    public WebElement getDropDownMenuWebElement(String moduleName){
        BrowserUtils.waitForVisibility(By.xpath("//option[.='"+moduleName+"']"),4);
      return Driver.get().findElement(By.xpath("//option[.='"+moduleName+"']"));
    }

    public void searchToTextInSearchBox(String text){
        searchBoxInput.clear();
        searchBoxInput.sendKeys(text);
        BrowserUtils.waitForClickablility(searchBoxButton,3);
        BrowserUtils.clickWithJS(searchBoxButton);
    }

}
