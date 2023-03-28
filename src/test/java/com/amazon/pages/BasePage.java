package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

//    @FindBy(id = "nav-logo-sprites")
//    public WebElement amazontrTitle;

    @FindBy(id="sp-cc-accept")
    public WebElement cookiesAcceptButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement logInAccount;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement userAccountName;



    public String getUserAccountName(String accountName){
        return Driver.get().findElement(By.xpath("//span[.='"+accountName+"\u200B']")).getText();
    }

    public void clickCookies(){
        cookiesAcceptButton.click();
    }
}
