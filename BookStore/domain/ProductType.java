package com.sriya.projects.bookstore.domain;

public enum ProductType {

    //stores constants
    Book("Book"),
    CD("CD"),
    DVD("DVD");

    //made it to final so it never gets overridden
    private final String value;

    ProductType(String value) {
        this.value = value;
    }
}
