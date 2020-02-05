package com.cbt.step_definitions.login;

import com.cbt.pages.MapPage;
import com.cbt.pages.SignInPage;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
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
        System.out.println("email: " + ConfigurationReader.get("leader_email"));
        System.out.println("password: " + ConfigurationReader.get("leader_password"));

        SignInPage signInPage = new SignInPage();
        signInPage.email.sendKeys(ConfigurationReader.get("leader_email"));
        signInPage.password.sendKeys(ConfigurationReader.get("leader_password"));
        signInPage.signIn.click();

    }

    @Given("user on the login page")
    public void user_on_the_login_page() {
        System.out.println("I am opening the login page");
        // open the login page of the application
        // url is in the properties file
        Driver.get().get(ConfigurationReader.get("url"));
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
        signInPage.email.sendKeys(ConfigurationReader.get("member_email"));
        signInPage.password.sendKeys(ConfigurationReader.get("member_password"));
        signInPage.signIn.click();

    }

    @When("user logs in as a teacher")
    public void user_logs_in_as_a_teacher() {
        System.out.println("I am logging in as teacher");

        SignInPage signInPage = new SignInPage();
        signInPage.email.sendKeys(ConfigurationReader.get("teacher_email"));
        signInPage.password.sendKeys(ConfigurationReader.get("teacher_password"));
        signInPage.signIn.click();

    }


}

