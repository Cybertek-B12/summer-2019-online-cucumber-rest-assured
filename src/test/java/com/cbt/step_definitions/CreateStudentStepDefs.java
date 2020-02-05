package com.cbt.step_definitions;

import com.cbt.utilities.TokenUtility;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateStudentStepDefs {

    String token;
    String email;
    private String firstName;
    private String lastName;
    Response response;
    private String password;

    @Given("the user has access token as a student")
    public void the_user_has_access_token_as_a_student() {

        token = TokenUtility.getToken(TokenUtility.UserType.TEAM_MEMBER);
    }

    @When("the user creates a new student")
    public void the_user_creates_a_new_student() {

        Faker faker = new Faker();
        email = faker.internet().emailAddress();

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        response =
                RestAssured.given().
                        header("Authorization", token).
                        param("first-name", firstName)
                .param("last-name", lastName).
                        param("email", email).
                        param("password", password)
                .param("role", "student-team-member").
                        param("batch-number", "8").
                        param("team-name", "CodeHunters")
                .param("campus-location", "VA").
                        when().post("/api/students/student");

            response.then().log().all();
    }

    @Then("the new student should not be created")
    public void the_new_student_should_not_be_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
