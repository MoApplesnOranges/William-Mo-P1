package com.revature.POJOs;

import java.util.Objects;

public class TicketsPojo {
    private Integer tasks_task_id;
    private Integer tasks_amount;
    private String tasks_description;
    private String tasks_status;
    private Integer tasks_user_id;
    private Integer p_tickets_task_id;
    private Integer p_tickets_amount;
    private String p_tickets_description;
    private String p_tickets_status;
    private Integer p_tickets_user_id;

    public TicketsPojo() {
    }

    public TicketsPojo(Integer tasks_task_id, Integer tasks_amount, String tasks_description, String tasks_status,
                       Integer tasks_user_id, Integer p_tickets_task_id, Integer p_tickets_amount,
                       String p_tickets_description, String p_tickets_status, Integer p_tickets_user_id) {
        this.tasks_task_id = tasks_task_id;
        this.tasks_amount = tasks_amount;
        this.tasks_description = tasks_description;
        this.tasks_status = tasks_status;
        this.tasks_user_id = tasks_user_id;
        this.p_tickets_task_id = p_tickets_task_id;
        this.p_tickets_amount = p_tickets_amount;
        this.p_tickets_description = p_tickets_description;
        this.p_tickets_status = p_tickets_status;
        this.p_tickets_user_id = p_tickets_user_id;
    }

    public Integer getTasks_task_id() {
        return tasks_task_id;
    }

    public void setTasks_task_id(Integer tasks_task_id) {
        this.tasks_task_id = tasks_task_id;
    }

    public Integer getTasks_amount() {
        return tasks_amount;
    }

    public void setTasks_amount(Integer tasks_amount) {
        this.tasks_amount = tasks_amount;
    }

    public String getTasks_description() {
        return tasks_description;
    }

    public void setTasks_description(String tasks_description) {
        this.tasks_description = tasks_description;
    }

    public String getTasks_status() {
        return tasks_status;
    }

    public void setTasks_status(String tasks_status) {
        this.tasks_status = tasks_status;
    }

    public Integer getTasks_user_id() {
        return tasks_user_id;
    }

    public void setTasks_user_id(Integer tasks_user_id) {
        this.tasks_user_id = tasks_user_id;
    }

    public Integer getP_tickets_task_id() {
        return p_tickets_task_id;
    }

    public void setP_tickets_task_id(Integer p_tickets_task_id) {
        this.p_tickets_task_id = p_tickets_task_id;
    }

    public Integer getP_tickets_amount() {
        return p_tickets_amount;
    }

    public void setP_tickets_amount(Integer p_tickets_amount) {
        this.p_tickets_amount = p_tickets_amount;
    }

    public String getP_tickets_description() {
        return p_tickets_description;
    }

    public void setP_tickets_description(String p_tickets_description) {
        this.p_tickets_description = p_tickets_description;
    }

    public String getP_tickets_status() {
        return p_tickets_status;
    }

    public void setP_tickets_status(String p_tickets_status) {
        this.p_tickets_status = p_tickets_status;
    }

    public Integer getP_tickets_user_id() {
        return p_tickets_user_id;
    }

    public void setP_tickets_user_id(Integer p_tickets_user_id) {
        this.p_tickets_user_id = p_tickets_user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketsPojo that = (TicketsPojo) o;
        return Objects.equals(tasks_task_id, that.tasks_task_id) && Objects.equals(tasks_amount, that.tasks_amount) && Objects.equals(tasks_description, that.tasks_description) && Objects.equals(tasks_status, that.tasks_status) && Objects.equals(tasks_user_id, that.tasks_user_id) && Objects.equals(p_tickets_task_id, that.p_tickets_task_id) && Objects.equals(p_tickets_amount, that.p_tickets_amount) && Objects.equals(p_tickets_description, that.p_tickets_description) && Objects.equals(p_tickets_status, that.p_tickets_status) && Objects.equals(p_tickets_user_id, that.p_tickets_user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tasks_task_id, tasks_amount, tasks_description, tasks_status, tasks_user_id, p_tickets_task_id, p_tickets_amount, p_tickets_description, p_tickets_status, p_tickets_user_id);
    }

    @Override
    public String toString() {
        return "TicketsPojo{" +
                "tasks_task_id=" + tasks_task_id +
                ", tasks_amount=" + tasks_amount +
                ", tasks_description='" + tasks_description + '\'' +
                ", tasks_status='" + tasks_status + '\'' +
                ", tasks_user_id=" + tasks_user_id +
                ", p_tickets_task_id=" + p_tickets_task_id +
                ", p_tickets_amount=" + p_tickets_amount +
                ", p_tickets_description='" + p_tickets_description + '\'' +
                ", p_tickets_status='" + p_tickets_status + '\'' +
                ", p_tickets_user_id=" + p_tickets_user_id +
                '}';
    }
}
