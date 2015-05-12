package com.rexru.cheeseburgernocheese;

import com.google.android.gms.games.multiplayer.Participant;

import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Created by Rexru on 4/15/2015.
 */
public class Player
{
    //Cursor cursor;
    List<Ingredient> hand;
    Participant participant;
    List<Order> completedOrders;
    int score;

    Player(Participant participant)
    {
        this.participant = participant;
        completedOrders = new ArrayList<>();
        score = 0;
    }

    Player()//test
    {
        hand = new ArrayList<>();
        completedOrders = new ArrayList<>();
        score = 0;
    }

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
    public boolean completeOrder(List<Ingredient> ingredients, Order order)
    {
        for (int i = 0; i < order.recipe.size(); i++)
        {
            if (order.recipe.get(i).getClass().equals(IngredientCategory.class))//recipe asks for a category
            {
                if (!ingredients.get(i).category.equals(order.recipe.get(i)))
                    return false;
            }
            else if (order.recipe.get(i).getClass().equals(Ingredient.class))//recipe asks for an ingredient
            {
                if (!((Ingredient)order.recipe.get(i)).ingredientDetail.equals(ingredients.get(i).ingredientDetail))
                    return false;
            }
        }
        completedOrders.add(order);
        score += order.starValue;
        return true;
    }

    public void addHand(Ingredient ingredient)
    {
        hand.add(ingredient);
    }
}