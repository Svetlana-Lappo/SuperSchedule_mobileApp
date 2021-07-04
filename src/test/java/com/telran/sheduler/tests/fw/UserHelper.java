package com.telran.sheduler.tests.fw;

import com.telran.sheduler.tests.models.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class UserHelper extends HelperBase {


    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(User user) {
        waitForElement(By.id("log_email_input"), 5);
        type(By.id("log_email_input"), user.getEmail());
        type(By.id("log_password_input"), user.getPassword());
        hideKeyboard();
        clickOnLoginButton();

    }

    public void fillLoginForm(User user){
        type(By.id("log_email_input"), user.getEmail());
       // waitForElementAndType(By.id("log_email_input"), 5,user.getEmail());
        type(By.id("log_password_input"), user.getPassword());
    }



    public void clickOnLoginButton() {
        tap(By.id("login_btn"),3);
    }

    public void defaultLogin() {
        login(new User().withEmail("example3@gmail.com").withPassword("Example3_2021"));
    }

}
