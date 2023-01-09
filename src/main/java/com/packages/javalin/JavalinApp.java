//package com.packages.javalin;
//
//import io.javalin.Javalin;
//import io.javalin.http.Context;
//
//public class JavalinApp {
//    private static Javalin app;
//    private static EmployeeService employeeService;
//
//    private JavalinApp() {
//
//    }
//
//    public static Javalin getApp(int port) {
//        if(app == null) {
//            employeeService = new EmployeeService(new EmployeeDao());
//            init(port);
//        }
//            return app;
//
//    }
//
//    private static void init(int port) {
//        app = Javalin.create()
//                .start(port);
//
//        //user resources
//        app.get("/ping", JavalinApp::ping);
//        app.post("/employees", JavalinApp::postNewEmployees);
////        app.get("/employees", JavalinApp:: getAllEmployees);
////        app.post("/user/auth", JavalinApp::authenticateUser);
//    }
//    public static void ping(Context ctx) {
//        ctx.result("pong!");
//        ctx.status(200);
//    }
//    public static void postNewEmployees(Context ctx) {
//        EmployeesPojo newEmployee = ctx.bodyAsClass(EmployeesPojo.class);
//        employeeService.registerNewEmployee(newEmployee);
//
//        ctx.status(201);
//    }
//}
