package com.rexru.cheeseburgernocheese;

/*
 * Created by Rexru101 on 4/27/2015.
 */
public enum CardDetails
{
    //oils
    TRUFFLE_OIL (3, "oil", "substitute", "truffleOil"),
    BUTTER (3, "oil", "substitute", "butter"),
    OLIVE_OIL (3, "oil", "substitute", "oliveOil"),
    GRAPESEED_OIL (3, "oil", "substitute", "grapeseedOil"),
    //dairies
    CHEESE (2, "dairy", "none", "cheese"),
    EGGS (2, "dairy", "substitute", "eggs"),
    MILK (2, "dairy", "separate", "milk"),
    //meats
    BACON (2, "meat", "substitute", "bacon"),
    GRILLED_CHICKEN (2, "meat", "pair", "grilledChicken"),//broccoli pairs with chicken
    STEAK (2, "meat", "none", "steak"),
    TOFURKY (2, "meat", "substitute", "tofurky"),
    //grains
    CORN (1, "grain", "substitute", "corn"),
    LENTILS (1, "grain", "substitute", "lentils"),
    OATS (1, "grain", "substitute", "oats"),
    PASTA (1, "grain", "substitute", "pasta"),
    QUINOA (1, "grain", "substitute", "quinoa"),
    RICE (1, "grain", "none", "rice"),
    WHOLE_WHEAT_PASTA (1, "grain", "substitute", "wholeWheatPasta"),
    //fruits
    ORANGE (1, "fruit", "substitute", "orange"),
    POMEGRANATE (1, "fruit", "revival", "pomegranate"),
    STRAWBERRY (1, "fruit", "double", "strawberry"),
    TOMATO (1, "fruit", "substitute", "tomato"),
    APPLE (1, "fruit", "none", "apple"),
    AVOCADO (1, "fruit", "substitute", "avocado"),
    BANANA (1, "fruit", "double", "banana"),
    BLUEBERRY (1, "fruit", "double", "blueberry"),
    GRAPES (1, "fruit", "double", "grapes"),
    LEMON (1, "fruit", "substitute", "lemon"),
    LIME (1, "fruit", "substitute", "lime"),
    //vegetables
    ASPARGUS (1, "vegetable", "double","aspargus"),
    BROCCOLI (1, "vegetable", "pair","broccoli"),
    CARROTS (1, "vegetable", "double","carrots"),
    LETTUCE (1, "vegetable", "none","lettuce"),
    MUSHROOM (1, "vegetable", "upgrade","mushroom"),
    SPINACH (1, "vegetable", "pair","spinach"),
    VEGGIE_PATTY (1, "vegetable", "substitute","veggiPatty");

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
