package com.listeners;

import com.entities.ToDo;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

public class MYListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("Context Created...");
        List<ToDo> list = new ArrayList<>();
        ServletContext context = sce.getServletContext();
        context.setAttribute("list", list);



    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {



    }
}
