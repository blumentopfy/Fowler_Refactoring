package org.example;

import java.lang.*;
import java.util.*;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();
    public Customer (String newname){
        name = newname;
    }
    public void addRental(Rental arg) {
        rentals.add(arg);
    }
    public String getName (){
        return name;
    }
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder resultStringBuilder = new StringBuilder("Rental Record for " + this.getName() + "\n");
        resultStringBuilder.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental rental: rentals) {
            //determine amounts for each line
            double thisAmount = rental.amountFor();
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two-day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints ++;
            //show figures for this rental
            resultStringBuilder.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        //add footer lines
        resultStringBuilder.append("Amount owed is ").append(totalAmount).append("\n");
        resultStringBuilder.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return resultStringBuilder.toString();
    }
}