package com.tomasz.rest.actions;

import static io.restassured.RestAssured.given;

import com.tomasz.core.Endpoints;
import com.tomasz.rest.models.CreateCommanderPayload;
import io.qameta.allure.Step;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import lombok.SneakyThrows;

public class Desk extends BaseAction {

    @SneakyThrows
    @Step("Picking up key form the desk for {commander.name}")
    public static ValidatableResponse pickupControlRoomKey(CreateCommanderPayload commander) {
        return given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .log().ifValidationFails(LogDetail.ALL, true)
                .body(commander)
                .when()
                .post(Endpoints.DESK.getEndpoint())
                .then();
    }
}
