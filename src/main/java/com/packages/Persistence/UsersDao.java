package com.packages.Persistence;

import com.packages.POJOs.TasksPojo;
import com.packages.POJOs.UsersPojo;
import com.packages.exceptions.EmailNotFoundException;
import com.packages.exceptions.PasswordIncorrectException;

import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UsersDao {

    private Connection connection;
    public UsersDao() {
        this.connection = ConnectionManager.getConnection();
    }
    public void create(UsersPojo users) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name:");
        String fn = sc.nextLine();
        System.out.println("Enter your last name:");
        String ln = sc.nextLine();
        System.out.println("Enter your email:");
        String email = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        try{
            PreparedStatement pstmt1 = connection.prepareStatement("select * from users");
            ResultSet r = pstmt1.executeQuery();
            if(r.next()) {
                String matchEmail = r.getString("email");
                if (matchEmail.equals(email)) {
                    System.out.println("Email already exists");
                } else {
                    String sql = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1, fn);
                    pstmt.setString(2, ln);
                    pstmt.setString(3, email);
                    pstmt.setString(4, password);

                    pstmt.executeUpdate();
                    ResultSet rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        users.setUser_id(rs.getInt("user_id"));
                        System.out.println("DEBUG - auto generated key: " + users.getUser_id() + " is user_id. Employee " +
                                "successfully added. Please login again to access tasks.");
                    }
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public UsersPojo authenticateEmail(String email, String password) throws EmailNotFoundException, PasswordIncorrectException {
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if(!rs.next()){
                throw new EmailNotFoundException("Email was not found");
            }
            UsersPojo user = new UsersPojo(rs.getInt("user_id"
            ), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),
                    rs.getString("password"));

            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Success!");
                System.out.println("If you would like to enter a reimbursement ticket, enter '1'. If you would like to " +
                        "view previous submissions, enter '2'.");
                int a = sc.nextInt();
                sc.nextLine();
                if (a == 1) {
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Input the total amount of your reimbursement ticket:");
                    int d = sc1.nextInt();
                    sc1.nextLine();
                    System.out.println("Describe the expenses:");
                    String expenses = sc1.nextLine();
                    try{
                        String sql1 = "INSERT INTO tasks (amount, description, status, user_id) VALUES (?, ?, ?, ?)";
                        PreparedStatement pstmt1 = connection.prepareStatement(sql1);
                        pstmt1.setInt(1, d);
                        pstmt1.setString(2, expenses);
                        pstmt1.setString(3, "pending");
                        pstmt1.setInt(4, user.getUser_id());

                        pstmt1.executeUpdate();
                    } catch(SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Ticket successfully submitted!");
                } else if (a == 2) {
                    System.out.println("If you would like to view all previous reimbursement tickets, enter '1'.");
                    System.out.println("If you would like to filter by 'pending (2)', 'approved (3)', or 'denied (4)' please enter" +
                            " 2, 3, or 4:");
                    int b = sc.nextInt();
                    sc.nextLine();
                    if(b == 1) {
                        TasksDao vt = new TasksDao();
                        Set<TasksPojo> tasks = vt.viewPendingTicket(user.getUser_id());
                        for (TasksPojo t : tasks) {
                            System.out.println(t);
                        }
                        Set<TasksPojo> tasks1 = vt.viewProcessedTicket(user.getUser_id());
                        for(TasksPojo t: tasks1) {
                            System.out.println(t);
                        }
                    } else if(b == 2) {
                        TasksDao vt = new TasksDao();
                        Set<TasksPojo> tasks = vt.viewPendingTicket(user.getUser_id());
                        for (TasksPojo t : tasks) {
                            System.out.println(t);
                        }
                    } else if(b == 3) {
                        TasksDao vt = new TasksDao();
                        Set<TasksPojo> tasks = vt.viewApprovedTicket(user.getUser_id());
                        for(TasksPojo t : tasks) {
                            System.out.println(t);
                        }
                    } else if(b == 4) {
                        TasksDao vt = new TasksDao();
                        Set<TasksPojo> tasks = vt.viewDeniedTicket(user.getUser_id());
                        for(TasksPojo t : tasks) {
                            System.out.println(t);
                        }
                    }
                }
            } else {
                    throw new PasswordIncorrectException("Password does not match email");
                }
            } catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public UsersPojo authenticateManager(String email, String password) throws EmailNotFoundException, PasswordIncorrectException {
        String sql = "SELECT * FROM managers WHERE email = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if(!rs.next()){
                throw new EmailNotFoundException("Email was not found");
            }
            UsersPojo user = new UsersPojo(rs.getInt("user_id"
            ), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),
                    rs.getString("password"));

            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Success!");
                TasksDao td = new TasksDao();
                Set<TasksPojo> tasks = td.getAllTickets();
                for(TasksPojo t : tasks) {
                    System.out.println(t);
                }
                td.updateTicket();
            } else {
                throw new PasswordIncorrectException("Password does not match email");
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
    public Set<UsersPojo> getAllUsers() {
        Set<UsersPojo> results = new HashSet<>();
        String sql = "SELECT * FROM users ORDER BY user_id";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                results.add(new UsersPojo(rs.getInt("user_id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email"),
                        rs.getString("password")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public void update(UsersPojo users) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ? WHERE user_id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, users.getFirst_name());
            pstmt.setString(2, users.getLast_name());
            pstmt.setString(3, users.getEmail());
            pstmt.setString(4, users.getPassword());
            pstmt.setInt(5, users.getUser_id());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(UsersPojo users) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, users.getUser_id());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
