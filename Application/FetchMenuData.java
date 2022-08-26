package com.example.chemwood;

public class FetchMenuData {
    String Tittle;
    String Photo;
    String Price;
    String Id;
    String Description;

    public FetchMenuData() {
    }

    public FetchMenuData(String Tittle, String Photo, String Price, String Id, String Description) {
        //
        this.Tittle = Tittle;
        this.Photo = Photo;
        this.Price = Price;
        this.Id = Id;
        this.Description = Description;
    }

    public String getTittle() { return Tittle; }

    public void setTittle(String tittle) { this.Tittle = tittle; }

    public String getPhoto() { return Photo; }

    public void setPhoto(String photo) { this.Photo = photo; }

    public String getPrice() { return Price; }

    public void setPrice(String price) { this.Price = price; }

    public String getId() { return Id; }

    public void setId(String id) { this.Id = id; }

    public String getDescription() { return Description; }

    public void setDescription(String description) { this.Description = description; }

}
