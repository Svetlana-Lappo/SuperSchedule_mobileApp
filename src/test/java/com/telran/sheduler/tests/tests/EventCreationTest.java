package com.telran.sheduler.tests.tests;
import com.telran.sheduler.tests.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EventCreationTest extends TestBase{


    @Test
    public void eventCreationOfRegisteredUserPositiveTest() throws InterruptedException {
        int numberOfEventsBeforeAdding;
        int  numberOfEventsAfterAdding;
        if(!app.event().isNavPanelPresent()){
            app.user().defaultLogin();
        }
        numberOfEventsBeforeAdding=app.event().getNumberOfEvents();
        System.out.println(numberOfEventsBeforeAdding);
        app.event().tapOnPlusButton();
        app.event().tapOnPencilButton();
        app.event().fillEventForm("Event","2",2,"50");
        app.event().saveEvent();
        numberOfEventsAfterAdding=app.event().getNumberOfEvents();
        System.out.println(numberOfEventsAfterAdding);
        Assert.assertEquals(numberOfEventsAfterAdding,numberOfEventsBeforeAdding+1);
    }

    @Test
    public void eventCreationOfUnregisteredUserPositiveTest() throws InterruptedException {
        int numberOfEventsBeforeAdding;
        int numberOfEventsAfterAdding;
        app.user().login(new User().withEmail("yx2@gmail.com").withPassword("Yx2_123456"));
        app.wizard().setCurrency("Belarusian ruble");
        app.wizard().setWage("50");
        app.wizard().tapOnNextButton();
        numberOfEventsBeforeAdding=app.event().getNumberOfEvents();
        System.out.println(numberOfEventsBeforeAdding);
        app.event().tapOnPlusButton();
        app.event().tapOnPencilButton();
        Thread.sleep(10000);
        app.event().fillEventForm("Event","1",3,"50");
        app.event().saveEvent();
        numberOfEventsAfterAdding=app.event().getNumberOfEvents();
        System.out.println(numberOfEventsAfterAdding);
        Assert.assertEquals(numberOfEventsAfterAdding,numberOfEventsBeforeAdding+1);

    }


}
