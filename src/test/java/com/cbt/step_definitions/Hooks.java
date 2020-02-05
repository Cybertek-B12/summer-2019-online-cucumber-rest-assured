package com.cbt.step_definitions;

import com.cbt.utilities.Driver;
import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before(order = 2)
    public void setUp(){
        System.out.println("I am setting up the test from the Hooks class!!!");
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // you can also add maximize screen here
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("I am reporting the results");
        // I want to take screenshot when current scenario fails.
        // scenario.isFailed()  --> tells if the scenario failed or not
        if (scenario.isFailed()) {
            // this line is for taking screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            // this line is adding the screenshot to the report
            scenario.embed(screenshot, "image/png");
        }

        System.out.println("Closing driver");
        Driver.closeDriver();
    }

    @Before(value = "@teacher", order = 11)
    public void setUpTeacher(){
        System.out.println("Set up teacher test");
    }
}    //  BREAK some time around 9.10 pm est. UPDATE YOUR CODE. I ALREADY PUSHED IT TO GITHUB
    // git fetch origin
    //git reset --hard origin/master
