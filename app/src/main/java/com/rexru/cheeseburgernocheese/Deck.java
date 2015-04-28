package com.rexru.cheeseburgernocheese;

import java.util.List;
import java.util.Random;

/*
 * Created by Rexru on 4/15/2015.
 */
public class Deck extends Card
{
    List<Ingredient> ingredientDeck;
    List<Order> orderDeck;

    Deck()
    {
        //Random random = new Random();
        //int cardAmount = 0;
        //int ranNum = random.nextInt(6);
        //not necessarily the most efficient
        /*
        while (cardAmount < 80)
        {
            switch (ranNum)
            {
                case 0:
                    if (Ingredient.numOfOils == 0)
                        continue;
                    break;
                case 1:
                    if (Ingredient.numOfDairies == 0)
                        continue;
                    break;
                case 2:
                    if (Ingredient.numOfMeats == 0)
                        continue;
                    break;
                case 3:
                    if (Ingredient.numOfFruits == 0)
                        continue;
                    break;
                case 4:
                    if (Ingredient.numOfVegetables == 0)
                        continue;
                    break;
                case 5:
                    if (Ingredient.numOfGrains == 0)
                        continue;
                    break;
            }

            ingredientDeck.add(new Ingredient(ranNum));
            cardAmount++;
            ranNum = random.nextInt(6);
        }
        cardAmount = 0;
        boolean[] cardWasChosen = new boolean[21];

        while (cardAmount < 21)
        {
            ranNum = random.nextInt(21);
            if (cardWasChosen[ranNum])
                continue;
            orderDeck[cardAmount] = new Order(ranNum);
            cardWasChosen[ranNum] = true;
            cardAmount++;
        }
        */
        //add in duplicates. out of bounds error
        for (int i = 0; i < 80; i++)
            ingredientDeck.add(new Ingredient(i));

    }
}
