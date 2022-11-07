package com.solvd.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.mobile.gui.pages.common.AlarmPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.StopwatchPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = StopwatchPageBase.class)
public class StopwatchPage extends StopwatchPageBase {

    @FindBy(xpath = "//android.widget.Button[@content-desc='Start']")
    private ExtendedWebElement start;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Pause']")
    private ExtendedWebElement stop;

    @FindBy(id = "com.google.android.deskclock:id/stopwatch_time_text")
    private ExtendedWebElement seconds;

    public StopwatchPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isPageOpened(){
        return start.isElementPresent();
    }

    @Override
    public void startStopWatch(){
        start.click();
    }

    @Override
    public void stopStopWatch(){
        stop.click();
    }

    @Override
    public boolean isStopWatchWork(){
        if(!seconds.equals("00")){
            return true;
        } else {
            return false;
        }
    }

}
