package com.revature.Service;

import com.revature.Persistence.EmployeeDao;
import com.revature.POJOs.EmployeesPojo;

public class EmployeeService {
    private EmployeeDao dao;
    public EmployeeService(EmployeeDao dao) {
        this.dao = dao;
    }

    public void registerNewEmployee(EmployeesPojo employeesPojo) {
        dao.createNew(employeesPojo);
    }

//    public Set<Employees> getAllEmployees() {
//        return dao.getAllEmployees();
//    }
}
