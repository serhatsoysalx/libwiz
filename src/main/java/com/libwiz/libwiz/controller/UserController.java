package com.libwiz.libwiz.controller;

import com.libwiz.libwiz.dto.UserDtoRequest;
import com.libwiz.libwiz.dto.UserDtoResponse;
import com.libwiz.libwiz.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@Tag(name = "User Api", description = "User Api informations")
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/createuser")
    @Operation(description = "Creater User")
    public ResponseEntity<UserDtoResponse> createUser(@RequestBody UserDtoRequest userDtoRequest) {
        UserDtoResponse createdUser = userService.createUser(userDtoRequest);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/getuser/{id}")
    @Operation(description = "Get sser with id")
    public ResponseEntity<UserDtoResponse> getUserById(@PathVariable Long id) {
        UserDtoResponse user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping("/users")
    @Operation(description = "Get All Users")
    public ResponseEntity<Iterable<UserDtoResponse>> getAllUsers() {
        Iterable<UserDtoResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/updateuser/{id}")
    @Operation(description = "Update User with id and json")
    public ResponseEntity<UserDtoResponse> updateUser(@PathVariable Long id, @RequestBody UserDtoRequest userDtoRequest) {
        UserDtoResponse updatedUser = userService.updateUser(id, userDtoRequest);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @PutMapping("/deleteuser/{id}")
    @Operation(description = "Delete User with id")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
