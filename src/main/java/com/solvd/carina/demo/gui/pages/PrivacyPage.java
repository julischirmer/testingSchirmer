package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class PrivacyPage extends AbstractPage {
    public PrivacyPage(WebDriver driver) {
        super(driver);
        setPageURL("https://policies.google.com/privacy?hl=es-AR&fg=1");
    }

}
