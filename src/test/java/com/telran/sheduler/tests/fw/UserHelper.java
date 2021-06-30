package com.telran.sheduler.tests.fw;

import com.telran.sheduler.tests.models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class UserHelper extends HelperBase {


    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(User user){
        waitForElement(By.id("log_email_input"),5);
        type(By.id("log_email_input"), user.getEmail());
        waitForElement(By.id("log_password_input"),5);
        type(By.id("log_password_input"), user.getPassword());
        driver.hideKeyboard();
        tap(By.id("login_btn"));

    }

    public boolean isSetDataFormPresent(){
        return isElementPresent(By.id("wizard_settings_title"));
    }
}
