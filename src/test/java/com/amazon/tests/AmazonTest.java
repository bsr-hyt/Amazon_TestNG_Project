package com.amazon.tests;

import com.amazon.pages.DashboardPage;
import com.amazon.pages.ListPage;
import com.amazon.pages.LoginPage;
import com.amazon.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase{

    LoginPage loginPage = new LoginPage();

    DashboardPage dashboardPage = new DashboardPage();
    ListPage listPage = new ListPage();


    @Test
    public void amazonTest(){
        extentLogger =report.createTest("Shopping List test");

        extentLogger.info("go to home page --> "+ ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("verify that home page is displayed");
        Assert.assertTrue(dashboardPage.logInAccount.isDisplayed());

        extentLogger.info("accept the cookie preferences");
        dashboardPage.clickCookies();

        extentLogger.info("login to account with valid email and valid password ");
        loginPage.login();

        extentLogger.info("verify that login the account");
        String expectedUsername =ConfigurationReader.get("username");
        String actualAccountName = loginPage.getUserAccountName(expectedUsername);
        Assert.assertEquals(actualAccountName,expectedUsername);
//        Assert.assertTrue(loginPage.userAccountName.isDisplayed());

        extentLogger.info("create the list whose name is 'SetCard Liste'" );
        dashboardPage.clickCreatingListButton();
        listPage.createAList("SetCard Liste");

        









    }
}
