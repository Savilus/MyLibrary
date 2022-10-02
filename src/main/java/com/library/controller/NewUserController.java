package com.library.controller;

import com.library.dao.AddNewUser;
import com.library.dao.RoleByName;
import com.library.dao.RoleDao;
import com.library.dao.UserDaoImpl;
import com.library.dto.NewUserData;
import com.library.model.Address;
import com.library.model.User;
import com.library.view.MainMenuView;
import com.library.view.View;

import java.util.List;

import static com.library.dto.UserRole.USER;

public class NewUserController {

    private final RoleByName roleByName;
    private final AddNewUser addNewUser;
    public NewUserController() {
        this.addNewUser = new UserDaoImpl();
        this.roleByName = new RoleDao();
    }

    public NewUserController(RoleByName roleByName, AddNewUser addNewUser) {
        this.addNewUser = addNewUser;
        this.roleByName = roleByName;
    }

    public View createNewUser(NewUserData newUserData) {
        User user = new User(newUserData.getLogin(),
                newUserData.getPassword(),
                newUserData.getName(),
                newUserData.getLastName(),
                newUserData.getEmail(),
                new Address(
                        newUserData.getCity(),
                        newUserData.getCountry(),
                        newUserData.getStreet(),
                        newUserData.getZipCode(),
                        newUserData.getBuildingNumber(),
                        newUserData.getApartmentNumber()),
                List.of(),
                List.of(roleByName.findByName(USER.getName())));
        addNewUser.addNewUser(user);
        return new MainMenuView();
    }
}
