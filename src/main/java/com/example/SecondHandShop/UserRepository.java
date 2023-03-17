package com.example.SecondHandShop;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserRepository {

    ArrayList<Account> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new Account("Carin", "124"));
        users.add(new Account("Jonathan", "234"));
    }

    public ArrayList<Account> getUsers() {
       return this.users;
    }

    public Account getUserByUsername(String username) {
        Account getUser = null;
        for(Account user: users) {
            if(user.getUsername().equals(username)) {
                getUser = user;
            }
        }
        return getUser;
    }


    public void createUser(String username, String password) {
        for(Account user: users) {
            if(username.equals(user.getUsername())) {

                return;
            }
        }
        Account user = new Account(username, password);
        users.add(user);
        System.out.println("New user successfully created!");
    }

    public boolean loginUser(String username, String password) {
        for(Account user : users) {
            if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public String getUsernameOfLastRegisterdUsers() {
        int number = users.size()-1;

        System.out.println(users.get(number).getUsername());
        return users.get(number).getUsername();
    }


}
