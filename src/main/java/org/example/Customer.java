package org.example;

import java.lang.*;
import java.util.*;

class Customer {
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
            double amount;
            //determine amounts for each line
            amount = amountFor(rental);
            frequentRenterPoints += rental.getFrequentRenterPoints();
            //show figures for this rental
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(String.valueOf(amount)).append("\n");
            totalAmount += amount;
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

    private double amountFor(Rental each) {
        double amount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                amount += 2;
                if (each.getDaysRented() > 2)
                    amount += (each.getDaysRented() - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> amount += each.getDaysRented() * 3;
            case Movie.CHILDRENS -> {
                amount += 1.5;
                if (each.getDaysRented() > 3)
                    amount += (each.getDaysRented() - 3) * 1.5;
            }
        }
        return amount;
    }

}
    