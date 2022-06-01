package com.sriya.projects.bookstore.domain;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    public List<Member> members = new ArrayList<>(); //list of all the premium and free members
    public List<Product> products = new ArrayList<>(); //list of all the products


    public List<Member> getMembers() { //getter for members
        return members;
    }

    public List<Product> getProducts() { //getter for products
        return products;
    }

    public List<Member> getPremiumMembersList() { //getter for premium members
        List<Member> premiumMembersList  = new ArrayList<>();
        for (Member member: members) {
            if(member.isPremiumMember()) {
                premiumMembersList.add(member);
            }
        }
        return  premiumMembersList;
    }

    public List<Member> getFreeMembersList() { //getter for free members
        List<Member> freeMembersList  = new ArrayList<>();
        for (Member member: members) {
            if(member.isFreeMember()) {
                freeMembersList.add(member);
            }
        }
        return  freeMembersList;
    }

    public boolean isMemberFound (String memberToCheck) {
        boolean found = false;
        for (Member member: members) {
            found =  (member.getName().equalsIgnoreCase(memberToCheck)); //checks to see if member is found
        }
        return found;
    }

    public boolean isProductFound (Product productToCheck) {
        boolean found = false;
        for (Product product: products) {
            found =  (product.getType().equalsIgnoreCase(productToCheck.getType()) //checks to see if product type is found
                    && product.getName().equalsIgnoreCase(productToCheck.getName())); //checks to see if product name is found
        }
        return found;
    }

    public boolean isProductInStock (Product productToCheck) { //checks if product is in stock
        for (Product product: products) {
            if((product.getType().equalsIgnoreCase(productToCheck.getType())
                    && product.getName().equalsIgnoreCase(productToCheck.getName()))) {
                return product.getStock() > 0; //product has to be greater than 0, else returns false
            }
        }
        return false;
    }

    public boolean addMember(Member member) { //adds a new member from user input
        boolean memberSaved = false;
        if(!isMemberFound(member.getName())) {
            this.members.add(member);
            memberSaved = true;
        }
        return memberSaved;
    }

    public boolean addProduct(Product product) { //adds a new product (mostly used for static product objects)
        boolean productSaved = false;
        if(!isProductFound(product)) {
            this.products.add(product);
            productSaved = true;
        }
        return productSaved;
    }

    public Member getMemberByName (String name) { //getter for member name
        for (Member member: members) {
            if(member.getName().equalsIgnoreCase(name)) {
                return member;
            };
        }
        return null;
    }

    public Product getProduct (Product productToCheck) { //getter for product
        for (Product product: products) {
            if (product.getType().equalsIgnoreCase(productToCheck.getType())
                    && product.getName().equalsIgnoreCase(productToCheck.getName())) {
                return product;
            }
        }
        return null;
    }

    public boolean buyProduct (Product productToBuy, String memberName) {
        // reduce the stock
        // add item price to member
        Member member = getMemberByName(memberName);
        Product product = getProduct(productToBuy);
        product.setStock(product.getStock()-1); //reduces stock -1
        member.setCharges(product.getPrice()); //sets price
        return false;
    }






    }
