package com.bookit.step_definitions.login;

import com.bookit.pages.MapPage;
import com.bookit.pages.SignInPage;
import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageStepDefinitions {

// OPTION + ENTER       MAC
// ALT + ENTER       WINDOWS

    @When("user logs in as a team lead")
    public void user_logs_in_as_a_team_lead() {
        System.out.println("I am logging in");
        System.out.println("email: " + ConfigurationReader.get("team.leader.email"));
        System.out.println("password: " + ConfigurationReader.get("team.leader.password"));

        SignInPage signInPage = new SignInPage();
        signInPage.email.sendKeys(ConfigurationReader.get("team.leader.email"));
        signInPage.password.sendKeys(ConfigurationReader.get("team.leader.password"));
        signInPage.signIn.click();

    }

    @Given("user on the login page")
    public void user_on_the_login_page() {
        System.out.println("I am opening the login page");
        // open the login page of the application
        // url is in the properties file
        Driver.get().get(ConfigurationReader.get("bookit."+ConfigurationReader.get("environment")));
    }

    @Then("homepage should be displayed")
    public void homepage_should_be_displayed() {

        System.out.println("I can see the home page now!!");
        // verify the header
        String expected = "map";

        MapPage mapPage= new MapPage();

//        BrowserUtils.waitForVisibility(mapPage.map, 5);

        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
//        wait.until(ExpectedConditions.textToBePresentInElement(mapPage.header, "map"));

        wait.until(ExpectedConditions.urlContains("map"));

        // ExpectedConditions.url to be

        String actual = mapPage.title.getText();

        // assertions are coming from Junit
        Assert.assertEquals(expected, actual);

    }

    @Then("the title should be correct")
    public void the_title_should_be_correct() {
        System.out.println("Checking title");
    }

    @When("user logs in as a team member")
    public void user_logs_in_as_a_team_member() {
        System.out.println("I am logging in as member");

        SignInPage signInPage = new SignInPage();
        signInPage.email.sendKeys(ConfigurationReader.get("team.member.email"));
        signInPage.password.sendKeys(ConfigurationReader.get("team.member.password"));
        signInPage.signIn.click();

    }

    @When("user logs in as a teacher")
    public void user_logs_in_as_a_teacher() {
        System.out.println("I am logging in as teacher");

        SignInPage signInPage = new SignInPage();
        signInPage.email.sendKeys(ConfigurationReader.get("teacher.email"));
        signInPage.password.sendKeys(ConfigurationReader.get("teacher.password"));
        signInPage.signIn.click();

    }


}

