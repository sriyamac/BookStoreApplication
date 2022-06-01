package com.sriya.projects.bookstore.domain;

public class Member {

    private String name;
    private String type;
    private boolean hasPaidDues;
    private double feeDues;
    private String paymentMethod;// check cash card -- ENUM
    private double charges;
    public String PREMIUM_MEMBER_TYPE = "Premium";
    public String FREE_MEMBER_TYPE = "Free";

    public Member( String name, String type, boolean hasPaidDues, double feeDues, String paymentMethod, double charges) {
        this.name = name;
        this.type = type;
        this.hasPaidDues = hasPaidDues;
        this.feeDues = feeDues;
        this.paymentMethod = paymentMethod;
        this.charges = charges;
    }

    public Member() {
        super();
    }

    public String getName() { //getter for member name
        return name;
    }

    public void setName(String name) { //setter for member name
        this.name = name;
    }

    public String getType() { //getter for member type
        return type;
    }

    public void setType(String type) { //setter for member type
        this.type = type;
    }

    public boolean isHasPaidDues() { //returns if premium member paid dues (true or false)
        return hasPaidDues;
    }

    public void setHasPaidDues(boolean hasPaidDues) { //sets if premium member has paid dues or not
        this.hasPaidDues = hasPaidDues;
    }

    public double getFeeDues() { //getter for fee dues
        return feeDues;
    }

    public void setFeeDues(double feeDues) { //setter for fee dues
        this.feeDues = feeDues;
    }

    public String getPaymentMethod() { //getter for payment method
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) { //setter for payment method
        this.paymentMethod = paymentMethod;
    }

    public double getCharges() { //getter for charges
        return charges;
    }

    public void setCharges(double charges) { //setter for charges
        this.charges = charges;
    }

    public boolean isPremiumMember() { //checks if it is a premium member type
        return this.type.equalsIgnoreCase(PREMIUM_MEMBER_TYPE);
    }

    public boolean isFreeMember() { //checks if it is a free member type
        return this.type.equalsIgnoreCase(FREE_MEMBER_TYPE);
    }

}
