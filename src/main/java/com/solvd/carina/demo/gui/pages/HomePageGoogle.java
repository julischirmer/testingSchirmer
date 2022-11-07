package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.FooterMenuGoogle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePageGoogle extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[contains(@href,'policies.google.com/terms')]")
    private ExtendedWebElement termsBtn;

    @FindBy(xpath = "//form[@action = '/search']//input[@title='Search']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//input[@value='Google Search']")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//a[contains(@href,'about/products')][contains(@role, 'button')]")
    private ExtendedWebElement menuBtn;

    @FindBy(xpath = "//div [@jscontroller = 'NzU6V']")
    private FooterMenuGoogle footerMenu;

    public GoogleSearchResult googleSearch(String text) {
        searchBar.type(text);
        searchBtn.click();
        return new GoogleSearchResult(driver);
    }

    public void openMenu() {
        menuBtn.click();
    }

    public ExtendedWebElement menuOpened() {
        ExtendedWebElement menuOpen = menuBtn.findExtendedWebElement(By.xpath("//a[contains(@href,'about/products')][contains(@role, 'button')][contains(@aria-expanded, 'true')]"));
    	return menuOpen;
    }

    public HomePageGoogle(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public FooterMenuGoogle getFooterMenu() {
        return footerMenu;
    }


}
