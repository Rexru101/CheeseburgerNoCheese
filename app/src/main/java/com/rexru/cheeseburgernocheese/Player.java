package com.rexru.cheeseburgernocheese;

import java.util.List;

/*
 * Created by Rexru on 4/15/2015.
 */
public class Player
{
    //Cursor cursor;
    List<Ingredient> hand;

    public void play(Ingredient ingredient)
    {

    }

    public void play(Order order)
    {

    }

    public void trade(List<Ingredient> ingredientsToTrade, Ingredient ingredientToGet)
    {

    }

    public void zoom(Ingredient ingredient)
    {

    }

    public void zoom(Order order)
    {

    }
    //category, ingredient
    //category, ingredient1, ingredient2
    //category1, category2
    //category1, category2, ingredient
    //category1, category2, category3, ingredient
    //category1, category2, ingredient1, ingredient2
    public boolean completeOrder(List<Ingredient> recipe, Order order)
    {
        for (int i = 0; i < recipe.size(); i++)
        {
            if (recipe.get(1).getClass().equals(IngredientDetails.class))//
            {

            }
            else
            {

            }
        }
        return false;
    }

    public void addHand(Ingredient ingredient)
    {
        hand.add(ingredient);
    }
}