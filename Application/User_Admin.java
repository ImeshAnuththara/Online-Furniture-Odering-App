package com.example.chemwood;

public class User_Admin {
    private String Name;
    private String NIC;
    private String Password;

    public User_Admin(){

    }

    public User_Admin(String name, String NIC, String password) {
        Name = name;
        this.NIC = NIC;
        Password = password;
    }

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
