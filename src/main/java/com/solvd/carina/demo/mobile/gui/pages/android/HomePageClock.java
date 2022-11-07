package com.solvd.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.mobile.gui.pages.common.AlarmPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.HomePageClockBase;
import com.solvd.carina.demo.mobile.gui.pages.common.StopwatchPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = HomePageClockBase.class)
public class HomePageClock extends HomePageClockBase{

    public HomePageClock(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.google.android.deskclock:id/tab_menu_alarm")
    private ExtendedWebElement alarmBtn;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Stopwatch']/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement stopwatchBtn;

    @Override
    public AlarmPageBase openAlarmPage() {
        alarmBtn.click();
        return initPage(getDriver(), AlarmPageBase.class);
    }

    @Override
    public StopwatchPageBase openStopwatchPage(){
        stopwatchBtn.click();
        return initPage(getDriver(),StopwatchPageBase.class);
    }
}
