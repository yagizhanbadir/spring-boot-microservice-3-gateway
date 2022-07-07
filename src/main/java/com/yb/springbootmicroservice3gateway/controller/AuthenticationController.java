package com.yb.springbootmicroservice3gateway.controller;

import com.yb.springbootmicroservice3gateway.model.User;
import com.yb.springbootmicroservice3gateway.service.IAuthenticationService;
import com.yb.springbootmicroservice3gateway.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user){

        if (userService.findByUser(user.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user){
        return new ResponseEntity<>(authenticationService.signInAndReturnJwt(user), HttpStatus.OK);
    }

}
