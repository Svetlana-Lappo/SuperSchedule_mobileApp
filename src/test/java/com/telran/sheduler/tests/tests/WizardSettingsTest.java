package com.telran.sheduler.tests.tests;

import com.telran.sheduler.tests.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WizardSettingsTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        app.user().login(new User().withEmail("ww7@gmail.com").withPassword("Ww7_1234567"));
    }

    @Test
    public void setProfileDataPositiveTest() throws InterruptedException {

        app.wizard().setCurrency("Belarusian ruble");
        app.wizard().setWage("45");
        app.wizard().tapOnNextButton();
        Assert.assertTrue(app.wizard().isWizardTitlePresent());
    }
}
