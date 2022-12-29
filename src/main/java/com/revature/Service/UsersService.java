package com.revature.Service;

import com.revature.POJOs.UsersPojo;
import com.revature.Persistence.UsersDao;
import com.revature.exceptions.EmailNotFoundException;
import com.revature.exceptions.PasswordIncorrectException;

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
