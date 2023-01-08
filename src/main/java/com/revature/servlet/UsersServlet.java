package com.revature.servlet;

import com.revature.POJOs.UsersPojo;
import com.revature.Persistence.UsersDao;
import com.revature.Service.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class UsersServlet extends HttpServlet {
    private UsersService service;

    public UsersService getService() {
        return service;
    }

    public void setService(UsersService service) {
        this.service = service;
    }

    @Override
    public void init() throws ServletException {
        this.service = new UsersService(new UsersDao());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        Set<UsersPojo> users = service.getAllUsers();
            resp.getWriter().println(users);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
