package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends BasePage{

    @FindBy (css = "input[class='a-button-input']")
    public WebElement createAListButton;

    @FindBy(id = "list-name")
    public WebElement shoppingListNameInput;

    @FindBy(xpath = "//span[.='Liste Oluştur']/input")
    public WebElement createAListButtonFinal;

    public void createAList(String shoppingListName){
        BrowserUtils.clickWithJS(createAListButton);
        shoppingListNameInput.clear();
        shoppingListNameInput.sendKeys(shoppingListName);
        createAListButtonFinal.click();
    }

}
