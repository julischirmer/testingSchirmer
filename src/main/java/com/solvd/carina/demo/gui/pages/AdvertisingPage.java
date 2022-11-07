package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.commons.math3.analysis.function.Abs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AdvertisingPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@class,'js-sticky-trigger glue-button glue-button--high-emphasis hero-button--margin add-incentive-param')]")
    private ExtendedWebElement startNowBtn;


    public AdvertisingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return startNowBtn.isElementPresent(5);
    }








}
