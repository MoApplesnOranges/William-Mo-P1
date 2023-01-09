package com.packages.POJOs;

import java.util.Objects;

public class UsersPojo {
    private Integer user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;


    public UsersPojo() {
    }

    public UsersPojo(Integer user_id, String first_name, String last_name, String email, String password) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public UsersPojo(String first_name, String last_name, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersPojo usersPojo = (UsersPojo) o;
        return Objects.equals(user_id, usersPojo.user_id) && Objects.equals(first_name, usersPojo.first_name) && Objects.equals(last_name, usersPojo.last_name) && Objects.equals(email, usersPojo.email) && Objects.equals(password, usersPojo.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, first_name, last_name, email, password);
    }

    public String toString() {
        return "Employees{" +
                "id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
