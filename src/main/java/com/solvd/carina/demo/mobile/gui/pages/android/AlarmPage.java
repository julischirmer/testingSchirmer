package com.solvd.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.mobile.gui.pages.common.AlarmPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.HomePageClockBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = AlarmPageBase.class)
public class AlarmPage extends AlarmPageBase {

    @FindBy(id="com.google.android.deskclock:id/fab")
    private ExtendedWebElement createAlarmBtn;

    @FindBy(id = "com.google.android.deskclock:id/material_timepicker_ok_button")
    private ExtendedWebElement saveAlarm;

    @FindBy(xpath = "(//androidx.cardview.widget.CardView[@content-desc=' Alarm'])[1]")
    private ExtendedWebElement alarmSaved;

    @FindBy(xpath = "(//android.widget.ImageButton[@content-desc='Expand alarm'])[1]")
    private ExtendedWebElement alarmExpand;

    @FindBy(id = "com.google.android.deskclock:id/delete")
    private ExtendedWebElement deleteAlarm;

    public AlarmPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return createAlarmBtn.isElementPresent(5);
    }

    @Override
    public void tapCreateAlarm() {
        createAlarmBtn.click();
    }

    @Override
    public void tapSaveAlarm(){
        saveAlarm.click();
    }

    @Override
    public boolean isAlarmSaved(){
        return alarmSaved.isElementPresent(5);
    }

    @Override
    public void tapDeleteAlarm(){
        alarmExpand.click();
        deleteAlarm.click();
    }

    @Override
    public boolean isAlarmDeleted(){
        return deleteAlarm.isElementNotPresent(5);
    }


}
