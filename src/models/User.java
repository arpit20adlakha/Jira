package models;

import java.util.Date;

public class User {
    String name;
    Integer userId;
    Date createdAt;
    Date updatedAt;


    public String getName() {
        return this.name;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
