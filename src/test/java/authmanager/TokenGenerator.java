package authmanager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ConfigReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class TokenGenerator {

    public static String getAccessToken() throws IOException {

        RestAssured.baseURI = "https://accounts.spotify.com";

        Map<String,String> param = new HashMap<String,String>();
        param.put("grant_type","authorization_code");
        param.put("code", ConfigReader.readPropData("refreshtoken"));
        param.put("client_id",ConfigReader.readPropData("client_id"));
        param.put("client_secret",ConfigReader.readPropData("client_secret"));


        Response response =
                given().contentType(ContentType.URLENC)
                .formParams(param)
                .when()
                .post("api/token")
                .then()
                .extract().response();

        if(response.statusCode()!=200)
        {
            throw new RuntimeException("Failed to create the access token please check the refresh token validity");
        }

        String accessTokenoken = response.jsonPath().getString("access_token");

        return accessTokenoken;
    }
}
