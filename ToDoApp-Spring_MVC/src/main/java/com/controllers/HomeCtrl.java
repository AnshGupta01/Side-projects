package com.controllers;

import com.entities.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.List;

@Controller
public class HomeCtrl{

    @Autowired
    ServletContext context;
    @RequestMapping("/home")
    public String home(Model model){

        String str = "home";
        model.addAttribute("page", str);

        List<ToDo> list = (List<ToDo>) context.getAttribute("list");
        model.addAttribute("todos", list);
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

    @RequestMapping(value = "/saveTodo",method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("todo") ToDo t, Model model){
        System.out.println(t);
        //getting the todo list of context
        List<ToDo> list = (List<ToDo>) context.getAttribute("list");
        list.add(t);
        model.addAttribute("msg","Successfully Added...");


        t.setTodoDate(new Date());

        return "home";
    }
}
