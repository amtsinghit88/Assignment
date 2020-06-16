package steps;

import constant.HttpStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Reporter;
import pojo.userDetails;

import static apiEndPoints.Endpoints.LOGIN;
import static apiEndPoints.Endpoints.UPDATE;
import static utils.ApiUtils.*;

public class DeleteUser {

    Response response;
    @When("^send a HTTP delete request with set userid$")
    public void createUser() {
        String id= CreateUser.idList.get(0);
        response = deleteRequest(UPDATE+id);

    }


    @Then("^return a success status and verify response$")
    public void verfication() {
        Reporter.log("status of delete user api "+ response.statusCode(),true);
        org.testng.Assert.assertTrue(response.statusCode() == HttpStatus.HTTP_NOCONTENT,"unable to created user");
    }

}
