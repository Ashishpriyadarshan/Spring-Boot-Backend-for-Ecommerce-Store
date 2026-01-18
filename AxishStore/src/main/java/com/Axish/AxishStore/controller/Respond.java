package com.Axish.AxishStore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Respond {

    @GetMapping("/Respond")
    public String Reply()
    {
        return "Respond RESTApi";
    }
}
