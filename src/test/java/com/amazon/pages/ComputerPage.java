package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends BasePage{

    @FindBy(xpath = "//span[.='\"msi\"']")
    public WebElement checkOfText;
    @FindBy(linkText = "2")
    public WebElement secondPage;

    @FindBy(xpath = "//span[@aria-label='Geçerli sayfa, sayfa 2']")
    public WebElement secondPageAfterMoving;


    public WebElement getCheckOfTextWebElement(String text){
        BrowserUtils.waitForVisibility(By.xpath("//span[.='\""+text+"\"']"),7);
      return Driver.get().findElement(By.xpath("//span[.='\""+text+"\"']"));
    }

    public void clickAfterScrollDown(WebElement element){
        BrowserUtils.scrollToElement(element);
        BrowserUtils.clickWithJS(element);
    }

    public WebElement moveToPage(String pageNumber){
      return Driver.get().findElement(By.xpath("//span[@aria-label='Geçerli sayfa, sayfa "+pageNumber+"']"));
    }


}
