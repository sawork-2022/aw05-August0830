package com.micropos.carts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carts")
public class CartsController {

    @GetMapping("/message")
    public String test(){
        return "carts message";
    }
}
