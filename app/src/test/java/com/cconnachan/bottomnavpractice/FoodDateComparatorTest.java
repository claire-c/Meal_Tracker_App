package com.cconnachan.bottomnavpractice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodDateComparatorTest {

    @Test
    public void canGetDateFromString(){
        FoodDateComparator foodDateComparator = new FoodDateComparator();
        assertEquals("Thu Mar 15 00:00:00 GMT 2018", foodDateComparator.getDateFromString("15/03/2018").toString());
    }

}
