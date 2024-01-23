package com.ufrn.user.controllers;

import com.ufrn.user.dtos.UserDTO;
import com.ufrn.user.models.UserModel;
import com.ufrn.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserDTO userDTO){
        UserModel user = userService.saveUser(userDTO);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
