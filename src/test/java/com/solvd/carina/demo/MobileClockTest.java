package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.mobile.gui.pages.common.AlarmPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.HomePageClockBase;
import com.solvd.carina.demo.mobile.gui.pages.common.StopwatchPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileClockTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "jschirmer")
    public void testCreateAlarm() {
        HomePageClockBase homePage = initPage(getDriver(), HomePageClockBase.class);
        AlarmPageBase alarmPage = homePage.openAlarmPage();
        Assert.assertTrue(alarmPage.isPageOpened(),"Alarm page is not opened");
        alarmPage.tapCreateAlarm();
        alarmPage.tapSaveAlarm();
        Assert.assertTrue(alarmPage.isAlarmSaved(),"The alarm is not created");
    }

    @Test()
    @MethodOwner(owner = "jschirmer")
    public void testDeleteAlarm() {
        HomePageClockBase homePage = initPage(getDriver(), HomePageClockBase.class);
        AlarmPageBase alarmPage = homePage.openAlarmPage();
        Assert.assertTrue(alarmPage.isPageOpened(),"Alarm page is not opened");
        alarmPage.tapDeleteAlarm();
        Assert.assertTrue(alarmPage.isAlarmDeleted(),"The alarm is not deleted");
    }

    @Test()
    @MethodOwner(owner = "jschirmer")
    public void testStopWatch() {
        HomePageClockBase homePage = initPage(getDriver(), HomePageClockBase.class);
        StopwatchPageBase stopwatchPage = homePage.openStopwatchPage();
        Assert.assertTrue(stopwatchPage.isPageOpened(),"sss");
        stopwatchPage.startStopWatch();
        stopwatchPage.stopStopWatch();
        Assert.assertTrue(stopwatchPage.isStopWatchWork(),"The stopwatch is not working correct");
    }
}
