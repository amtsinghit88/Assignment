package steps;

import constant.HttpStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Reporter;
import pojo.userDetails;

import static apiEndPoints.Endpoints.LOGIN;
import static apiEndPoints.Endpoints.REGISTER;
import static utils.ApiUtils.postRequest;

public class LoginUser {

    Response response;
    @When("^send a HTTP post request with set email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void createUser(String email,String password) {
        userDetails details = new userDetails();
        details.setEmail(email);
        details.setPassword(password);
        response = (Response) postRequest(details.toString(),LOGIN);

    }


    @Then("^return a success status and verify login response$")
    public void verfication() {
        Reporter.log("status of login user api "+ response.statusCode(),true);
        org.testng.Assert.assertTrue(response.statusCode() == HttpStatus.HTTP_OK,"unable to created user");
        JSONObject jsonObject = new JSONObject(response.body().toString());
        Reporter.log((String) jsonObject.get("token"),true);
    }

}
