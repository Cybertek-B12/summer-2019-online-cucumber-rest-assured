package com.bookit.step_definitions;

import com.bookit.utilities.APIUtility;
import com.bookit.utilities.UserType;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSenderOptions;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class APIStepDefinitions {
    protected RequestSpecification requestSpecification;
    protected JsonPath jsonPath;
    protected Response response;
    protected String token;

    @Given("the user has access token as a student")
    public void the_user_has_access_token_as_a_student() {
        token = APIUtility.getToken(UserType.TEAM_MEMBER);
    }

    @When("the user creates a new student")
    public void the_user_creates_a_new_student() {

        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String password = firstName + lastName;

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

    @Given("authorization token is provided for {string}")
    public void authorization_token_is_provided_for(String role) {
        token = APIUtility.getTokenForBookit(role);
    }

    @When("user sends GET request to {string}")
    public void user_sends_GET_request_to(String path) {
        response = requestSpecification.auth().oauth2(token).when().get(path);
    }

    @Then("user should be able to see {int} rooms")
    public void user_should_be_able_to_see_rooms(int roomCount) {
        List<Map<String, Object>> rooms = response.prettyPeek().jsonPath().get();
        assertEquals(roomCount, rooms.size());
    }

    @Then("user verifies that response status code is {int}")
    public void user_verifies_that_response_status_code_is(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.statusCode());
    }

    @Given("user accepts content type as {string}")
    public void user_accepts_content_type_as(String string) {
        requestSpecification = given().contentType(string);
    }

    @When("user sends POST request to {string} with following information:")
    public void userSendsPOSTRequestToWithFollowingInformation(String path, List<Map<String, String>> students) {
        for(Map<String, String> student: students){
            response = requestSpecification.auth().oauth2(token).queryParams(student).when().post(path).prettyPeek();
        }
    }

    @When("user sends DELETE request to {string}")
    public void user_sends_DELETE_request_to(String path) {
        response = requestSpecification.auth().oauth2(token).when().delete(path).prettyPeek();
    }
}
