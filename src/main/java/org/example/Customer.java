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
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental rental : rentals) {
            //show figures for this rental
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(rental.getCharge()).append("\n");
        }
        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }
    private double getTotalCharge() {
        double charge = 0;

        for (Rental rental : rentals) {
            charge +=  rental.getCharge();
        }

        return charge;
    }

    private int getTotalFrequentRenterPoints() {
        int points = 0;

        for (Rental rental : rentals) {
            points += rental.getFrequentRenterPoints();
        }

        return points;
    }
}
    