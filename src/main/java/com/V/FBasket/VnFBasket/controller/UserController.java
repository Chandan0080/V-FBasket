package com.V.FBasket.VnFBasket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.V.FBasket.VnFBasket.model.User;
import com.V.FBasket.VnFBasket.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("auth/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            if(userService.createUser(user) != null){
                return ResponseEntity.ok(userService.createUser(user));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(500).build();
    }

    @GetMapping("auth/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> u1 = userService.getAllUsers();
            if(u1 != null){
                return new ResponseEntity<>(u1,HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("auth/getUser/{userId}")
    public ResponseEntity<User> getAllUsers(@PathVariable Long userId) {
        try {
            User u1 = userService.getUserById(userId);
            if(u1 != null){
                return new ResponseEntity<>(u1,HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    

}
