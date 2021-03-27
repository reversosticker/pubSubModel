package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    String UserName;
    String role;

    public Map<String, Topic> getTopics() {
        return topics;
    }

    Map<String,Topic> topics;

    public User(String userName, String role) {
        UserName = userName;
        this.role = role;
        this.topics = new HashMap<>();
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
