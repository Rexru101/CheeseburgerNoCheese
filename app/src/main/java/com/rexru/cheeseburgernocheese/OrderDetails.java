package com.rexru.cheeseburgernocheese;

import java.util.List;

/*
 * Created by Rexru101 on 5/2/2015.
 */
public enum OrderDetails
{
    SMOOTHIE (2, OrderAbility.TRADE_DOWN, IngredientCategory.FRUIT, IngredientCategory.VEGETABLE, "smoothie"),

    ;

    int pointValue;
    OrderAbility orderAbility;
    List<Ingredient> recipe;
    //List<IngredientCategory>
    String name;

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory, Ingredient ingredient, String name)
    {
        this.pointValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe.add();
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory1, IngredientCategory ingredientCategory2, String name)
    {
        this.pointValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe.add();
    }
    OrderDetails(int pointValue, OrderAbility orderAbility, List<Ingredient> recipe, String name)
    {
        this.pointValue = pointValue;
        this.orderAbility = orderAbility;
        this.recipe = recipe;
        this.name = name;
    }
    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientDetails ingredientDetails)
    {

    }
}
