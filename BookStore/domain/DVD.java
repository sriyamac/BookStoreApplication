package com.sriya.projects.bookstore.domain;

public class DVD extends Product {

    public DVD(String name, String type, int stock, double price) {
        super(name, type, stock, price);
    }

    public DVD(){

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
