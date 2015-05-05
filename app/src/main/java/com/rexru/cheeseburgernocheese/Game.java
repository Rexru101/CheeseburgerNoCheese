package com.rexru.cheeseburgernocheese;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Rexru101 on 4/27/2015.
 */
public class Game
{
    static List<Ingredient> listOfOrderedIngredients;
    static List<Ingredient> otherListOfOrderedIngredients;
    IngredientDeck ingredientDeck;
    OrderDeck orderDeck;
    Player p1;
    Player p2;
    Store store;
    Trash trash;
    OrderArea orderArea;

    Game(Player p1, Player p2)
    {
        for (int i = 0; i < 36; i++)
        {
            listOfOrderedIngredients.add(new Ingredient(i));
        }

        otherListOfOrderedIngredients = Game.listOfOrderedIngredients.subList(11,18);
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(29,36));
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(7,11));
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(29,36));
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(7,11));
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(16,16));

        this.p1 = p1;
        this.p2 = p2;
        ingredientDeck = new IngredientDeck();

        for (int i = 0; i < 5; i++)
        {
            p1.addHand(ingredientDeck.draw());
            p2.addHand(ingredientDeck.draw());
        }

        for (int i = 0; i < 5; i++)
        {
            store.addToStore(ingredientDeck.draw());
        }

        orderDeck = new OrderDeck();
    }

    public void shiftStore()
    {
        trash.addToTrash(store.removeFromStore());
    }
}