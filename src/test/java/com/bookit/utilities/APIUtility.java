package com.bookit.utilities;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APIUtility {

    static {
        System.out.println(ConfigurationReader.get("bookit.api."+ConfigurationReader.get("environment")));
//        baseURI = ConfigurationReader.get("bookit.api"+ConfigurationReader.get("environment"));
    }

    /**
     * Method that generates access token by using enums
     *
     * @return bearer token
     */
    public static String getToken(UserType type) {
        String token = null, email = null, password = null;

        switch (type) {
            case TEACHER:
                email = ConfigurationReader.get("teacher_email");
                password = ConfigurationReader.get("teacher_password");
                break;
            case TEAM_LEADER:
                email = ConfigurationReader.get("team_leader_email");
                password = ConfigurationReader.get("team_leader_password");
                break;
            case TEAM_MEMBER:
                email = ConfigurationReader.get("team_member_email");
                password = ConfigurationReader.get("team_member_password");
                break;
        }
        Response response = given().
                queryParam("email", email).
                queryParam("password", password).
                when().get("/sign");
        response.then().statusCode(200);
        return response.path("accessToken");

    }

    /**
     * Method that generates access token
     *
     * @return bearer token
     */
    public static String getTokenForBookit() {
        Response response = given().
                queryParam("email", ConfigurationReader.get("team.leader.email")).
                queryParam("password", ConfigurationReader.get("team.leader.password")).
                when().
                get("/sign").prettyPeek();
        return response.jsonPath().getString("accessToken");
    }

    /**
     * Method that generates access token
     * @param role - type of user. allowed types: student team leader, student team member and teacher
     * @return bearer token
     */
    public static String getTokenForBookit(String role) {
        String userName = "";
        String password = "";
        if (role.toLowerCase().contains("lead")) {
            userName = ConfigurationReader.get("team.leader.email");
            password = ConfigurationReader.get("team.leader.password");
        } else if (role.toLowerCase().contains("teacher")) {
            userName = ConfigurationReader.get("teacher.email");
            password = ConfigurationReader.get("teacher.password");
        } else if (role.toLowerCase().contains("member")) {
            userName = ConfigurationReader.get("team.member.email");
            password = ConfigurationReader.get("team.member.password");
        } else {
            throw new RuntimeException("Invalid user type!");
        }
        Response response = given().
                queryParam("email", userName).
                queryParam("password", password).
                when().
                get("/sign").prettyPeek();
        return response.jsonPath().getString("accessToken");
    }



}
