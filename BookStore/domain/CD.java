package com.sriya.projects.bookstore.domain;

public class CD extends Product {

    public CD(String name, String type, int stock, double price) {
        super(name, type, stock, price);
    }

    public CD() {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}