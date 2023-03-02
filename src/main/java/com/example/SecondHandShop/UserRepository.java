package com.example.SecondHandShop;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserRepository {

    ArrayList<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new User("Carin", "124"));
        users.add(new User("Jonathan", "234"));
    }

    public ArrayList<User> getUsers() {
       return this.users;
    }

    public User getUserByUsername(String username) {
        User getUser = null;
        for(User user: users) {
            if(user.getUsername().equals(username)) {
                getUser = user;
            }
        }
        return getUser;
    }


    public void createUser(String username, String password) {
        for(User user: users) {
            if(username.equals(user.getUsername())) {

                return;
            }
        }
        User user = new User(username, password);
        users.add(user);
        System.out.println("New user successfully created!");
    }

    public boolean loginUser(String username, String password) {
        for(User user : users) {
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
