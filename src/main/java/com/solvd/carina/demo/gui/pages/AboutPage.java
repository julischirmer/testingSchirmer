package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class AboutPage extends AbstractPage {

    public AboutPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://about.google/?utm_source=google");
    }

    @FindBy(xpath = "//a[contains(@href,'./products/')][contains(@data-g-cta_type, 'button')]")
    private ExtendedWebElement allProductsBtn;

    @FindBy(xpath = "//a[contains(@href,'https://support.google.com/')][contains(@data-g-cta_type, 'button')]")
    private ExtendedWebElement productAssistanceBtn;




}
