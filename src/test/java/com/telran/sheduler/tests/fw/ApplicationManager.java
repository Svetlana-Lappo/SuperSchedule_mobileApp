package com.telran.sheduler.tests.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    UserHelper user;
    EventHelper event;
    WizardHelper wizard;
    AppiumDriver driver;
    DesiredCapabilities capabilities;


    public UserHelper user() {
        return user;
    }

    public EventHelper event() {
        return event;
    }

    public WizardHelper wizard() {
        return wizard;
    }

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "qa14_mob");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("app", "C:/Users/HP/Desktop/v.0.0.3.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(driver);
        event = new EventHelper(driver);
        wizard= new WizardHelper(driver);
    }

    public void stop() {
        driver.quit();
    }
}
