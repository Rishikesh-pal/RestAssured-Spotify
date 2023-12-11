package utils;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specbuilder {


    @Step
    public static RequestSpecification reqspec(){
        return new RequestSpecBuilder()
                .setBasePath("https://api.spotify.com")
                .setBasePath("/v1")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer ")
                .log(LogDetail.ALL)
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
