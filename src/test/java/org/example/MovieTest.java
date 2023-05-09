package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class MovieTest {

    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Movie Title", 0);
    }

    @Test
    public void getPriceCode() {
        assertEquals(0, movie.getPriceCode());
    }

    @Test
    public void getTitle() {
        assertEquals("Movie Title", movie.getTitle());
    }
}