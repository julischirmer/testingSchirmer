package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.naming.ldap.ExtendedRequest;

public class BusinessPage extends AbstractPage {
    @FindBy(xpath = "//a[contains(@href,'https://smallbusiness.withgoogle.com/intl')][contains(@class,'h-c-button h-c-button--primary ga-hero-cta')]")
    private ExtendedWebElement basicAspect;
    public BusinessPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return basicAspect.isElementPresent(5);
    }
}
