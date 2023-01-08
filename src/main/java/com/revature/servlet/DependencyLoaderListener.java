package com.revature.servlet;

import com.revature.Persistence.UsersDao;
import com.revature.Service.UsersService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("server context start");
        new UsersService(new UsersDao());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("server context end");
    }
}
