package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;

public class WebGoogleTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "jschirmer")
    @TestPriority(Priority.P1)
    public void openHomePage() {
        HomePageGoogle homePage = new HomePageGoogle(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test()
    @MethodOwner(owner = "jschirmer")
    @TestPriority(Priority.P2)
    public void testMenu(){
        HomePageGoogle homePage = new HomePageGoogle(getDriver());
        homePage.open();
        homePage.openMenu();
        Assert.assertTrue(homePage.menuOpened().isElementPresent(), "Menu is not opened");
    }

    @Test(dataProvider = "DP1")
    @MethodOwner(owner = "jschirmer")
    @TestPriority(Priority.P3)
    public void testSearchBar(String textToSearch){
        HomePageGoogle homePageGoogle = new HomePageGoogle(getDriver());
        homePageGoogle.open();
        GoogleSearchResult searchResult;
        searchResult = homePageGoogle.googleSearch(textToSearch);
        Assert.assertTrue(searchResult.isPageOpened(), "GoogleSearchResult is not opened");
        Assert.assertTrue(searchResult.articleTitleContainsTextSearched(textToSearch),"The word searched is not in all articles titles");
    }


    @Test()
    @MethodOwner(owner = "jschirmer")
    @TestPriority(Priority.P4)
    public void testFooter(){
        SoftAssert softAssert = new SoftAssert();
        HomePageGoogle homePageGoogle = new HomePageGoogle(getDriver());
        homePageGoogle.open();
        softAssert.assertTrue(homePageGoogle.isPageOpened(), "Home page is not opened");
        PrivacyPage privacyPage = homePageGoogle.getFooterMenu().openPrivacyPage();
        softAssert.assertTrue(privacyPage.isPageOpened(), "Privacy page is not opened");
        homePageGoogle.open();
        TermsPage termsPage = homePageGoogle.getFooterMenu().openTermsPage();
        softAssert.assertTrue(termsPage.isPageOpened(), "Terms page is not opened");
        homePageGoogle.open();
        AboutPage aboutPage = homePageGoogle.getFooterMenu().openAboutPage();
        softAssert.assertTrue(aboutPage.isPageOpened(), "About page is not opened");
        homePageGoogle.open();
        HowSearchWorksPage howSearchWorksPage = homePageGoogle.getFooterMenu().openHowSearchWorksPage();
        softAssert.assertTrue(howSearchWorksPage.isPageOpened(), "HowSearchWorks page is not opened");
        homePageGoogle.open();
        BusinessPage businessPage = homePageGoogle.getFooterMenu().openBusinessPage();
        softAssert.assertTrue(businessPage.isPageOpened(), "Business page is not opened");
        homePageGoogle.open();
        AdvertisingPage advertisingPage = homePageGoogle.getFooterMenu().openAdvertisingPage();
        softAssert.assertTrue(advertisingPage.isPageOpened(), "Advertising page is not opened");
    }


    @Test(dataProvider = "DP2")
    @MethodOwner(owner = "jschirmer")
    @TestPriority(Priority.P6)
    public void testWeather(String textToSearch){
        HomePageGoogle homePageGoogle = new HomePageGoogle(getDriver());
        homePageGoogle.open();
        GoogleSearchResult searchResult;
        searchResult = homePageGoogle.googleSearch(textToSearch);
        Assert.assertTrue(searchResult.isPageOpened(), "GoogleSearchResult is not opened");
        Assert.assertTrue(searchResult.isForecastOpen(), "Forecast is not opened");
    }

    @DataProvider(parallel = false, name = "DP1")
    public Object[][] dataProvider () {

        Object[][] search = {{"solvd"},
                            {"twitter"},
                            {"instagram"}};

        return search;
    }

    @DataProvider(parallel = false, name = "DP2")
    public Object[][] dataProvider2 () {

        Object[][] search = {{"weather"}};

        return search;
    }


}
