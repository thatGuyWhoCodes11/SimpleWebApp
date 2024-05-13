/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develogical.client;

/**
 *
 * @author ASUS
 */
public class User {
        String username;
    public User(String username){
        this.username = username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void sendMessage(String message){
        ChatRoom.showMessage(this, message);
    }

    public String getUsername() {
        return this.username;
    }
}
