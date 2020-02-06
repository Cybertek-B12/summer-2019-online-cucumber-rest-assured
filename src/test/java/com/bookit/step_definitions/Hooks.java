package com.bookit.step_definitions;

import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.DBUtility;
import com.bookit.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static io.restassured.RestAssured.*;

public class Hooks {

    @Before("@db")
    public void setUpDB(){
        DBUtility.createDBConnection();
        System.out.println("connecting to DB");
    }

    @After("@db")
    public void tearDownDB(){
        DBUtility.destroy();
        System.out.println("disconnecting from DB");
    }

    @Before("@api")
    public void setUpAPI(){
        baseURI = ConfigurationReader.get("bookit.api."+ConfigurationReader.get("environment"));
        System.out.println("connecting to DB");
    }

    @After("@ui")
    public void tearDownUI(Scenario scenario){
        System.out.println("I am reporting the results");
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        System.out.println("Closing driver");
        Driver.closeDriver();
    }
}