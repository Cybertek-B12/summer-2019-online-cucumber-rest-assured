package com.bookit.step_definitions.hunt;

import com.bookit.pages.HuntPage;
import com.bookit.pages.MySchedulePage;
import com.bookit.pages.SignInPage;
import com.bookit.utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;

import java.util.Map;

public class UserRolesStepDefinitions {

    @Given("the user logs in as a light-side team member")
    public void the_user_logs_in_as_a_light_side_team_member() {
        Driver.get().get(ConfigurationReader.get("url"));
        SignInPage signInPage = new SignInPage();
        Map<String, String> userCredentials = UserUtility.getUserCredentials(
                ApplicationConstants.STUDENT_TEAM_MEMBER, ApplicationConstants.LIGHT_SIDE);
        signInPage.login(userCredentials.get("email"), userCredentials.get("password"));
    }

    @Given("the user logs in as a light-side team lead")
    public void the_user_logs_in_as_a_light_side_team_lead() {
        Driver.get().get(ConfigurationReader.get("url"));
        SignInPage signInPage = new SignInPage();
        Map<String, String> userCredentials = UserUtility.getUserCredentials(
                ApplicationConstants.STUDENT_TEAM_LEADER, ApplicationConstants.LIGHT_SIDE);
        signInPage.login(userCredentials.get("email"), userCredentials.get("password"));
    }

    @Given("the user logs in as a light-side teacher")
    public void the_user_logs_in_as_a_light_side_teacher() {
        Driver.get().get(ConfigurationReader.get("url"));
        SignInPage signInPage = new SignInPage();
        Map<String, String> userCredentials = UserUtility.getUserCredentials(
                ApplicationConstants.TEACHER, ApplicationConstants.LIGHT_SIDE);
        signInPage.login(userCredentials.get("email"), userCredentials.get("password"));

    }

    @Given("there are available spots for scheduling")
    public void there_are_available_spots_for_scheduling() {
        MySchedulePage mySchedulePage = new MySchedulePage();
        mySchedulePage.goToMySchedule();
        // see if there is availabe spots for tomorrow 7:00
        System.out.println(mySchedulePage.isCellBlockAvailable("9:00pm", 0));

    }

    @When("the user hunts for a spot")
    public void the_user_hunts_for_a_spot() {
        HuntPage huntPage = new HuntPage();
        huntPage.hunt.click();
        String today = DateUtility.getTodaysDate("MM/dd/yyyy");
        huntPage.date.sendKeys(today);
        huntPage.getAvailableSessions(today, "8:00pm", "9:00pm");
    }

    @Then("book button should not be displayed")
    public void book_button_should_not_be_displayed() {
        BrowserUtils.verifyElementNotDisplayed(By.tagName("button"));
    }


    @Then("book button should be displayed")
    public void book_button_should_be_displayed() {
        BrowserUtils.verifyElementDisplayed(By.tagName("button"));

    }


}
