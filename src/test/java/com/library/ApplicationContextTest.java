package com.library;

import com.library.dto.ActiveUser;
import com.library.model.Role;
import com.library.model.User;
import com.library.service.RolesService;
import com.library.service.RolesServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

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