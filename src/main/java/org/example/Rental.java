package org.example;

public class Rental {
    private final Movie movie;
    private final int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    public double amountFor() {
        double thisAmount = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                if (getDaysRented() > 2){
                    return 2 + (getDaysRented() - 2) * 1.5;
                } else {
                    return 2;
                }
            }
            case Movie.NEW_RELEASE -> {
                return getDaysRented() * 3;
            }
            case Movie.CHILDRENS -> {
                if (getDaysRented() > 3) {
                    return 1.5 +  (getDaysRented() - 3) * 1.5;
                } else {
                    return 1.5;
                }
            }
            default -> {
                return 0;
            }
        }
    }
}