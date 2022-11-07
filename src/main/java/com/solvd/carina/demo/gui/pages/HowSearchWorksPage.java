package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HowSearchWorksPage extends AbstractPage {

    public HowSearchWorksPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.google.com/search/howsearchworks/?fg=1");
    }

}
