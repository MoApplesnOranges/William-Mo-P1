package com.revature.Persistence;

import com.revature.Main;
import com.revature.POJOs.TasksPojo;
import com.revature.POJOs.TicketsPojo;
import com.revature.POJOs.UsersPojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TasksDao {
    private Connection connection;
    public TasksDao() {
        this.connection = ConnectionManager.getConnection();
    }
    public Set<TasksPojo> getAllTickets() {
        Set<TasksPojo> ticketResults = new HashSet<>();
        try {
            String sql = "SELECT * FROM tasks ORDER BY task_id";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ticketResults.add(new TasksPojo(rs.getInt("task_id"), rs.getInt("amount"), rs.getString("description"),
                        rs.getString("status"), rs.getInt("user_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketResults;
    }
    public void updateTicket(){
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> approveDeny = new HashMap<Integer, String>();
        approveDeny.put(1, "Approved");
        approveDeny.put(2, "Denied");
        System.out.println("View reimbursement requests and enter taskId number:");
        int a = sc.nextInt();
        sc.nextLine();
        System.out.println("If want to approve reimbursement, enter '1', if want to deny reimbursement, enter '2':");
        int b = sc.nextInt();
        sc.nextLine();
        try{
            String sql = "UPDATE tasks SET status = ? WHERE task_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, approveDeny.get(b));
            pstmt.setInt(2, a);

            String sql1 = "INSERT INTO p_tickets SELECT * FROM tasks WHERE task_id = ?";
            PreparedStatement prestmt = connection.prepareStatement(sql1);
            prestmt.setInt(1, a);

            String sql2 = "DELETE FROM tasks WHERE task_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql2);
            ps.setInt(1, a);

            pstmt.executeUpdate();
            prestmt.executeUpdate();
            ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public Set<TasksPojo> viewPendingTicket(int userId) {
        Set<TasksPojo> results = new HashSet<>();
        Set<TasksPojo> results1 = new HashSet<>();
        try{
            String sql = "SELECT * FROM tasks WHERE user_id = ?";
            String sql2 = "SELECT * FROM p_tickets WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            PreparedStatement pstmt1 = connection.prepareStatement(sql2);
            pstmt.setInt(1, userId);
            pstmt1.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            ResultSet r = pstmt1.executeQuery();
            while(rs.next()) {
                results.add(new TasksPojo(rs.getInt("task_id"), rs.getInt("amount"),
                        rs.getString("description"), rs.getString("status"), rs.getInt("user_id")));
            } while(r.next()) {
                results1.add(new TasksPojo(r.getInt("task_id"), r.getInt("amount"),
                        r.getString("description"), r.getString("status"), r.getInt("user_id")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
    public Set<TasksPojo> viewProcessedTicket(int userId) {
        Set<TasksPojo> results1 = new HashSet<>();
        try{
            String sql2 = "SELECT * FROM p_tickets WHERE user_id = ?";
            PreparedStatement pstmt1 = connection.prepareStatement(sql2);
            pstmt1.setInt(1, userId);
            ResultSet r = pstmt1.executeQuery();
            while(r.next()) {
                results1.add(new TasksPojo(r.getInt("task_id"), r.getInt("amount"),
                        r.getString("description"), r.getString("status"), r.getInt("user_id")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return results1;
    }
    public Set<TasksPojo> viewApprovedTicket(int userId) {
        Set<TasksPojo> results = new HashSet<>();
        try{
            String sql = "SELECT * FROM p_tickets WHERE user_id = ? AND status = 'Approved'";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet r = pstmt.executeQuery();
            while(r.next()) {
                results.add(new TasksPojo(r.getInt("task_id"), r.getInt("amount"),
                        r.getString("description"), r.getString("status"), r.getInt("user_id")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
    public Set<TasksPojo> viewDeniedTicket(int userId) {
        Set<TasksPojo> results = new HashSet<>();
        try{
            String sql = "SELECT * FROM p_tickets WHERE user_id = ? AND status = 'Denied'";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet r = pstmt.executeQuery();
            while(r.next()) {
                results.add(new TasksPojo(r.getInt("task_id"), r.getInt("amount"),
                        r.getString("description"), r.getString("status"), r.getInt("user_id")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
