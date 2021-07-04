package com.telran.sheduler.tests.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperBase {

    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator, int timeout) {

        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
            System.out.println("Element found");
            return true;
        } catch (WebDriverException wde) {
            System.out.println("Element not found");
            return false;
        }
    }

    public void tap(By locator, int timeout) {
        try{
            new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        }catch (WebDriverException wde){
            System.out.println(wde);
        }

    }

    public void type(By locator, String inputText) {
        if (inputText != null) {
            if (!inputText.equals(driver.findElement(locator).getText())) {
                tap(locator,2);
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(inputText);
            }

        }

    }

    public WebElement waitForElement(By locator, int timeOut) {

        return new WebDriverWait(driver, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));

    }

//    public boolean isElementPresent(By locator) {
//        waitForElement(locator, 5);
//        driver.findElement(locator);
//        return true;
//    }

//    public boolean isElementPresent1(By locator) {
//        return driver.findElements(locator).size()>0;
//    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void waitForElementAndTap(By locator, int timeOut) {
        try {
            new WebDriverWait(driver, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        } catch (WebDriverException wde) {
            System.out.println(wde);
        }


    }
    public void waitForElementAndType(By locator,int timeOut, String inputText){
        if(inputText!=null){
            waitForElement(locator,timeOut);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(inputText);
        }
    }

//    public void swipeDayToLeft() {
//        TouchAction action = new TouchAction(driver);
//        Dimension size = driver.manage().window().getSize();//screen size
//        int y = size.height / 5;
//        int startX = (int) (size.width * 0.8);
//        int stopX = (int) (size.width * 0.2);
//        action.longPress(PointOption.point(startX, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
//                .moveTo(PointOption.point(stopX, y)).release().perform();
//    }

    public void swipeToLeft(){
        Dimension size = driver.manage().window().getSize();
        int y = size.height / 5;
        int startX = (int) (size.width * 0.5);
        int stopX = (int) (size.width * 0.2);
        swipe(startX,y,stopX,y);
    }
    public void swipeToLeftToExactLocation(int endX){
        Dimension size = driver.manage().window().getSize();
        int y = size.height / 5;
        int startX = (int) (size.width * 0.5);
        swipe(startX,y,endX,y);
    }

    public List<WebElement> getSelectedDate(int date) {
        return driver.findElements(By.xpath("//android.widget.TextView[@text='" + date + "']"));
    }

    public void swipeTillSelectedDate(int date) throws InterruptedException {

        while (getSelectedDate(date).size() ==0) {
            swipeToLeft();

        }

        if (getSelectedDate(date).size() > 0) {
            swipeToLeftToExactLocation(0);
        }

    }


    public void swipeUp( int pixelsToSwipe){
            Dimension size = driver.manage().window().getSize();
            int x = (int) (size.width*0.5);
            int y = (int) (size.height*0.2);
            int y1 = y + pixelsToSwipe;

            swipe(x,y1,x,y);

    }
    public void swipe(int fromX,int fromY,int toX,int toY){
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(fromX,fromY))
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(toX,toY)).release().perform();


    }





}
