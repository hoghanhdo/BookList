package com.booklist.beans;

public class Book {
    private int id;
    private String title;
    private String author;
    private double rating;
    private int pages;

    public Book(int id, String title, String author, double rating, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.pages = pages;
    }

    public Book(String title, String author, double rating, int pages) {
        this(-1, title, author, rating, pages);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}

