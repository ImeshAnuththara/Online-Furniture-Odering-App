package com.example.chemwood;

import java.io.Serializable;

public class AdminFetchData implements Serializable {

    String phone;
    String name;
    String address;
    String furnitureID;
    String furnitureName;
    String units;
    String totalPrice;
    String unitPrice;

    public AdminFetchData() {
    }

    public AdminFetchData(String phone, String name, String address, String furnitureID, String furnitureName, String units, String totalPrice, String unitPrice) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.furnitureID = furnitureID;
        this.furnitureName = furnitureName;
        this.units = units;
        this.totalPrice = totalPrice;
        this.unitPrice = unitPrice;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getFurnitureID() { return furnitureID; }

    public void setFurnitureID(String furnitureID) { this.furnitureID = furnitureID; }

    public String getFurnitureName() { return furnitureName; }

    public void setFurnitureName(String furnitureName) { this.furnitureName = furnitureName; }

    public String getUnits() { return units; }

    public void setUnits(String units) { this.units = units; }

    public String getTotalPrice() { return totalPrice; }

    public void setTotalPrice(String totalPrice) { this.totalPrice = totalPrice; }

    public String getUnitPrice() { return unitPrice; }

    public void setUnitPrice(String unitPrice) { this.unitPrice = unitPrice; }
}

