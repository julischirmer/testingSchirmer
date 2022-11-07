package com.solvd.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class StopwatchPageBase extends AbstractPage {

    public StopwatchPageBase(WebDriver driver){
        super(driver);
    }

    public abstract void startStopWatch();

    public abstract void stopStopWatch();

    public abstract boolean isStopWatchWork();



}
