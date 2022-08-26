package com.example.chemwood;

import android.widget.EditText;
import android.widget.TextView;

public class User {
    private String Name;
//    private String Phone;
    private String NIC;
    private String Password;

    public User(){

    }

    public User(String name, String NIC, String password) {
        Name = name;
        this.NIC = NIC;
        Password = password;
     //   Phone=phone;
    }

//    public String getPhone() { return Phone; }

//    public void setPhone(String phone) { Phone = phone; }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
