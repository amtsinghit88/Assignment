package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import java.util.HashMap;

public class ConfigurationSteps {


    @Given("^setup BaseUrl and headers$")
    public void init() {
        RestAssured.baseURI = "https://reqres.in/";
    }
}
