package com.tomasz.rest.actions;

import java.util.Map;
import org.apache.http.HttpStatus;

public class AdministrativePurge extends BaseAction {
    public static void perform() {
        api().body(Map.of("purge", true))
                .post("/clear_everything")
                .then()
                .statusCode(HttpStatus.SC_ACCEPTED);
    }
}
