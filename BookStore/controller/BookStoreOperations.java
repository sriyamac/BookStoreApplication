package com.sriya.projects.bookstore.controller;

import com.sriya.projects.bookstore.domain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookStoreOperations implements BookStoreSpecification{

    //below are the static member objects that I used a lot when debugging
    public  void addTestMember(BookStore bookStore) {
        Member member = new Member("Ram", "Free", false, 0, "Check", 0);
        bookStore.addMember(member);
        member = new Member("Sriya", "Premium", true, 5.00, "Check", 10.00);
        bookStore.addMember(member);
    }

    //below are static product objects that are used when purchasing
    public  void addTestProducts(BookStore bookStore) {

        Scanner fileScanner;

        try{
            fileScanner = new Scanner(new File("project1-final\\bookstore\\bookstore\\src\\main\\java\\com\\sriya\\projects\\bookstore\\ProductInventory.csv"));
            String line;
            while(fileScanner.hasNext()) {
                line = fileScanner.nextLine();
                //System.out.println(line);
                String[] splitLine = line.split(",");
                //System.out.println(splitLine);


                if(splitLine[1].equalsIgnoreCase("book")) {
                    Product productsBook = new Book(); //creates a new Product object that extends Book
                    String name = splitLine[0];
                    productsBook.setName(name);
                    String type = splitLine[1];
                    productsBook.setType(type);
                    int stock = Integer.parseInt(splitLine[2]);
                    productsBook.setStock(stock);
                    double price = Double.parseDouble(splitLine[3]);
                    productsBook.setPrice(price);

                    //productsList.add(new ProductImplementation(name, type, stock, price));

                    bookStore.addProduct(productsBook); //creating an object
                }
                else if(splitLine[1].equalsIgnoreCase("cd")) {
                    Product productsCD = new CD(); //creates a new Product object that extends CD
                    String name = splitLine[0];
                    productsCD.setName(name);
                    String type = splitLine[1];
                    productsCD.setType(type);
                    int stock = Integer.parseInt(splitLine[2]);
                    productsCD.setStock(stock);
                    double price = Double.parseDouble(splitLine[3]);
                    productsCD.setPrice(price);

                    bookStore.addProduct(productsCD); //creating an object
                }
                else if(splitLine[1].equalsIgnoreCase("dvd")) {
                    Product productsDVD = new DVD(); //creates a new Product object that extends DVD
                    String name = splitLine[0];
                    productsDVD.setName(name);
                    String type = splitLine[1];
                    productsDVD.setType(type);
                    int stock = Integer.parseInt(splitLine[2]);
                    productsDVD.setStock(stock);
                    double price = Double.parseDouble(splitLine[3]);
                    productsDVD.setPrice(price);

                    bookStore.addProduct(productsDVD); //creating an object
                }

            }

            fileScanner.close();

        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFound Exception Error");
        }

    }

    public void dailyReport(BookStore bookStore){
        try {

            List<Product> productInventoryValue = bookStore.getProducts(); //creating am array list that gets products list

            String TEXT_FILE = "project1-final\\\\bookstore\\\\bookstore\\\\src\\\\main\\\\java\\\\com\\\\sriya\\\\projects\\\\bookstore\\\\Atomic_Report.txt";
            File textFile = new File(TEXT_FILE);
            boolean isFileCreated = textFile.createNewFile(); //creates a new atomic file

            PrintWriter writer = new PrintWriter(TEXT_FILE);
            for(Product productAmount : productInventoryValue) { //goes through the array
                //write the 4 values into the file
                writer.println(productAmount.getName() + "," + productAmount.getType() + "," + productAmount.getStock() + "," + productAmount.getPrice()); //calculates the total amount an item stock costs
            }

            writer.close();




        } catch (IOException ex) {
            System.out.println("IO Exception Error");
        }
    }

    public void bookInventoryDay(BookStore bookStore){
        try {

            String TEXT_FILE = "project1-final\\\\bookstore\\\\bookstore\\\\src\\\\main\\\\java\\\\com\\\\sriya\\\\projects\\\\bookstore\\\\BookInventoryDay2.csv";
            File textFile = new File(TEXT_FILE);
            boolean isFileCreated = textFile.createNewFile(); //creates a new atomic file

            PrintWriter writer = new PrintWriter(TEXT_FILE);

            List<Product> productInventoryValue = bookStore.getProducts(); //creating am array list that gets products list


            Product product;


            for(Product productAmount : productInventoryValue) { //goes through the array

                //write the 4 values into the file

                writer.println(productAmount.getName() + "," + productAmount.getType() + "," + productAmount.getStock() + "," + productAmount.getPrice()); //calculates the total amount an item stock costs
                //System.out.println(productAmount.getName() + "," + productAmount.getType() + "," + productAmount.getStock() + "," + productAmount.getPrice()); //calculates the total amount an item stock costs
                // ^ line above is for debugging :D
            }

            writer.close();




        } catch (IOException ex) {
            System.out.println("IO Exception Error");
        }
    }


    //below is the addMember method that takes in user input and creates a new member
    public  void addMember(BookStore bookStore , Scanner input ) {
        Member member = new Member();
        System.out.print("Enter Member Name: ");
        member.setName(input.nextLine());

        String paymentMethod;
        boolean isValid = false;
        do {
            System.out.print("Enter Payment Method (Cash/Card/Check): ");
            paymentMethod = input.nextLine();
            isValid =  paymentMethod.equalsIgnoreCase("Cash") ||
                    paymentMethod.equalsIgnoreCase("Card") ||
                    paymentMethod.equalsIgnoreCase("Check");
            if(!isValid) {
                System.out.println("Invalid Payment Method (Cash/Card/Check) Entered: " + paymentMethod);
            }
        } while (!isValid);

        member.setPaymentMethod(paymentMethod); //sets the method of payment


        do {
            System.out.print("Enter Member Type (Free/Premium): ");
            member.setType(input.nextLine());
            isValid =  member.getType().equalsIgnoreCase("Free") ||  ////checks to see if input is valid
                    member.getType().equalsIgnoreCase("Premium");

            if(!isValid) {
                System.out.println("Invalid Membership (Free/Premium) Entered: " + member.getType()); //else, asks user to input again
            }
        } while (!isValid);

        if(member.getType().equalsIgnoreCase("Premium")){  //if user says "premium", then adds static properties (paidDues, feeDues) to the member
            member.setHasPaidDues(true);
            member.setFeeDues(5.00);
            System.out.println("You have paid $" + member.getFeeDues() + " for the Premium Membership");
        }
        bookStore.addMember(member); //adds a new member
    }

    //below is the method I call in the main class (BookStoreApplication) to print out inventory list
    public  void printInventoryList(BookStore bookStore) {
        System.out.println(bookStore.getProducts().size());
        Product product;
        for(int i = 0; i < bookStore.getProducts().size(); i++) {
            product =  bookStore.getProducts().get(i);
            System.out.println("Name: " + product.getName() + " | Type: " + product.getType() + " | Stock: " +  product.getStock());
        }
    }

    //below is the method I call in the main class (BookStoreApplication) to print out premium member list
    public void printPremiumMembersList(BookStore bookStore) {
        List<Member> premiumMembersList = bookStore.getPremiumMembersList();
        System.out.println("Total Premium Members List: "  + premiumMembersList.size());

        for (Member member: premiumMembersList) {
            System.out.println("Name: " + member.getName() + " | Type: " + member.getType()
                    + " | Total Amount Spent: $" + member.getCharges() + " | Are Fees Paid: "
                    + member.isHasPaidDues() + " | Fee Amount: $" + member.getFeeDues() + " | Payment Method: "
                    + member.getPaymentMethod());
        }
    }

    //below is the method I call in the main class (BookStoreApplication) to print out free member list
    public void printFreeMembersList(BookStore bookStore) {
        List<Member> freeMembersList = bookStore.getFreeMembersList();
        System.out.println("Total Free Members List :"  + freeMembersList.size());

        for (Member member: freeMembersList) {
            System.out.println("Name: " + member.getName() + " | Type: " + member.getType()
                    + " | Total amount spent: $" + member.getCharges() + " | Payment Method: "
                    + member.getPaymentMethod());
        }
    }

    //below asks user inputs for purchasing
    public void buyProducts(BookStore bookStore , Scanner input ) {
        Product product = new ProductImplementation(); //had to change because of making Product class an abstract class

        try {
            this.printInventoryList(bookStore);
            System.out.print("Enter Product Name: ");
            product.setName(input.nextLine());
            System.out.print("Enter Product Type (Book / CD / DVD): ");
            product.setType(input.nextLine());
            if (bookStore.isProductInStock(product)) {
                System.out.println("We have this item in stock!");
            } else {
                System.out.println("We don't have this item in stock, please select another item.");
                return;
            }

            String name;
            System.out.print("Enter the member name that's buying the product: "); //aks user for their name
            boolean isValid;
            do {
                name = input.nextLine();
                isValid = bookStore.isMemberFound(name); //checks to see if user is in the member list

                if (isValid == false) { //if the user is not in the member list
                    System.out.println("Please register yourself as a member"); //it will return them back to the menu so that they can register themselves as a member
                    return;
                } else if (isValid == true) {
                    System.out.println("Thank you for shopping " + name); //user is in the member list
                }

            } while (!isValid);

            bookStore.buyProduct(product, name); //user purchases the product
        } catch(Exception exp) {
            System.out.println("General Exception Error");
        }

    }

    @Override
    public int restockProduct(BookStore bookStore, Scanner input) {

        List<Product> productRestockValue = bookStore.getProducts(); //creating an array list that gets products list


            String productName = "";
            int newProductRestockAmount = 0;
            int indexValue;
            this.printInventoryList(bookStore);
            System.out.print("Enter Product Name: ");
            productName = input.nextLine(); //getting user input of product name

        try {

            for (indexValue = 0; indexValue < productRestockValue.size(); indexValue++) { //searching through array list

                if (productRestockValue.get(indexValue).getName().equalsIgnoreCase(productName)) { //if the product name is found
                    System.out.println("How much you would like to restock?"); //ask use to how much they would like to add to the stock

                    newProductRestockAmount = productRestockValue.get(indexValue).getStock() + input.nextInt(); //assigning variable
                    productRestockValue.get(indexValue).setStock(newProductRestockAmount); //setting new stock

                    System.out.println("Complete!");
                    break;
                }
            }

            if (indexValue == productRestockValue.size()) { //checks for user input errors
                System.out.println("Please enter a valid product name");
            }

        } catch (InputMismatchException exp) {
            System.out.println("InputMismatchException Error");
        } catch (Exception exp) {
            System.out.println("General Exception Error");
        }
       return newProductRestockAmount; //returns an int variable

    }

    @Override
    public double inventoryValue(BookStore bookStore) {
        List<Product> productInventoryValue = bookStore.getProducts(); //creating am array list that gets products list

        double itemAmount = 0.0; //assigning variables
        double totalAmount = 0.0;

        Product product;

        System.out.println("");
        System.out.println("***********************************");
        System.out.println("INVENTORY VALUE");
        System.out.println("********* *****");
        System.out.println("");

        for(Product productAmount : productInventoryValue) { //goes through the array
            itemAmount =  productAmount.getStock() * productAmount.getPrice(); //calculates the total amount an item stock costs
            totalAmount += itemAmount; //adds it into the newly created variable

            System.out.println("Name: " + productAmount.getName()  + " | " + "Item Total Value Amount: $" + itemAmount); //prints it out for the user to see
        }
        System.out.println("Total Inventory Value: $" + totalAmount);
        System.out.println("");
        System.out.println("***********************************");

        return totalAmount; //returns a double variable
    }


}
