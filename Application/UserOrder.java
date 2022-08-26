package com.example.chemwood;

public class UserOrder {
        private String Name;
        private String Phone;
        private String Address;
        private String FurnitureName;
        private String FurnitureID;
        private String UnitPrice;
        private String Units;
        private String TotalPrice;

    public UserOrder() {
    }

    public UserOrder(String name, String phone,String address, String furnitureName, String furnitureID, String unitPrice, String units, String totalPrice) {
        Name = name;
        Phone = phone;
        Address= address;
        FurnitureName = furnitureName;
        FurnitureID = furnitureID;
        UnitPrice = unitPrice;
        Units = units;
        TotalPrice = totalPrice;
    }

    public String getName() { return Name; }

    public void setName(String name) { Name = name; }

    public String getPhone() { return Phone; }

    public String getAddress() { return Address; }

    public void setAddress(String address) { Address = address; }

    public void setPhone(String phone) { Phone = phone; }

    public String getFurnitureName() { return FurnitureName; }

    public void setFurnitureName(String furnitureName) { FurnitureName = furnitureName; }

    public String getFurnitureID() { return FurnitureID; }

    public void setFurnitureID(String furnitureID) { FurnitureID = furnitureID; }

    public String getUnitPrice() { return UnitPrice; }

    public void setUnitPrice(String unitPrice) { UnitPrice = unitPrice; }

    public String getUnits() { return Units; }

    public void setUnits(String units) { Units = units; }

    public String getTotalPrice() { return TotalPrice; }

    public void setTotalPrice(String totalPrice) { TotalPrice = totalPrice; }
}
