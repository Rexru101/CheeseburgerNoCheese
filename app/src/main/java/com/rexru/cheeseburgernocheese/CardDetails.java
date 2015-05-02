package com.rexru.cheeseburgernocheese;

/*
 * Created by Rexru101 on 4/27/2015.
 */
public enum CardDetails
{
    //oils < 0
    TRUFFLE_OIL (3, "oil", "substitute", "truffleOil"),//1
    BUTTER (3, "oil", "substitute", "butter"),//1
    OLIVE_OIL (3, "oil", "substitute", "oliveOil"),//1
    GRAPESEED_OIL (3, "oil", "substitute", "grapeseedOil"),//1
    //dairies < 4
    CHEESE (2, "dairy", "none", "cheese"),//2
    EGGS (2, "dairy", "substitute", "eggs"),//6
    MILK (2, "dairy", "separate", "milk"),//2
    //meats < 7
    BACON (2, "meat", "substitute", "bacon"),//1
    CHICKEN (2, "meat", "pair", "chicken"),//4 //grilled chicken is called chicken
    STEAK (2, "meat", "none", "steak"),//4
    TOFURKY (2, "meat", "substitute", "tofurky"),//1
    //grains < 11
    CORN (1, "grain", "substitute", "corn"),//1
    LENTILS (1, "grain", "substitute", "lentils"),//1
    OATS (1, "grain", "substitute", "oats"),//1
    PASTA (1, "grain", "substitute", "pasta"),//3
    QUINOA (1, "grain", "substitute", "quinoa"),//1
    RICE (1, "grain", "none", "rice"),//9
    WHOLE_WHEAT_PASTA (1, "grain", "substitute", "wholeWheatPasta"),//3
    //fruits < 18
    ORANGE (1, "fruit", "substitute", "orange"),//1
    POMEGRANATE (1, "fruit", "revival", "pomegranate"),//1
    STRAWBERRY (1, "fruit", "double", "strawberry"),//1
    TOMATO (1, "fruit", "substitute", "tomato"),//4
    APPLE (1, "fruit", "none", "apple"),//3
    AVOCADO (1, "fruit", "substitute", "avocado"),//1
    BANANA (1, "fruit", "double", "banana"),//1
    BLUEBERRY (1, "fruit", "double", "blueberry"),//1
    GRAPES (1, "fruit", "double", "grapes"),//1
    LEMON (1, "fruit", "substitute", "lemon"),//1
    LIME (1, "fruit", "substitute", "lime"),//1
    //vegetables < 29
    ASPARAGUS (1, "vegetable", "double","asparagus"),//1 //asparagus misspelled
    BROCCOLI (1, "vegetable", "pair","broccoli"),//2
    CARROTS (1, "vegetable", "double","carrots"),//3
    LETTUCE (1, "vegetable", "none","lettuce"),//5
    MUSHROOM (1, "vegetable", "upgrade","mushroom"),//4
    SPINACH (1, "vegetable", "pair","spinach"),//4
    VEGGIE_PATTY (1, "vegetable", "substitute","veggiePatty");//2
    // < 36
    int tradeCost;
    String category;
    String ability;
    String name;

    CardDetails(int tradeCost, String category, String ability, String name)
    {
        this.tradeCost = tradeCost;
        this.category = category;
        this.ability = ability;
        this.name = name;
    }
}