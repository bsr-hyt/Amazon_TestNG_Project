package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//span[.='Liste Oluşturun']")
    public WebElement creatingListButton;


    public void clickCreatingListButton(){
        BrowserUtils.hover(userAccountName);
        BrowserUtils.clickWithJS(creatingListButton);
    }

}
