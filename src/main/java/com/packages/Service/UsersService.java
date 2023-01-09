package com.packages.Service;

import com.packages.POJOs.UsersPojo;
import com.packages.Persistence.UsersDao;
import com.packages.exceptions.EmailNotFoundException;
import com.packages.exceptions.PasswordIncorrectException;

import java.util.Set;

public class UsersService {
    private UsersDao dao;

    public UsersService(UsersDao dao) {

        this.dao = dao;
    }
    public void registerNewUser(UsersPojo user){
        dao.create(user);
    }
    public UsersPojo authenticateEmail(String email, String password) throws EmailNotFoundException, PasswordIncorrectException {
        return dao.authenticateEmail(email, password);
    }
    public UsersPojo authenticateManager(String email, String password) throws EmailNotFoundException, PasswordIncorrectException {
        return dao.authenticateManager(email, password);
    }
    public Set<UsersPojo> getAllUsers() {
        return dao.getAllUsers();
    }
}
