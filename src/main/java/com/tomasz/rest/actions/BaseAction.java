package com.tomasz.rest.actions;

import static io.restassured.RestAssured.given;

import com.tomasz.core.PropertySupplier;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseAction {

  protected static final RequestSpecification requestSpecification;

  static {
    var requestSpecBuilder = new RequestSpecBuilder();
    // use authScheme if auth is needed
    // var authScheme = new PreemptiveBasicAuthScheme();
    // authScheme.setUserName(username);
    // authScheme.setPassword(password);
    // requestSpecBuilder.setAuth(authScheme);

    requestSpecBuilder.setBaseUri(PropertySupplier.getEnvironmentConfigurationData().getApiUrl());
    requestSpecBuilder.addHeader("Content-Type", "application/json");
    requestSpecBuilder.addHeader("Accept", "application/json");
    requestSpecification = requestSpecBuilder.build();
  }

  protected static RequestSpecification api() {
    return given()
        .log().ifValidationFails(LogDetail.ALL, true)
        .spec(requestSpecification)
        .contentType(ContentType.JSON)
        .when();
  }
}
