package com.revature.Persistence;

import com.revature.POJOs.EmployeesPojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.sql.Connection;

public class GetEmployees {

    public Set<EmployeesPojo> getAllEmployees() {
        Connection connection = ConnectionManager.getConnection();
        String sql = "SELECT * FROM employee_login";
        Set<EmployeesPojo> employeesPojo1 = new HashSet<>();

        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                EmployeesPojo employeesPojo = new EmployeesPojo();
                employeesPojo.setId(rs.getInt("id"));
                employeesPojo.setFirst_name(rs.getString("first_name"));
                employeesPojo.setLast_name(rs.getString("last_name"));
                employeesPojo.setEmail(rs.getString("email"));
                employeesPojo.setPassword(rs.getString("password"));
                employeesPojo1.add(employeesPojo);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return employeesPojo1;
    }
}
