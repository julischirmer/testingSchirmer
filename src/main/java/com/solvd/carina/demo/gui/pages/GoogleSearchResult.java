package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class GoogleSearchResult extends AbstractPage {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public GoogleSearchResult(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a/h3")
    private List<ExtendedWebElement> articlesTitle;

    @FindBy(id = "wob_dp")
    private ExtendedWebElement extendedForecast;

    public boolean articleTitleContainsTextSearched(String textSearched){
        boolean isContains = true;
        for (ExtendedWebElement articleTitle:articlesTitle) {
            if(!articleTitle.getText().toUpperCase().contains(textSearched.toUpperCase())){
                isContains = false;
            };
        }
        return isContains;
    }

    public boolean isForecastOpen(){
        if (extendedForecast.isElementPresent()){
            return true;
        } else {
            return false;
        }
    }

    public boolean isPageOpened() {
        return !articlesTitle.isEmpty();
    }



}
