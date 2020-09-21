package com.booklist.beans;

public class BookListInfo {
    private String title;
    private String author;
    private int pages;
    private double rating;
    private String addedDate;

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public BookListInfo(String title, String author, int pages, double rating, String addedDate) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.rating = rating;
        this.addedDate = addedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
