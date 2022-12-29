package com.revature.POJOs;

import java.util.Objects;

public class TasksPojo {
    private Integer task_id;
    private Integer amount;
    private String description;
    private String status;
    private Integer user_id;

    public TasksPojo() {
    }

    public TasksPojo(Integer task_id, Integer amount, String description, String status, Integer user_id) {
        this.task_id = task_id;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.user_id = user_id;
    }

    public TasksPojo(Integer amount, String description, String status, Integer user_id) {
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.user_id = user_id;
    }

    public TasksPojo(Integer amount, String description, String status) {
        this.amount = amount;
        this.description = description;
        this.status = status;
    }

    public Integer getTaskId() {
        return task_id;
    }

    public void setTaskId(Integer taskId) {
        this.task_id = taskId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TasksPojo tasksPojo = (TasksPojo) o;
        return Objects.equals(task_id, tasksPojo.task_id) && Objects.equals(amount, tasksPojo.amount) && Objects.equals(description, tasksPojo.description) && Objects.equals(status, tasksPojo.status) && Objects.equals(user_id, tasksPojo.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task_id, amount, description, status, user_id);
    }

    @Override
    public String toString() {
        return "TasksPojo{" +
                "taskId=" + task_id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}