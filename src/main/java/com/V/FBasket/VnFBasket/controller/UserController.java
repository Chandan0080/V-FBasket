package com.V.FBasket.VnFBasket.controller;

import java.util.List;

import com.V.FBasket.VnFBasket.dto.LoginRequest;
import com.V.FBasket.VnFBasket.dto.LoginResponse;
import com.V.FBasket.VnFBasket.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.V.FBasket.VnFBasket.model.User;
import com.V.FBasket.VnFBasket.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registerUser = userService.registerUser(user);
        if(user != null){
            return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllUsers")
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

    @GetMapping("/getUser/{userId}")
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

    @PostMapping("/user/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
        final String token = jwtUtil.generateToken(loginRequest.getUsername());

        User user = userService.getUserByEmail(loginRequest.getUsername());

        return ResponseEntity.ok(new LoginResponse(token, user.getEmail(), user.getRole(), user.getUserId()));

    }

    @GetMapping("/checkUserExists")
    public ResponseEntity<Boolean> checkEmailExists(@RequestParam("email") String email) {
        boolean exists = userService.checkUserExistsByEmail(email);
        return ResponseEntity.ok(exists);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long userId) {
        try{
            boolean b1 = userService.deleteUser(userId);
            if(b1 != false){
                return new ResponseEntity<>(b1, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        }catch(Exception e){
            return null;
        }
    }

}
