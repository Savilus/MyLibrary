package com.library.service;

import com.library.model.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class LoginServiceImplTest {

    private final String EXISTING_LOGIN = "existingLogin";
    private final String CORRECT_PASSWORD = "correctPassword";
    private final User user = new User(
            1,
            EXISTING_LOGIN,
            CORRECT_PASSWORD,
            "test"
    );

    private final LoginService loginService = new LoginServiceImpl(
            login -> {
                if (EXISTING_LOGIN.equals(login)) {
                    return Optional.of(user);
                } else {
                    return Optional.empty();
                }
            }
    );

    @Test
    void shouldReturnTrueIfUserProvidesExistingLoginAndPassword() {
        boolean result = loginService.hasProvidedCorrectLoginData(EXISTING_LOGIN, CORRECT_PASSWORD);
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseIfUserProvidesExistingLoginAndIncorrectPassword() {
        boolean result = loginService.hasProvidedCorrectLoginData(EXISTING_LOGIN, "test");
        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnFalseIfUserProvidesNotExistingLogin() {
        boolean result = loginService.hasProvidedCorrectLoginData("test", "test");
        assertThat(result).isFalse();
    }

}