package com.unitseven.springboot.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String username;
    private byte[] password_hash;

        // Getters and Setters
        public int getUser_id() {
            return user_id;
        }
    
        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }
    
        public String getUsername() {
            return username;
        }
    
        public void setUsername(String username) {
            this.username = username;
        }
    
        public byte[] getPassword_hash() {
            return password_hash;
        }
    
        public void setPassword_hash(byte[] password_hash) {
            this.password_hash = password_hash;
        }
}