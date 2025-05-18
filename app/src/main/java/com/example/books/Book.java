package com.example.books;

public class Book {
    private String title;
    private String author;
    private int iconResId;

    public Book(String title, String author, int iconResId) {
        this.title = title;
        this.author = author;
        this.iconResId = iconResId;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getIconResId() { return iconResId; }
}
