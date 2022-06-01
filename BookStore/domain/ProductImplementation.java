package com.sriya.projects.bookstore.domain;

public class ProductImplementation extends Product{

    // @Override
    public void abstractMethod(String strParam) { //only use is for buyProducts method in BookStoreOperations
        System.out.println("Please never instantiate an Abstract class.");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
