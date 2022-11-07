package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterMenuGoogle extends AbstractUIObject {

    public FooterMenuGoogle(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//a[contains(@href,'about.google')]")
    private ExtendedWebElement aboutBtn;

    @FindBy(xpath = "//a[contains(@href,'google.com/intl')]")
    private ExtendedWebElement advertisingBtn;

    @FindBy(xpath = "//a[contains(@href,'google.com/services')]")
    private ExtendedWebElement businessBtn;

    @FindBy(xpath = "//a[contains(@href,'google.com/search/howsearchworks')]")
    private ExtendedWebElement howSearchWorksBtn;

    @FindBy(xpath = "//a[contains(@href,'policies.google.com/privacy')]")
    private ExtendedWebElement privacyBtn;

    @FindBy(xpath = "//a[contains(@href,'policies.google.com/terms')]")
    private ExtendedWebElement termsBtn;


    public PrivacyPage openPrivacyPage() {
        privacyBtn.click();
        return new PrivacyPage(driver);
    }

    public TermsPage openTermsPage() {
        termsBtn.click();
        return new TermsPage(driver);
    }

    public AboutPage openAboutPage() {
        aboutBtn.click();
        return new AboutPage(driver);
    }

    public AdvertisingPage openAdvertisingPage() {
        advertisingBtn.click();
        return new AdvertisingPage(driver);
    }

    public BusinessPage openBusinessPage() {
        businessBtn.click();
        return new BusinessPage(driver);
    }

    public HowSearchWorksPage openHowSearchWorksPage() {
        howSearchWorksBtn.click();
        return new HowSearchWorksPage(driver);
    }


}
