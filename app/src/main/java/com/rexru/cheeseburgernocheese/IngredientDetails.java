package com.rexru.cheeseburgernocheese;

import java.util.List;

/*
 * Created by Rexru101 on 4/27/2015.
 */
public enum IngredientDetails
{
    //oils < 0
    TRUFFLE_OIL (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients,"truffleOil"),//1
    BUTTER (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients, "butter"),//1
    OLIVE_OIL (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients, "oliveOil"),//1
    GRAPESEED_OIL (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients, "grapeseedOil"),//1
    //dairies < 4
    CHEESE (2, IngredientCategory.DAIRY, IngredientAbility.NONE, Game.listOfOrderedIngredients.subList(4,4), "cheese"),//2
    EGGS (2, IngredientCategory.DAIRY, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(7,11), "eggs"),//6
    MILK (2, IngredientCategory.DAIRY, IngredientAbility.SEPARATE, Game.listOfOrderedIngredients.subList(7,11), "milk"),//2
    //meats < 7
    BACON (2, IngredientCategory.MEAT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients, "bacon"),//1
    CHICKEN (2, IngredientCategory.MEAT, IngredientAbility.PAIR, Game.listOfOrderedIngredients.subList(30,30), "chicken"),//4 //grilled chicken is called chicken
    STEAK (2, IngredientCategory.MEAT, IngredientAbility.NONE, Game.listOfOrderedIngredients.subList(9,9), "steak"),//4
    TOFURKY (2, IngredientCategory.MEAT, IngredientAbility.SUBSTITUTE, Game.otherListOfOrderedIngredients.subList(0,15), "tofurky"),//1 //other list
    //grains < 11
    CORN (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(29,36), "corn"),//1
    LENTILS (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.otherListOfOrderedIngredients.subList(15,26), "lentils"),//1 //other list
    OATS (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(16,16), "oats"),//1
    PASTA (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(17,17), "pasta"),//3
    QUINOA (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.otherListOfOrderedIngredients.subList(26,31), "quinoa"),//1 //other list
    RICE (1, IngredientCategory.GRAIN, IngredientAbility.NONE, Game.listOfOrderedIngredients.subList(16,16), "rice"),//9
    WHOLE_WHEAT_PASTA (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(14,14), "wholeWheatPasta"),//3
    //fruits < 18
    ORANGE (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(27,29), "orange"),//1
    POMEGRANATE (1, IngredientCategory.FRUIT, IngredientAbility.REVIVAL, Game.listOfOrderedIngredients, "pomegranate"),//1
    STRAWBERRY (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(20,20), "strawberry"),//1
    TOMATO (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(29,36), "tomato"),//4
    APPLE (1, IngredientCategory.FRUIT, IngredientAbility.NONE, Game.listOfOrderedIngredients.subList(22,22), "apple"),//3
    AVOCADO (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients, "avocado"),//1
    BANANA (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(24,24), "banana"),//1
    BLUEBERRY (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(25,25), "blueberry"),//1
    GRAPES (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(26,26), "grapes"),//1
    LEMON (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(28,28), "lemon"),//1
    LIME (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(27,27), "lime"),//1
    //vegetables < 29
    ASPARAGUS (1, IngredientCategory.VEGETABLE, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(29,29), "asparagus"),//1 //asparagus misspelled
    BROCCOLI (1, IngredientCategory.VEGETABLE, IngredientAbility.PAIR, Game.listOfOrderedIngredients.subList(8,8), "broccoli"),//2
    CARROTS (1, IngredientCategory.VEGETABLE, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(31,31), "carrots"),//3
    LETTUCE (1, IngredientCategory.VEGETABLE, IngredientAbility.NONE, Game.listOfOrderedIngredients.subList(32,32), "lettuce"),//5
    MUSHROOM (1, IngredientCategory.VEGETABLE, IngredientAbility.UPGRADE, Game.listOfOrderedIngredients.subList(0,0), "mushroom"),//4
    SPINACH (1, IngredientCategory.VEGETABLE, IngredientAbility.PAIR, Game.listOfOrderedIngredients.subList(4,7), "spinach"),//4
    VEGGIE_PATTY (1, IngredientCategory.VEGETABLE, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(7,11), "veggiePatty");//2
    // < 36

    int tradeCost;
    IngredientCategory category;
    IngredientAbility ability;
    List<Ingredient> listOfCards;
    String name;

    IngredientDetails(int tradeCost, IngredientCategory category, IngredientAbility ability, List<Ingredient> listOfCards, String name)
    {
        this.tradeCost = tradeCost;
        this.category = category;
        this.ability = ability;
        this.listOfCards = listOfCards;
        this.name = name;
    }
}