package com.telran.sheduler.tests.tests;

import com.telran.sheduler.tests.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();

    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        app.stop();
    }

}
