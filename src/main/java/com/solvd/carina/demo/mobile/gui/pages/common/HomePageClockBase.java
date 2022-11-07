package com.solvd.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.mobile.gui.pages.android.AlarmPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageClockBase extends AbstractPage {

    public HomePageClockBase(WebDriver driver) {
        super(driver);
    }

    public abstract AlarmPageBase openAlarmPage();

    public abstract StopwatchPageBase openStopwatchPage();

//    public abstract void tapAlarmBtn();
//


}
