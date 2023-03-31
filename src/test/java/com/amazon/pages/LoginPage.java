package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//span[@class='nav-action-inner']")
    public WebElement enterloginButton;

    @FindBy(linkText = "Giriş yap")
    public WebElement enterloginBtn;

    @FindBy(id = "ap_email")
    public WebElement userEmailInput;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(id = "ap_password")
    public WebElement passwordInput;

    @FindBy(css = "#signInSubmit")
    public WebElement loginButton;



    public void login(){
        BrowserUtils.hover(userAccountName);
        BrowserUtils.clickWithJS(enterloginBtn);
        userEmailInput.sendKeys(ConfigurationReader.get("userEmail"));
        BrowserUtils.clickWithJS(continueButton);
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        BrowserUtils.clickWithJS(loginButton);
    }



}
