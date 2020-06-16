package utils;


import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class ApiUtils {



    public static io.restassured.response.ExtractableResponse postRequest(String postRequest, String endPoints){
         Response response = given().header("content-type","application/json")
                .body(postRequest)
                .post(endPoints);
        return (ExtractableResponse) response;
    }

    public static Response putRequest(String postRequest, String endPoints){
        Response response = given().header("content-type","application/json")
                .body(postRequest)
                .put(endPoints);
        return response;
    }


    public static Response deleteRequest(String endPoints){
        Response response = given()
                .delete(endPoints);
        return response;
    }
}
