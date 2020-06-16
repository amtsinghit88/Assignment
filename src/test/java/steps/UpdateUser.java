package steps;

import constant.HttpStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Reporter;
import pojo.userDetails;

import java.util.ArrayList;

import static apiEndPoints.Endpoints.*;
import static utils.ApiUtils.postRequest;
import static utils.ApiUtils.putRequest;

public class UpdateUser {


    Response response;
    int i=0;
    String temp;
    @When("^send a HTTP put request with set name \"([^\"]*)\" and job \"([^\"]*)\"$")
    public void createUser(String name,String job) {
        userDetails details = new userDetails();
        details.setName(name);
        details.setJob(job);
        temp = CreateUser.idList.get(i);
        response = putRequest(details.toString(),UPDATE+temp);

    }


    @Then("^return a success status and verify create response$")
    public void verfication() {
        Reporter.log("status of create user api "+ response.statusCode(),true);
        org.testng.Assert.assertTrue(response.statusCode() == HttpStatus.HTTP_OK,"unable to created user");
        JSONObject jsonObject = new JSONObject(response.body().toString());
        Reporter.log((String) jsonObject.get("name"),true);
        Reporter.log((String) jsonObject.get("job"),true);
        Reporter.log((String) jsonObject.get("updatedAt"),true);
        String timeStamp = (String) jsonObject.get("updatedAt");
        timeStamp = timeStamp.replaceAll("[^0-9]", "");
        Reporter.log("timeStamp without - :  "+timeStamp,true);
        long temp = Long.parseLong(timeStamp);
        Reporter.log("unix time stamp ::"+ temp/1000);
    }

}
