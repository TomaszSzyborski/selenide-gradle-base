package com.tomasz.tests;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

import com.tomasz.core.FakingModule;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Slf4j
@Guice(modules = FakingModule.class)
@Feature("Some magic test for feature XYZ")
public class SampleSelenideTest extends BaseTest {

    // @Inject
    // Faking faking;
    // private final String uuidRegex =
    // "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
    //
    // @Test
    // @Step("Power Plant commander successful registration")
    // public void successfulCommanderRegistration() {
    // CreateCommanderPayload commander = new
    // CreateCommanderPayload(faking.with().name().firstName());
    // ValidatableResponse response = Desk.pickupControlRoomKey(commander);
    // response.statusCode(SC_CREATED);
    // String message = response.extract().response().as(InformationModel.class).message();
    // assertThat(message)
    // .as("Message from the clerk at the reception")
    // .isEqualTo("Take the key to your control room." +
    // " Keep it safe." +
    // " use it as resource path to check on your RBMK-1000 reactor!" +
    // " Use following: /{key}/control_room to gain knowledge how to operate reactor." +
    // " You may see if the core is intact here: /{key}/reactor_core ." +
    // " If anything goes wrong push AZ-5 safety button to put all control rods in place!" +
    // " Good luck Commander.");
    // response.assertThat().body("key", matchesRegex(uuidRegex));
    // }
    //
    // @Test
    // @Step("Spy reaching for the key")
    // public void spyReachingForTheKey() {
    // CreateCommanderPayload commander = new
    // CreateCommanderPayload(faking.with().name().firstName());
    // Desk.pickupControlRoomKey(commander).statusCode(SC_CREATED);
    // ValidatableResponse response = Desk.pickupControlRoomKey(commander);
    // response.statusCode(SC_UNPROCESSABLE_ENTITY);
    // assertThat(response.extract().body().as(InformationModel.class).message())
    // .as("Message from the clerk at the reception")
    // .isEqualTo("A spy?! That Power Plant Tech Commander has already checked in!");
    //
    // }

    @Test
    @Description("something test3")
    public void test3() {
        mainPage.isAt();
    }

    @Test
    @Step("is at 1")
    public void test4() {
        $(".custom-logo-link").should(disappear);
    }

    @Test
    @Step("is at 1")
    public void test5() {
        $(".custom-logo-link").should(disappear);
    }
}
