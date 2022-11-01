package com.solvd.carina.demo;

import java.util.List;

import com.solvd.carina.demo.gui.pages.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.carina.demo.gui.components.FooterMenu;
import com.solvd.carina.demo.gui.components.NewsItem;
import com.solvd.carina.demo.gui.components.compare.ModelSpecs;
import com.solvd.carina.demo.gui.components.compare.ModelSpecs.SpecType;

public class WebGoogleTest implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "jschirmer")
    @TestPriority(Priority.P3)
    public void testPrivacyBtn(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage = new HomePage(getDriver());
        PrivacyPage privacyPage = homePage.openPrivacyPage();
        //PrivacyPage privacyPage = new PrivacyPage(getDriver());
        privacyPage.open();
        Assert.assertTrue(privacyPage.isPageOpened(), "Privacy page is not opened");

    }
}
