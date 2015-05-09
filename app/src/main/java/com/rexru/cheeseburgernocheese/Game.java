package com.rexru.cheeseburgernocheese;

import com.google.android.gms.games.multiplayer.Participant;

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

    //Game(Participant participant1, Participant participant2)
    Game()
    {
        listOfOrderedIngredients = new ArrayList<>();
        otherListOfOrderedIngredients = new ArrayList<>();
        //p1 = new Player(participant1);
        //p2 = new Player(participant2);
        p1 = new Player();
        p2 = new Player();
        //Ingredient ingredient;

        //creates ingredient deck
        for (IngredientDetails iDetails: IngredientDetails.values())
        {
            //ingredient = new Ingredient(iDetails);
            //if (listOfOrderedIngredients.size() == 0)
                //System.out.println(listOfOrderedIngredients.toString());
            listOfOrderedIngredients.add(new Ingredient(iDetails));
        }

        //creates a subset of ingredients 30 elements
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(11, 18));//grains
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(29,36));//vegetables
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(7,11));//meats
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(29,36));//vegetables
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(7,11));//meats
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(16,17));//rice

        for (IngredientDetails iDetails: IngredientDetails.values())
        {
            iDetails.getImageView();
        }
        ingredientDeck = new IngredientDeck();

        for (int i = 0; i < 5; i++)
        {
            p1.addHand(ingredientDeck.draw());
            p2.addHand(ingredientDeck.draw());
        }

        store = new Store();
        for (int i = 0; i < 5; i++)
        {
            store.addToStore(ingredientDeck.draw());
        }

        orderDeck = new OrderDeck();
        orderArea = new OrderArea(orderDeck);
    }

    public void shiftStore()
    {
        trash.addToTrash(store.removeFromStore());
    }
}