package com.sriya.projects.bookstore.domain;


public class Book extends Product {

    public Book(String name, String type, int stock, double price) {
        super(name, type, stock, price);
    }

    public Book(){

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
