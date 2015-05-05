package com.rexru.cheeseburgernocheese;

import java.util.List;

/*
 * Created by Rexru on 4/15/2015.
 */
public class Order extends Card
{
    int starValue;
    OrderAbility orderAbility;
    OrderDetails orderDetails;
    IngredientDetails recipe;//or ingredients
    String name;

    Order(OrderDetails orderDetails)
    {
        this.starValue = orderDetails.starValue;
        this.name = orderDetails.name;
        this.orderAbility = orderDetails.orderAbility;
        this.recipe = orderDetails.recipe;
    }
}