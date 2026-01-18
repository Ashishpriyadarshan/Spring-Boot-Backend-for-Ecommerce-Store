package com.eazybytes.controller;

import com.eazybytes.model.Customer;
import com.eazybytes.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer)
    {
        try {

            if(userRegistrationService.registerCustomer(customer).getId()>0)
            {
                log.info("The user was registered with username:"+customer.getEmail());
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("The User with Email: "+customer.getEmail()+" was successfully Registered");
            }
            else
            {
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                        .body("The User Registration Failed ");
            }
        } catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Cannot register the User in the DB :"+ex.getMessage());
        }
    }
}
