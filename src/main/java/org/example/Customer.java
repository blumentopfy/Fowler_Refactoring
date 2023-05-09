package org.example;

import java.lang.*;
import java.util.*;

public class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<Rental>();
    public Customer (String newname){
        name = newname;
    }
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }
    public String getName (){
        return name;
    }
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        StringBuilder resultStringBuilder = new StringBuilder("Rental Record for " + this.getName() + "\n");
        resultStringBuilder.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = each.amountFor();
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two-day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            resultStringBuilder.append("\t").append(each.getMovie().getTitle()).append("\t").append("\t").append(each.getDaysRented()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        //add footer lines
        resultStringBuilder.append("Amount owed is ").append(totalAmount).append("\n");
        resultStringBuilder.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return resultStringBuilder.toString();
    }
}