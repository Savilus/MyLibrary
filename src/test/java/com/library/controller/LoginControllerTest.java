package com.library.controller;

import com.library.ApplicationContext;
import com.library.dao.UserByLogin;
import com.library.dto.ActiveUser;
import com.library.dto.MainMenuOption;
import com.library.dto.UserLoginData;
import com.library.dto.UserRole;
import com.library.model.Role;
import com.library.model.User;
import com.library.service.UserService;
import com.library.service.UserServiceImpl;
import com.library.view.LoginView;
import com.library.view.MainMenuView;
import com.library.view.View;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.library.ApplicationContext.activeUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    private final String USER_LOGIN = "correctLogin";
    private final String USER_PASSWORD = "correctPassword";
    private final String WRONG_USER_LOGIN = "wrongLogin";
    private final String WRONG_USER_PASSWORD = "wrongPassword";
    private final String NAME = "testName";
    private final String LAST_NAME = "testLastName";
    private final List<Role> ROLES = List.of(new Role(1, "user"));
    private final String EMAIL = "test@test.pl";
    private final User testUser = User.builder()
            .login(USER_LOGIN)
            .password(USER_PASSWORD)
            .email(EMAIL)
            .lastName(LAST_NAME)
            .name(NAME)
            .roles(ROLES)
            .build();
    private UserLoginData userLoginData = new UserLoginData(USER_LOGIN, USER_PASSWORD);
    private ActiveUser testActiveUser = new ActiveUser(
            NAME,
            LAST_NAME,
            EMAIL,
            Set.of(UserRole.USER)
    );

    private final UserService userService = new UserServiceImpl(
            login -> {
                if(USER_LOGIN.equals(login)){
                    return Optional.of(testUser);
                } else {
                    return Optional.empty();
                }
            }
    );

    @Test
    void checkUserWithCorrectLoginAndPassword() {
        // given
        LoginController loginController = new LoginController(userService);
        // when
        View<?> view = loginController.checkUser(userLoginData);
        //then
        assertThat(activeUser()).isEqualTo(testActiveUser);
        assertThat(view).isInstanceOf(MainMenuView.class);
    }

    @Test
    void checkUserWithIncorrectPassword() {
        // given
        LoginController loginController = new LoginController(userService);
        // when
        View<?> view = loginController.checkUser(new UserLoginData(USER_LOGIN, WRONG_USER_PASSWORD));
        // then
        assertThat(view).isInstanceOf(LoginView.class);
    }

    @Test
    void checkUserWithIncorrectLogin() {
        // given
        LoginController loginController = new LoginController(userService);
        // when
        View<?> view = loginController.checkUser(new UserLoginData(WRONG_USER_LOGIN, USER_PASSWORD));
        // then
        assertThat(view).isInstanceOf(LoginView.class);
    }

//  Implementacja lambdy u góry, możemy ją wykonwac dlatego że to intefrejs funkcyjny,
//  jest tak dlatego że ma 1 metodę abstrakcyjną
//
//    private static class LocalUserDao implements UserByLogin{
//
//        @Override
//        public Optional<User> getUserByLogin(String login) {
//            if(USER_LOGIN.equals(login)){
//                    return Optional.of(testUser);
//                } else {
//                    return Optional.empty();
//                }
//        }
//    }

}