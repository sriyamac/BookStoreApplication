package com.sriya.projects.bookstore.domain;

import java.util.Scanner;

public interface BookStoreSpecification {

    /*
    give a product id and a product quantity, update
    stock by adding amount to existing product quantity
    @param productId
    @param amount
    @return
     */
    public int restockProduct(BookStore bookStore , Scanner input);

    /*
    calculate and return dollar amount for current inventory of products
    that is in stock

    @return total in stock value
     */
    public double inventoryValue(BookStore bookStore);

}
