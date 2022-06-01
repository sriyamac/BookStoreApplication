package com.sriya.projects.bookstore.domain;

//this class needs to be abstract
public abstract class Product implements Comparable{
    private String name;
    private String type;
    private ProductType productType;
    private int stock;
    private double price;

    public Product(String type, String name, int stock, double price) { //constructor
        this.name = name;
        this.type = type;
        this.stock = stock;
        this.price = price;
    }

    public Product() {

    }

    public String getName() { //getter for product name
        return name;
    }

    public void setName(String name) { //setter for product name
        this.name = name;
    }

    public String getType() { //getter for product type
        return type;
    }

    public void setType(String type) { //setter for product type
        this.type = type;
    }

    public ProductType getProductType() { //getter for product type
        return productType;
    }

    public void setProductType(ProductType productType) { //setter for product type
        this.productType = productType;
    }

    public int getStock() { //getter for product stock
        return stock;
    }

    public void setStock(int stock) { //setter for product stock
        this.stock = stock;
    }

    public double getPrice() { //getter for product price
        return price;
    }

    public void setPrice(double price) { //setter for product price
        this.price = price;
    }


    public int compareTo(Product p) {
        if(this.getStock() == p.getStock()) { //if product is in stock
            System.out.println("Products have the same size stock!"); //tells user product is in stock
            return 0;
        }
        else if (this.getStock() != p.getStock()) { //if product is not in stock
            System.out.println("Products do not have the same size stock."); //tells user product is not in stock
            return 1;
        }
        return 0;
    }
}
