package com.example.entre31proto3.Catalog;

import java.util.Date;

public class Book {


    private String Book_Name;
    private String Book_Desc;
    private String Img_Location;
    private String BookApk;
    private String Creator;
    private int Book_Price;
    private Date Publish_Date;

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }


    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public String getBook_Desc() {
        return Book_Desc;
    }

    public void setBook_Desc(String book_Desc) {
        Book_Desc = book_Desc;
    }

    public String getImg_Location() {
        return Img_Location;
    }

    public void setImg_Location(String img_Location) {
        Img_Location = img_Location;
    }

    public String getBookApk() {
        return BookApk;
    }

    public void setBookApk(String bookApk) {
        BookApk = bookApk;
    }

    public int getBook_Price() {
        return Book_Price;
    }

    public void setBook_Price(int book_Price) {
        Book_Price = book_Price;
    }

    public Date getPublish_Date() {
        return Publish_Date;
    }

    public void setPublish_Date(Date publish_Date) {
        Publish_Date = publish_Date;
    }


    /////////////////////////////////////////////////////////////
//    private String name, country, city, imgURL;
//    public String getImgURL() {
//        return imgURL;
//    }
//
//    public void setImgURL(String imgURL) {
//        this.imgURL = imgURL;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
}
