package com.revature.POJOs;
import java.util.Objects;
public class EmployeesPojo implements Comparable<EmployeesPojo>{

    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;

    public EmployeesPojo() {

    }

    public EmployeesPojo(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public EmployeesPojo(Integer id, String first_name, String last_name, String email, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public EmployeesPojo(String first_name, String last_name, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        EmployeesPojo employeesPojo = (EmployeesPojo) o;
        return Objects.equals(id, employeesPojo.id) && Objects.equals(first_name, employeesPojo.first_name) && Objects.equals(last_name, employeesPojo.last_name) && Objects.equals(email, employeesPojo.email) && Objects.equals(password, employeesPojo.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, email, password);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    @Override
    public int compareTo(EmployeesPojo that) {
        //return negative if this < that
        //return positive that < this
        //return zero if equal

        // User1 < User2 when user1.getLastName() < user2.getLastName() alphabetically, with first name
        //being used the same way as a tiebreaker

        if(this.equals(that)) {
            return 0;
        }

        if(this.getLast_name().equals(that.getLast_name())) {
            if(this.getFirst_name().equals(that.getFirst_name())) {
                return 0;
            }
        } else {
            return alphabeticalCompare(this.getFirst_name(), that.getFirst_name());
        }

        return alphabeticalCompare(this.getLast_name(), that.getLast_name());
    }

    private int alphabeticalCompare(String a, String b) {
        int size;
        char shorter = 'z';
        if(a.length() <= b.length()) {
            size = a.length();
            shorter = 'a';
        } else {
            size = b.length();
            shorter = 'b';
        }

        for(int i = 0; i < size; i++) {
            if(a.charAt(i) < b.charAt(i)) {
                return -1;
            } else if(a.charAt(i) > b.charAt(i)) {
                return 1;
            }
        }

        if(shorter == 'z') {
            return 0;
        } else if (shorter == 'a') {
            return -1;
        } else {
            return 1;
        }
    }


}
