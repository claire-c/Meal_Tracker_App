package com.cconnachan.bottomnavpractice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodTest {

    private Food chips;
    private Food cucumber;

    @Before
    public void setup(){
        chips = new Food("chips", "15/03/2018", MealType.DINNER);
        cucumber = new Food("cucumber", "01/01/2018", MealType.SNACK);
    }

    @Test
    public void canGetName(){
        assertEquals("chips", chips.getName());
    }

    @Test
    public void canGetMealType(){
        assertEquals(MealType.DINNER, chips.getMealType());
    }

    @Test
    public void canGetdate(){
        assertEquals("Thu Mar 15 00:00:00 GMT 2018", chips.getDate().toString());
    }



}
