package com.solvd.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AlarmPageBase extends AbstractPage {

    public AlarmPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract void tapCreateAlarm();

    public abstract void tapSaveAlarm();

    public abstract boolean isAlarmSaved();

    public abstract void tapDeleteAlarm();

    public abstract boolean isAlarmDeleted();

}
