package io.github.tuzserik.naukatesttaskbackend.controller;

import io.github.tuzserik.naukatesttaskbackend.model.User;
import io.github.tuzserik.naukatesttaskbackend.model.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/login", "/application"})
    public RedirectView redirectToIndex() {
        return new RedirectView("/index.html");
    }

    @GetMapping(value = {"/api/users"})
    public UserResponse getUsers(){
        return new UserResponse(200, userService.getUsers());
    }

    @GetMapping(value = {"/api/user"})
    public UserResponse getUser(@RequestParam long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return new UserResponse(200, user);
        }
        else return new UserResponse(400, "Произошла ошибка получения пользователя.");
    }

    @PostMapping(value = {"/api/user"})
    public UserResponse addUser(@RequestBody User user) {
        if (userService.saveUser(user)) {
            return new UserResponse(200, user);
        }
        else {
            return new UserResponse(400, "Cannot add or update provided user.");
        }
    }

    @DeleteMapping(value = {"/api/user"})
    public UserResponse deleteUser(@RequestParam Long id) {
        if (userService.deleteUser(id)) {
            return new UserResponse(200, id);
        }
        else {
            return new UserResponse(400, "Cannot delete provided user.");
        }
    }

    @PostMapping(value = {"/api/login"})
    public UserResponse updateLogin(@RequestParam Long id, @RequestParam String newLogin) {
        User user = userService.getUser(id);
        user.setLogin(newLogin);
        userService.saveUser(user);
        return new UserResponse(200, newLogin);
    }

    @PostMapping(value = {"/api/password"})
    public UserResponse updatePassword(@RequestParam Long id, @RequestParam String newPassword) {
        User user = userService.getUser(id);
        user.setPassword(newPassword);
        userService.saveUser(user);
        return new UserResponse(200, newPassword);
    }

    @PostMapping(value = {"/api/name"})
    public UserResponse updateName(@RequestParam Long id, @RequestParam String newName) {
        User user = userService.getUser(id);
        user.setName(newName);
        userService.saveUser(user);
        return new UserResponse(200, newName);
    }

    @PostMapping(value = {"/api/secondName"})
    public UserResponse updateSecondName(@RequestParam Long id, @RequestParam String newSecondName) {
        User user = userService.getUser(id);
        user.setSecondName(newSecondName);
        userService.saveUser(user);
        return new UserResponse(200, newSecondName);
    }

    @PostMapping(value = {"/api/familyName"})
    public UserResponse updateFamilyName(@RequestParam Long id, @RequestParam String newFamilyName) {
        User user = userService.getUser(id);
        user.setFamilyName(newFamilyName);
        userService.saveUser(user);
        return new UserResponse(200, newFamilyName);
    }

    @PostMapping(value = {"/api/birthdayDate"})
    public UserResponse updateBirthdayDay(@RequestParam Long id, @RequestParam String newBirthdayDate) {
        User user = userService.getUser(id);
        user.setBirthdayDate(Long.parseLong(newBirthdayDate));
        userService.saveUser(user);
        return new UserResponse(200, newBirthdayDate);
    }

    @PostMapping(value = {"/api/position"})
    public UserResponse updatePosition(@RequestParam Long id, @RequestParam String newPosition) {
        User user = userService.getUser(id);
        user.setPosition(newPosition);
        userService.saveUser(user);
        return new UserResponse(200, newPosition);
    }

    @PostMapping(value = {"/api/workingStatus"})
    public UserResponse updateWorkingFromStatus(@RequestParam Long id, @RequestParam String newWorkingStatus) {
        User user = userService.getUser(id);
        user.setWorkingFromHome(Boolean.parseBoolean(newWorkingStatus));
        userService.saveUser(user);
        return new UserResponse(200, newWorkingStatus);
    }

    @PostMapping(value = {"/api/city"})
    public UserResponse updateCity(@RequestParam Long id, @RequestParam String newCity) {
        User user = userService.getUser(id);
        user.setCity(newCity);
        userService.saveUser(user);
        return new UserResponse(200, newCity);
    }

    @PostMapping(value = {"/api/street"})
    public UserResponse updateStreet(@RequestParam Long id, @RequestParam String newStreet) {
        User user = userService.getUser(id);
        user.setStreet(newStreet);
        userService.saveUser(user);
        return new UserResponse(200, newStreet);
    }

    @PostMapping(value = {"/api/home"})
    public UserResponse updateHomeNumber(@RequestParam Long id, @RequestParam String newHouseNumber) {
        User user = userService.getUser(id);
        user.setHouse(Integer.parseInt(newHouseNumber));
        userService.saveUser(user);
        return new UserResponse(200, newHouseNumber);
    }

    @PostMapping(value = {"/api/flat"})
    public UserResponse updateFlatNumber(@RequestParam Long id, @RequestParam String newFlatNumber) {
        User user = userService.getUser(id);
        user.setFlat(Integer.parseInt(newFlatNumber));
        userService.saveUser(user);
        return new UserResponse(200, newFlatNumber);
    }
}
