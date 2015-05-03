package com.rexru.cheeseburgernocheese;

import java.util.List;

/*
 * Created by Rexru on 4/15/2015.
 */
public class Ingredient extends Card
{
    IngredientCategory category;
    int tradeCost;
    IngredientDetails cardDetail;
    List<Ingredient> effectedCards;
    IngredientAbility cardAbility;

    Ingredient(int whichIngredient)
    {
        /*
        this.setCategory(whichIngredient);
        this.setTradeCost(whichIngredient);
        this.setName(whichIngredient);
        */
        IngredientDetails[] cardDetails = IngredientDetails.values();
        this.category = cardDetails[whichIngredient].category;
        this.tradeCost = cardDetails[whichIngredient].tradeCost;
        this.name = cardDetails[whichIngredient].name;
        this.effectedCards = cardDetails[whichIngredient].listOfCards;
        this.cardAbility = cardDetails[whichIngredient].ability;
    }

    public boolean canSubstituteFor(Ingredient ingredient)
    {
        if (effectedCards.contains(ingredient))
            return true;
        return false;
    }

    public boolean cannotPairWith(List<Ingredient> ingredients)
    {
        for (int i = 0; i < ingredients.size(); i++)
        {
            if (effectedCards.contains(ingredients.get(i)))
                return true;
        }
        return false;
    }

    public boolean canPairWith(List<Ingredient> ingredients)
    {
        for (int i = 0; i < ingredients.size(); i++)
        {
            if (effectedCards.contains(ingredients.get(i)))
                return true;
        }
        return false;
    }

    public boolean canDouble(List<Ingredient> recipe)
    {
        for (int i = 0; i < recipe.size(); i++)
        {
            for (int j = i + 1; j < recipe.size(); j++)
            {
                if (recipe.get(i).equals(recipe.get(j)))
                    if (recipe.get(i).equals(this))
                        return true;
            }
        }
        return false;
    }

    public boolean canUpgrade(Ingredient ingredient)
    {
        if (effectedCards.contains(ingredient))
            return true;
        return false;
    }

    public void canRevive(Ingredient ingredient)
    {
        return;
    }

///*
//    void setCategory(int whichIngredient)
//    {
//        if (whichIngredient < 4)
//            category = "Oil";
//        else if (whichIngredient < 14)
//            category = "Dairy";
//        else if (whichIngredient < 24)
//            category = "Meat";
//        else if (whichIngredient < 43)
//            category = "Grain";
//        else if (whichIngredient < 59)
//            category = "Fruit";
//        else if (whichIngredient < 80)
//            category = "Vegetable";
//    }
//
//    void setTradeCost(int whichIngredient)
//    {
//        if (whichIngredient < 4)
//            tradeCost = 3;
//        else if (whichIngredient < 24)
//            tradeCost = 2;
//        else if (whichIngredient < 80)
//            tradeCost = 1;
//    }
//
//    void setName(int whichIngredient)
//    {
//        switch (whichIngredient)
//        {
//            case 0:
//                name = "Truffle Oil";
//            case 1:
//            case 2:
//            case 3:
//            case 4:
//            case 5:
//            case 6:
//            case 7:
//            case 8:
//            case 9:
//            case 10:
//            case 11:
//            case 12:
//            case 13:
//            case 14:
//            case 15:
//            case 16:
//            case 17:
//            case 18:
//            case 19:
//            case 20:
//            case 21:
//            case 22:
//            case 23:
//            case 24:
//            case 25:
//            case 26:
//            case 27:
//            case 28:
//            case 29:
//            case 30:
//            case 31:
//            case 32:
//            case 33:
//            case 34:
//            case 35:
//            case 36:
//            case 37:
//            case 38:
//            case 39:
//            case 40:
//            case 41:
//            case 42:
//            case 43:
//            case 44:
//            case 45:
//            case 46:
//            case 47:
//            case 48:
//            case 49:
//            case 50:
//            case 51:
//            case 52:
//            case 53:
//            case 54:
//            case 55:
//            case 56:
//            case 57:
//            case 58:
//            case 59:
//            case 60:
//            case 61:
//            case 62:
//            case 63:
//            case 64:
//            case 65:
//            case 66:
//            case 67:
//            case 68:
//            case 69:
//            case 70:
//            case 71:
//            case 72:
//            case 73:
//            case 74:
//            case 75:
//            case 76:
//            case 77:
//            case 78:
//            case 79:
//        }
//    }
//*/
}