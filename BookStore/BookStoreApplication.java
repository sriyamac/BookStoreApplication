package com.sriya.projects.bookstore;

import com.sriya.projects.bookstore.controller.BookStoreOperations;
import com.sriya.projects.bookstore.domain.BookStore;
import java.util.Scanner;

public class BookStoreApplication {

    private final BookStore bookStore = new BookStore(); //made it to final so it never gets overridden


    public BookStore getBookStore() { //getter for book store
        return bookStore;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BookStoreApplication application = new BookStoreApplication();
        BookStoreOperations  bookStoreOperations = new BookStoreOperations();

        boolean exit = false;
        bookStoreOperations.addTestMember(application.getBookStore());
        bookStoreOperations.addTestProducts(application.getBookStore());
        do {
            int option = application.operation(input);
            switch (option) {
                case -1 : {
                    exit = false;
                    break;
                }
                case 1: {
                    bookStoreOperations.addMember(application.getBookStore(),input); //calling addMember method
                    break;
                }
                case 2: {
                    bookStoreOperations.buyProducts(application.getBookStore(), input); //calling buyProducts method
                    break;
                }
                case 3: {
                    bookStoreOperations.printInventoryList(application.getBookStore()); //calling printInventoryList method
                    break;
                }
                case 4: {
                    bookStoreOperations.printFreeMembersList(application.getBookStore()); //calling printFreeMembersList method

                    break;
                }
                case 5 : {
                    bookStoreOperations.printPremiumMembersList(application.getBookStore()); //calling printPremiumMembersList method
                    break;
                }
                case 6 : {
                    bookStoreOperations.restockProduct(application.getBookStore(), input);
                    break;
                }
                case 7 : {
                    bookStoreOperations.inventoryValue(application.getBookStore()); //printing inventory stock total amount
                    break;
                }
                default:

                    System.out.println("Generating Daily Report");
                    bookStoreOperations.dailyReport(application.getBookStore()); //calling the daily report

                    System.out.println("Generating Updated Inventory File");
                    bookStoreOperations.bookInventoryDay(application.getBookStore()); //calling bookInventoryDay

                    System.out.println("exiting");
                    exit = true;
            }
        } while (!exit);
    }


    private int operation(Scanner input) { //below is the menu system
        System.out.println("1. Register Member");
        System.out.println("2. Purchase Books, CDs, and DVDs");
        System.out.println("3. View Inventory");
        System.out.println("4. View Free Members: Total Price Spent, Payment Method");
        System.out.println("5. View Premium Members: Type, Total Price Spent, Fee dues, Payment Method ");
        System.out.println("6. Restock Items"); //wip
        System.out.println("7. Inventory Value");
        System.out.println("8. Exit");
        int selection =  -1; //for errors in user input
        try {
            selection = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Input");
            selection = -1;
        }
        return selection;
    }
}
