package steps;

import constant.HttpStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.Reporter;
import pojo.userDetails;

import java.util.ArrayList;

import static apiEndPoints.Endpoints.CREATE;
import static apiEndPoints.Endpoints.REGISTER;
import static utils.ApiUtils.*;

public class CreateUser {

    public static ArrayList<String> idList = new ArrayList<>();
    Response response;
    @When("^send a HTTP post request with set name \"([^\"]*)\" and job \"([^\"]*)\"$")
    public void createUser(String name,String job) {
        userDetails details = new userDetails();
        details.setName(name);
        details.setJob(job);
        response = postRequest(details.toString(),CREATE);

    }


    @Then("^return a success status and verify create response$")
    public void verfication() {
        Reporter.log("status of create user api "+ response.statusCode(),true);
        org.testng.Assert.assertTrue(response.statusCode() == HttpStatus.HTTP_CREATED,"unable to created user");
        JSONObject jsonObject = new JSONObject(response.body().toString());
        Reporter.log((String) jsonObject.get("name"),true);
        Reporter.log((String) jsonObject.get("job"),true);
        idList.add((String) jsonObject.get("id"));
        Reporter.log((String) jsonObject.get("id"),true);
        Reporter.log((String) jsonObject.get("createdAt"),true);

    }

}
