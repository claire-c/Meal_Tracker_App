package com.cconnachan.bottomnavpractice;

import org.junit.Before;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class FoodRecordTest {

    private FoodRecord recordedFood;
    private Food chips;
    private Food cucumber;
    private Food anotherChips;
    private Food pizza;
    private Food sandwich;
    private FoodRecord fullFoodRecord;

    @Before
    public void setup(){
        recordedFood = new FoodRecord();
        chips = new Food("chips", "15/03/2018", MealType.DINNER);
        pizza = new Food("pizza", "20/04/2018", MealType.DINNER);
        sandwich = new Food("sandwich", "03/03/2018", MealType.LUNCH);
        anotherChips = new Food("chips", "12/12/2017", MealType.BREAKFAST);
        cucumber = new Food("cucumber", "01/01/2018", MealType.SNACK);
        fullFoodRecord = new FoodRecord();
        fullFoodRecord.addFood(chips);
        fullFoodRecord.addFood(anotherChips);
        fullFoodRecord.addFood(pizza);
        fullFoodRecord.addFood(sandwich);
        fullFoodRecord.addFood(cucumber);
    }

    @Test
    public void canGetLoggedFood(){
        assertEquals(0, recordedFood.getLoggedFood().size());
    }

    @Test
    public void canAddFood(){
        recordedFood.addFood(chips);
        assertEquals(1, recordedFood.getLoggedFood().size());
    }

    @Test
    public void canGetTotalNumberOfFoodLogs(){
        recordedFood.addFood(cucumber);
        recordedFood.addFood(chips);
        assertEquals(2, recordedFood.totalLogged());
    }

    @Test
    public void canRemoveSpecifiedFood(){
        recordedFood.addFood(chips);
        recordedFood.addFood(anotherChips);
        recordedFood.addFood(cucumber);
        recordedFood.removeFood(chips);
        assertEquals(2, recordedFood.totalLogged());
    }

    @Test
    public void canRemovedSpecifiedFoodMoreThanOnce(){
        recordedFood.addFood(chips);
        recordedFood.addFood(chips);
        recordedFood.addFood(anotherChips);
        recordedFood.addFood(cucumber);
        recordedFood.removeFood(chips);
        recordedFood.removeFood(cucumber);
        assertEquals(1, recordedFood.totalLogged());
    }

    @Test
    public void canCountFoodLogged(){
        assertEquals(5, fullFoodRecord.getLoggedMeals(fullFoodRecord.getLoggedFood()).size());
    }

    @Test
    public void canCountTotalBreakfastItemsLogged(){
        assertEquals((Integer) 1, fullFoodRecord.getBreakfastTotal());
    }

    @Test
    public void canCountTotalLunchItemsLogged(){
        assertEquals((Integer) 1, fullFoodRecord.getLunchTotal());
    }

    @Test
    public void canCountTotalDinnerItemsLogged(){
        assertEquals((Integer) 2, fullFoodRecord.getDinnerTotal());
    }

    @Test
    public void canCountTotalSupperItemsLogged(){
        assertEquals((Integer) 0, fullFoodRecord.getSupperTotal());
    }

    @Test
    public void canCountTotalSnackItemsLogged(){
        assertEquals((Integer) 1, fullFoodRecord.getSnackTotal());
    }

}
