package com.rexru.cheeseburgernocheese;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Created by Rexru on 4/15/2015.
 */
public class IngredientDeck
{
    List<Ingredient> ingredientDeck;
    ImageView imageView;

    IngredientDeck()
    {
//        //Random random = new Random();
//        //int cardAmount = 0;
//        //int ranNum = random.nextInt(6);
//        //not necessarily the most efficient
//        /*
//        while (cardAmount < 80)
//        {
//            switch (ranNum)
//            {
//                case 0:
//                    if (Ingredient.numOfOils == 0)
//                        continue;
//                    break;
//                case 1:
//                    if (Ingredient.numOfDairies == 0)
//                        continue;
//                    break;
//                case 2:
//                    if (Ingredient.numOfMeats == 0)
//                        continue;
//                    break;
//                case 3:
//                    if (Ingredient.numOfFruits == 0)
//                        continue;
//                    break;
//                case 4:
//                    if (Ingredient.numOfVegetables == 0)
//                        continue;
//                    break;
//                case 5:
//                    if (Ingredient.numOfGrains == 0)
//                        continue;
//                    break;
//            }
//
//            ingredientDeck.add(new Ingredient(ranNum));
//            cardAmount++;
//            ranNum = random.nextInt(6);
//        }
//        cardAmount = 0;
//        boolean[] cardWasChosen = new boolean[21];
//
//        while (cardAmount < 21)
//        {
//            ranNum = random.nextInt(21);
//            if (cardWasChosen[ranNum])
//                continue;
//            orderDeck[cardAmount] = new Order(ranNum);
//            cardWasChosen[ranNum] = true;
//            cardAmount++;
//        }
//        */
        //create deck
        ingredientDeck = new ArrayList<>();
        Ingredient ingredient;

        for (IngredientDetails iDetails: IngredientDetails.values())
        {
            ingredient = new Ingredient(iDetails);
            ingredientDeck.add(ingredient);

            switch (ingredient.ingredientDetail)
            {
                case CHEESE://x2
                case MILK:
                case BROCCOLI:
                case VEGGIE_PATTY:
                    ingredientDeck.add(new Ingredient(iDetails));
                    break;
                case PASTA://x3
                case WHOLE_WHEAT_PASTA:
                case APPLE:
                case CARROTS:
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    break;
                case CHICKEN://x4
                case STEAK:
                case TOMATO:
                case MUSHROOM:
                case SPINACH:
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    break;
                case LETTUCE://x5
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    break;
                case EGGS://x6
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    break;
                case RICE://x9
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    ingredientDeck.add(new Ingredient(iDetails));
                    break;
            }
        }
        Collections.shuffle(ingredientDeck);
    }

    public void setImageView(ImageView imageV)
    {
        imageView = imageV;
    }

    public int getDrawableResource()
    {
        return R.drawable.back_template;
    }

    public Ingredient draw()
    {
        Ingredient temp = ingredientDeck.get(0);
        ingredientDeck.remove(0);
        return temp;
    }

    public List<Ingredient> getIngredientDeck()
    {
        return ingredientDeck;
    }
}