package com.telran.sheduler.tests.tests;

import com.telran.sheduler.tests.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void registrationPositiveTest(){

        app.user().login(new User().withEmail("ex@gmail.com").withPassword("Ex12345678"));
        Assert.assertTrue(app.wizard().isWizardTitlePresent());

    }

    @Test
    public void loginPositiveTest(){

        app.user().login(new User().withEmail("example5@gmail.com").withPassword("Example5_2021"));
        Assert.assertTrue(app.event().isNavPanelPresent());

    }
}
