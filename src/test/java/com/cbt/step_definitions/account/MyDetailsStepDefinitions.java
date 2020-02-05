package com.cbt.step_definitions.account;

import com.cbt.pages.MapPage;
import com.cbt.pages.MySelfPage;
import com.cbt.pages.RoomPage;
import com.cbt.pages.SignInPage;
import com.cbt.utilities.ExcelUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class MyDetailsStepDefinitions {
    @Then("correct room information should be displayed for light side")
    public void correct_room_information_should_be_displayed_for_light_side() {
        // get the room names from the excel file
        // file path and sheetname
        String file = "./src/test/resources/test_data/light-side-test-data.xlsx";
        String sheet = "light-side-rooms";
        ExcelUtil roomData = new ExcelUtil(file, sheet);

        // iterate through all the rows in the excel sheet
        // Map<String, String> row  --> represents one row
        // why it is a map --> because getDataList is a list of maps

        for (Map<String, String> room : roomData.getDataList()) {
            System.out.println(room.get("name"));

            // click on each room
            MapPage mapPage = new MapPage();
            String roomName = room.get("name");

            mapPage.room(roomName).click();

            // VERIFY CAPACITY
            RoomPage roomPage = new RoomPage();

            String capacity = room.get("capacity");
            System.out.println(capacity);

            String actualAttribute = roomPage.capacityImg.getAttribute("src");

            System.out.println(actualAttribute);

            if (capacity.startsWith("6")) {
                Assert.assertTrue(actualAttribute.endsWith("six.svg"));
            } else {
                Assert.assertTrue(actualAttribute.endsWith("four.svg"));
            }

            // based on the room information from excel verify UI

            // VERIFY EQUIPMENT
            // room.get("equipment")  expected value from excel
            // roomPage.equipment.getText()  --> actual value from UI

            Assert.assertEquals(room.get("equipment"), roomPage.equipment.getText());

            roomPage.map.click();
        }

    }


    @When("my self page should display personal information for that user")
    public void my_self_page_should_display_personal_information_for_that_user() {
        // open the myself page
        new MapPage().goToSelf();

        // get the excel data
        String file = "./src/test/resources/test_data/light-side-test-data.xlsx";
        String sheet = "light-side-users";
        ExcelUtil userData = new ExcelUtil(file, sheet);

        // get the specific user information based on email from that excel data
//        using variable SignInPage.currentUserEmail  we will look for the user data from excel
        System.out.println(SignInPage.currentUserEmail);

        // look for a value of a key email in a list of maps, and return the map which contains that key, value combination

        // get all the excel data in a list of maps
        List<Map<String, String>> usersMapList = userData.getDataList();
        // and itirate through each map
        // each map represents one row from the excel, each row represents one user

        for (Map<String, String> user : usersMapList) {
            // check if the currentuseremail value matches the value in the map
            if (SignInPage.currentUserEmail.equalsIgnoreCase(user.get("email"))) {
                System.out.println(user);
                // get the actual information from UI
                // compare
                MySelfPage mySelfPage = new MySelfPage();
//               verify name
                String expectedName = user.get("name");
                String actualName = mySelfPage.name.getText();
                Assert.assertEquals(expectedName, actualName);
//                verify role
                String expectedRole = user.get("role");
                String actualRole = mySelfPage.role.getText();
                Assert.assertTrue(actualRole.contains(expectedRole.trim()));
//                verify team
                String expectedTeam = user.get("team");
                String actualTeam = mySelfPage.team.getText();
                Assert.assertEquals(expectedTeam.trim(), actualTeam);
//                verify campus
                String expectedCampus = user.get("campus");
                String actualCampus = mySelfPage.campus.getText();
                Assert.assertEquals(expectedCampus, actualCampus);
//                verify batch
                String expectedBatch= user.get("batch");
                String actualBatch = mySelfPage.batch.getText();
                Assert.assertEquals(expectedBatch, actualBatch);

                // once the testing is done for current user, stop executing the method so that
                // execution will not reach the assertion fail below
                return;
            }


        }
        // will execute only if the current email is not found in the excel data
        Assert.fail(SignInPage.currentUserEmail + " was not found in the test data");

    }


    @Given("the calculator app is open")
    public void theCalculatorAppIsOpen() {
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        
    }

    @Then("calculator should display result {int}")
    public void calculatorShouldDisplayResult(int arg0) {
    }
}
