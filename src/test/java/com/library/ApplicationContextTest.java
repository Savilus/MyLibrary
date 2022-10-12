package com.library;

import com.library.dto.ActiveUser;
import org.junit.jupiter.api.Test;

class ApplicationContextTest {

    private final String EXISTING_NAME = "existingName";
    private final String EXISTING_LASTNAME = "existingPassword";
    private final ActiveUser activeUser = new ActiveUser(
            EXISTING_NAME,
            EXISTING_LASTNAME,
            "test"
    );
    @Test
    void shouldSetActiveUser(String login) {
    }
}