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
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental rental : rentals) {
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints ++;
            //show figures for this rental
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(rental.getCharge()).append("\n");
            totalAmount += rental.getCharge();
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

}
    