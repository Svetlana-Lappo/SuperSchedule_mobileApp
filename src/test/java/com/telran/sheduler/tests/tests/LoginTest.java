package com.telran.sheduler.tests.tests;

import com.telran.sheduler.tests.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginPositiveTest(){

        app.user().login(new User("example5@gmail.com", "Example5_2021"));
        Assert.assertTrue(app.user().isSetDataFormPresent());

    }
}
