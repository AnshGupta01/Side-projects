package com.controllers;

import com.entities.ToDo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl{
    @RequestMapping("/home")
    public String home(Model model){

        String str = "home";
        model.addAttribute("page", str);
        return "home";
    }

    @RequestMapping("/add")
    public String addTodo(Model model){

        ToDo t = new ToDo();

        String str = "add";
        model.addAttribute("page", str);
        model.addAttribute("todo",t);
        return "home";
    }
}
