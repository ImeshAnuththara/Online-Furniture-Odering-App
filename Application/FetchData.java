package com.example.chemwood;

import java.io.Serializable;

public class FetchData implements Serializable {
    String Tittle;
    String Photo;
    String Id;

    public FetchData() {
    }

    public FetchData(String tittle, String photo,String Id) {
        this.Tittle = tittle;
        this.Photo = photo;
        this.Id = Id;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getId() { return Id; }

    public void setId(String id) { Id = id; }
}
