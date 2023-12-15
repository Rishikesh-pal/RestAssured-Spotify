package utils;

import authmanager.TokenGenerator;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;

public class Specbuilder {


    @Step
    public static RequestSpecification reqspec() throws IOException {
        return new RequestSpecBuilder()
                .setBaseUri("https://api.spotify.com")
                .setBasePath("/v1")
                .addHeader("Content-Type", "application/json")
                .log(LogDetail.ALL)
                .addFilter(new AllureRestAssured())
                .addHeader("Authorization", "Bearer "+ TokenGenerator.renewToken())
                .build();
    }

    @Step
    public static ResponseSpecification resSpec()
    {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

}
