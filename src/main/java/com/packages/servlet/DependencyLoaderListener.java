package com.packages.servlet;

import com.packages.Persistence.UsersDao;
import com.packages.Service.UsersService;

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
