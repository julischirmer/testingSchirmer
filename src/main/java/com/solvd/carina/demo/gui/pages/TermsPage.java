package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class TermsPage extends AbstractPage {
    public TermsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://policies.google.com/terms");
    }
}
