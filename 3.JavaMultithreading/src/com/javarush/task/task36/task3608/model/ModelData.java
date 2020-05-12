package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.*;

public class ModelData {
    private List<User> users = new ArrayList<>();
    private User activeUser;
    private boolean displayDeletedUserList;


    //геттеры и сетторы
    public List<User> getUsers() {
        return users;
    }
    public User getActiveUser() {
        return activeUser;
    }
    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }


}
