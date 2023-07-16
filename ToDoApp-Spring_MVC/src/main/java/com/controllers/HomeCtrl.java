package com.controllers;

import com.dao.ToDoDao;
import com.entities.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import java.util.List;

@Controller
public class HomeCtrl{
    @Autowired
    ToDoDao toDoDao;

    @RequestMapping("/home")
    public String home(Model model){

        String str = "home";
        model.addAttribute("page", str);

        List<ToDo> list = this.toDoDao.getAll();
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
        t.setTodoDate(new Date());
        this.toDoDao.save(t);
        model.addAttribute("msg","Successfully Added...");
        return "home";
    }
}
