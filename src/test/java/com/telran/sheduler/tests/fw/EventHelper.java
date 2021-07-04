package com.telran.sheduler.tests.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class EventHelper extends HelperBase {

    public EventHelper(AppiumDriver driver) {
        super(driver);
    }



    public boolean isNavPanelPresent() {
        return isElementPresent(By.id("nav_list_fr_container"), 3);
    }

    public void tapOnPlusButton() {
        waitForElementAndTap(By.id("fab_main"), 5);
    }

    public void tapOnPencilButton() {
        tap(By.id("fab_add_event"), 3);
    }

    public void fillEventForm(String eventTitle, String eventType, int breaksCount, String wage) throws InterruptedException {
        swipeTillSelectedDate(9);
        type(By.id("info_title_input"), eventTitle);
        type(By.id("info_type_input"), eventType);
        hideKeyboard();
        if (breaksCount > 0) {
            for (int i = 0; i < breaksCount; i++) {
                tapOnAddBreakButton();
            }
        }
        addWage(wage);
    }



    public void addWage(String wage) {
        tap(By.id("info_wage_edit"), 3);
        type(By.id("info_wage_input"), wage);
        tap(By.id("info_wage_save"), 3);
    }

    private void tapOnAddBreakButton() {
        tap(By.id("info_break_plus_btn"), 3);
    }

    public void saveEvent() {
        waitForElementAndTap(By.id("info_save_btn"), 2);
    }

    public int getNumberOfEvents(){
      int eventCounter;
      List<WebElement> events = driver.findElements(By.id("row_container_main"));
      eventCounter = events.size();

      return eventCounter;
    }


}


