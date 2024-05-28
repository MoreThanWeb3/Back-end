package com.car.show.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping()
    public  String Welcome(){
        return  "U'r server is already";
    }
}
