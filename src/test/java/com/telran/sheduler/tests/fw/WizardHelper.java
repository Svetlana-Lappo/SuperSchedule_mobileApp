package com.telran.sheduler.tests.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WizardHelper extends HelperBase {

    public WizardHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isWizardTitlePresent() {
        return isElementPresent(By.id("wizard_settings_title"), 3);
    }

    public void setWage(String wage) {
        tap(By.id("wizard_settings_wage_arrow"), 2);
        type(By.id("wage_dialog_input"), wage);
        tap(By.id("wage_dialog_ok_btn"), 2);
    }

    public void tapOnNextButton() {
        tap(By.id("wizard_settings_next"), 2);
    }

    public void setCurrency(String currency) throws InterruptedException {
        tap(By.id("wizard_settings_currency_arrow"), 2);
        swipeTillSelectedCurrency(currency);
    }

    public List<WebElement> getSelectedCurrency(String currency) {
        return driver.findElements(By.xpath("//android.widget.TextView[@text='" + currency + "']"));
    }

    public void swipeTillSelectedCurrency(String currency) throws InterruptedException {

        while (getSelectedCurrency(currency).size() == 0) {
            swipeUp(300);
        }

        if (getSelectedCurrency(currency).size() > 0) {
            getSelectedCurrency(currency).get(0).click();
        }

    }
}

