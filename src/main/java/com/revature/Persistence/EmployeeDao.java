package com.revature.Persistence;

import com.revature.POJOs.EmployeesPojo;

import java.sql.*;

public class EmployeeDao {
    private Connection connection;

    public EmployeeDao() {
        this.connection = ConnectionManager.getConnection();
    }

    public void createNew(EmployeesPojo employeesPojo) {
        try {
            String sql = "INSERT INTO employee_login (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, employeesPojo.getFirst_name());
            pstmt.setString(2, employeesPojo.getLast_name());
            pstmt.setString(3, employeesPojo.getEmail());
            pstmt.setString(4, employeesPojo.getPassword());

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()) {
                employeesPojo.setId(rs.getInt("user_id"));
                System.out.println("DEBUG - auto generated key: " + employeesPojo.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
