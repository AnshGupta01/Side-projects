package com.paytm.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String homePage(){
        System.out.println("Request for Home Page");
        return "home";
    }
    @RequestMapping("/about")
    public String aboutPage(){
        System.out.println("Request for About Page");
        return "about";
    }


}
