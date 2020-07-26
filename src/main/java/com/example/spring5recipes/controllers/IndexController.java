package com.example.spring5recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: Nikhil Adlakha
 */

@Controller
public class IndexController {

    @RequestMapping({"","/","/index","/home","/in"})
    public String getIndexPage(){
        return "index";
    }
}
