package com.tomasz.rest.actions;

import static io.restassured.RestAssured.given;

import com.tomasz.core.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.SneakyThrows;

public class Information extends BaseAction {

  @SneakyThrows
  public static Response getInformation() {
    return given()
        .log().ifValidationFails()
        .spec(requestSpecification)
        .contentType(ContentType.JSON)
        .when()
        .get(Endpoints.INFORMATION.getEndpoint())
        .then()
        .log().ifValidationFails()
        .extract()
        .response();
  }
}
