package com.packages;

import com.packages.POJOs.UsersPojo;
import com.packages.Persistence.ConnectionManager;
import com.packages.Persistence.UsersDao;
import com.packages.Service.UsersService;
import com.packages.exceptions.EmailNotFoundException;
import com.packages.exceptions.PasswordIncorrectException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EmailNotFoundException, PasswordIncorrectException {
//throws JsonProcessingException
//        BillsClass BillClass = new BillsClass();
//
//        ObjectMapper mapper = new ObjectMapper();
//        String JSON = mapper.writeValueAsString(BillClass);
//        System.out.println(JSON);

//        Javalin app = Javalin.create().start(8080);

        ConnectionManager.getConnection();

//        UsersService user = new UsersService(new UsersDao());
//        Set<UsersPojo> users = user.getAllUsers();
//        for(UsersPojo u : users) {
//            System.out.println(u);
//        }

        System.out.println("Are you an employee or manager? If need to register, type 'register'.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.equals("Employee") || input.equals("employee")) {
            //input employee login email and password
            System.out.println("Enter your email and password.");
            System.out.println("Email:");
            String email1 = sc.nextLine();
            System.out.println("Password:");
            String pw = sc.nextLine();

            UsersDao userDao = new UsersDao();
            userDao.authenticateEmail(email1, pw);

        } else if (input.equals("Manager") || input.equals("manager")) {
            //input manager login email and password
            System.out.println("Enter your email and password.");
            System.out.println("Email:");
            String email2 = sc.nextLine();
            System.out.println("Password:");
            String pw2 = sc.nextLine();

            UsersDao userDao = new UsersDao();
            userDao.authenticateManager(email2, pw2);

        } else if (input.equals("register") || input.equals("Register")) {
            //register first name, last name, email, password
            UsersDao ud = new UsersDao();
            UsersPojo up = new UsersPojo();
            UsersService us = new UsersService(ud);
            us.registerNewUser(up);
        } else {
            System.out.println("Try again.");
        }
    }
}
