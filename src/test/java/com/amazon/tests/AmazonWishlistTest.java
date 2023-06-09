package com.amazon.tests;

import com.amazon.pages.ComputerPage;
import com.amazon.pages.DashboardPage;
import com.amazon.pages.ListPage;
import com.amazon.pages.LoginPage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.amazon.pages.ListPage.currentWishlistSize;
import static com.amazon.pages.ListPage.priorWishlistSize;

public class AmazonWishlistTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    DashboardPage dashboardPage = new DashboardPage();
    ListPage listPage = new ListPage();
    ComputerPage computerPage = new ComputerPage();


    @Test
    public void wishlistTest() {
        extentLogger = report.createTest("Shopping List Test");

        extentLogger.info("go to home page --> " + ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("verify that home page is displayed");
        try {
            Assert.assertTrue(dashboardPage.searchBoxInput.isDisplayed());
        } catch (Exception e) {
            driver.navigate().refresh();
        }

        extentLogger.info("accept the cookie preferences");
        dashboardPage.clickCookies();

        extentLogger.info("login to account with valid email and valid password ");
        loginPage.login();

        extentLogger.info("verify that login the account");
        String expectedUsername = ConfigurationReader.get("username");
        String actualAccountName = loginPage.getUserAccountName(expectedUsername);
        Assert.assertEquals(actualAccountName, expectedUsername);
//        Assert.assertTrue(loginPage.userAccountName.isDisplayed());

        extentLogger.info("create the list whose name is 'SetCard List'");
        dashboardPage.clickCreatingListButton();
        listPage.createAList("SetCard List");

        BrowserUtils.waitFor(2);
        extentLogger.info("select the computer category in all categories tab");
        dashboardPage.clickCategoryDropDownBox("Bilgisayarlar");

        BrowserUtils.waitFor(2);
        extentLogger.info("verify that category of computer is selected");
        Assert.assertTrue(dashboardPage.getDropDownMenuWebElement("Bilgisayarlar").isDisplayed());

        BrowserUtils.waitFor(2);
        extentLogger.info("The text of msi is typed into the search box");
        dashboardPage.searchToTextInSearchBox("msi");

        extentLogger.info("verify that text of msi is searched");
        Assert.assertTrue(computerPage.getCheckOfTextWebElement("msi").isDisplayed());

        BrowserUtils.waitFor(2);
        extentLogger.info("go to second page on search results page");
        computerPage.clickAfterScrollDown(computerPage.secondPage);

        extentLogger.info("verify that navigate to second page on search results page");
//        BrowserUtils.waitForVisibility(computerPage.secondPageAfterMoving, 5);
        BrowserUtils.waitFor(3);
        Assert.assertTrue(computerPage.moveToPage("2").isDisplayed());

        extentLogger.info("add second product on the page to 'SetCard List'");
        dashboardPage.addProductToWishList(dashboardPage.secondProduct,"SetCard List");

        extentLogger.info("verify that second product on the page is added to 'SetCard List'");
        BrowserUtils.waitFor(2);
        Assert.assertTrue(listPage.textOfAddedProduct.isDisplayed());

        extentLogger.info("go to Wishlist which is in the myAccount tab ");
        listPage.goToWisListAfterAddProductToList();

        extentLogger.info("verify that Wishlist page is visible");
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertTrue(listPage.titleOfWishlist.isDisplayed());

        extentLogger.info("delete added product in the SetCard List");
        listPage.getDeleteProductFromWishlist();

        extentLogger.info("delete SetCard List");
        listPage.getDeleteWishlist();

        extentLogger.info("verify that deleting process is done.");
        Assert.assertNotEquals(currentWishlistSize, priorWishlistSize);

        extentLogger.info("log out from account");
        dashboardPage.clickLogOutButton();

        extentLogger.info("verify that log out from the account is done");
        BrowserUtils.waitForVisibility(loginPage.continueButton,5);
        Assert.assertTrue(loginPage.continueButton.isDisplayed());


    }
}
