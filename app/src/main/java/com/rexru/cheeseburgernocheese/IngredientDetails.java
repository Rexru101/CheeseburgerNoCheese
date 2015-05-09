package com.rexru.cheeseburgernocheese;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Rexru101 on 4/27/2015.
 */
public enum IngredientDetails
{
    //oils < 0
//    TRUFFLE_OIL (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients, "truffleOil"),//1
//    BUTTER (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients, "butter"),//1
//    OLIVE_OIL (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients, "oliveOil"),//1
//    GRAPESEED_OIL (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients, "grapeseedOil"),//1
//    //dairies < 4
//    CHEESE (2, IngredientCategory.DAIRY, IngredientAbility.NONE, Game.listOfOrderedIngredients.subList(4,5), "cheese"),//2
//    EGGS (2, IngredientCategory.DAIRY, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(7,11), "eggs"),//6
//    MILK (2, IngredientCategory.DAIRY, IngredientAbility.SEPARATE, Game.listOfOrderedIngredients.subList(7,11), "milk"),//2
//    //meats < 7
//    BACON (2, IngredientCategory.MEAT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients, "bacon"),//1
//    CHICKEN (2, IngredientCategory.MEAT, IngredientAbility.PAIR, Game.listOfOrderedIngredients.subList(30,31), "chicken"),//4 //grilled chicken is called chicken
//    STEAK (2, IngredientCategory.MEAT, IngredientAbility.NONE, Game.listOfOrderedIngredients.subList(9,10), "steak"),//4
//    TOFURKY (2, IngredientCategory.MEAT, IngredientAbility.SUBSTITUTE, Game.otherListOfOrderedIngredients.subList(0,15), "tofurky"),//1 //other list
//    //grains < 11
//    CORN (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(29,36), "corn"),//1
//    LENTILS (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.otherListOfOrderedIngredients.subList(15,26), "lentils"),//1 //other list
//    OATS (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(16,17), "oats"),//1
//    PASTA (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(17,18), "pasta"),//3
//    QUINOA (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.otherListOfOrderedIngredients.subList(26,31), "quinoa"),//1 //other list
//    RICE (1, IngredientCategory.GRAIN, IngredientAbility.NONE, Game.listOfOrderedIngredients.subList(16,17), "rice"),//9
//    WHOLE_WHEAT_PASTA (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(14,15), "wholeWheatPasta"),//3
//    //fruits < 18
//    ORANGE (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(27,29), "orange"),//1
//    POMEGRANATE (1, IngredientCategory.FRUIT, IngredientAbility.REVIVAL, Game.listOfOrderedIngredients, "pomegranate"),//1
//    STRAWBERRY (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(20,21), "strawberry"),//1
//    TOMATO (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(29,36), "tomato"),//4
//    APPLE (1, IngredientCategory.FRUIT, IngredientAbility.NONE, Game.listOfOrderedIngredients.subList(22,23), "apple"),//3
//    AVOCADO (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients, "avocado"),//1
//    BANANA (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(24,25), "banana"),//1
//    BLUEBERRY (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(25,26), "blueberry"),//1
//    GRAPES (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(26,27), "grapes"),//1
//    LEMON (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(28,29), "lemon"),//1
//    LIME (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(27,28), "lime"),//1
//    //vegetables < 29
//    ASPARAGUS (1, IngredientCategory.VEGETABLE, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(29,30), "asparagus"),//1 //asparagus misspelled
//    BROCCOLI (1, IngredientCategory.VEGETABLE, IngredientAbility.PAIR, Game.listOfOrderedIngredients.subList(8,9), "broccoli"),//2
//    CARROTS (1, IngredientCategory.VEGETABLE, IngredientAbility.DOUBLE, Game.listOfOrderedIngredients.subList(31,32), "carrots"),//3
//    LETTUCE (1, IngredientCategory.VEGETABLE, IngredientAbility.NONE, Game.listOfOrderedIngredients.subList(32,33), "lettuce"),//5
//    MUSHROOM (1, IngredientCategory.VEGETABLE, IngredientAbility.UPGRADE, Game.listOfOrderedIngredients.subList(0,1), "mushroom"),//4
//    SPINACH (1, IngredientCategory.VEGETABLE, IngredientAbility.PAIR, Game.listOfOrderedIngredients.subList(4,7), "spinach"),//4
//    VEGGIE_PATTY (1, IngredientCategory.VEGETABLE, IngredientAbility.SUBSTITUTE, Game.listOfOrderedIngredients.subList(7,11), "veggiePatty");//2
// < 36
    //oils < 0
    TRUFFLE_OIL (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, "truffleOil"),//1
    BUTTER (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, "butter"),//1
    OLIVE_OIL (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, "oliveOil"),//1
    GRAPESEED_OIL (3, IngredientCategory.OIL, IngredientAbility.SUBSTITUTE, "grapeseedOil"),//1
    //dairies < 4
    CHEESE (2, IngredientCategory.DAIRY, IngredientAbility.NONE, "cheese"),//2
    EGGS (2, IngredientCategory.DAIRY, IngredientAbility.SUBSTITUTE, "eggs"),//6
    MILK (2, IngredientCategory.DAIRY, IngredientAbility.SEPARATE, "milk"),//2
    //meats < 7
    BACON (2, IngredientCategory.MEAT, IngredientAbility.SUBSTITUTE, "bacon"),//1
    CHICKEN (2, IngredientCategory.MEAT, IngredientAbility.PAIR, "chicken"),//4 //grilled chicken is called chicken
    STEAK (2, IngredientCategory.MEAT, IngredientAbility.NONE, "steak"),//4
    TOFURKY (2, IngredientCategory.MEAT, IngredientAbility.SUBSTITUTE, "tofurky"),//1 //other list
    //grains < 11
    CORN (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, "corn"),//1
    LENTILS (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, "lentils"),//1 //other list
    OATS (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, "oats"),//1
    PASTA (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, "pasta"),//3
    QUINOA (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, "quinoa"),//1 //other list
    RICE (1, IngredientCategory.GRAIN, IngredientAbility.NONE, "rice"),//9
    WHOLE_WHEAT_PASTA (1, IngredientCategory.GRAIN, IngredientAbility.SUBSTITUTE, "wholeWheatPasta"),//3
    //fruits < 18
    ORANGE (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, "orange"),//1
    POMEGRANATE (1, IngredientCategory.FRUIT, IngredientAbility.REVIVAL, "pomegranate"),//1
    STRAWBERRY (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, "strawberry"),//1
    TOMATO (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, "tomato"),//4
    APPLE (1, IngredientCategory.FRUIT, IngredientAbility.NONE, "apple"),//3
    AVOCADO (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, "avocado"),//1
    BANANA (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, "banana"),//1
    BLUEBERRY (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, "blueberry"),//1
    GRAPES (1, IngredientCategory.FRUIT, IngredientAbility.DOUBLE, "grapes"),//1
    LEMON (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, "lemon"),//1
    LIME (1, IngredientCategory.FRUIT, IngredientAbility.SUBSTITUTE, "lime"),//1
    //vegetables < 29
    ASPARAGUS (1, IngredientCategory.VEGETABLE, IngredientAbility.DOUBLE, "asparagus"),//1 //asparagus misspelled
    BROCCOLI (1, IngredientCategory.VEGETABLE, IngredientAbility.PAIR, "broccoli"),//2
    CARROTS (1, IngredientCategory.VEGETABLE, IngredientAbility.DOUBLE, "carrots"),//3
    LETTUCE (1, IngredientCategory.VEGETABLE, IngredientAbility.NONE, "lettuce"),//5
    MUSHROOM (1, IngredientCategory.VEGETABLE, IngredientAbility.UPGRADE, "mushroom"),//4
    SPINACH (1, IngredientCategory.VEGETABLE, IngredientAbility.PAIR, "spinach"),//4
    VEGGIE_PATTY (1, IngredientCategory.VEGETABLE, IngredientAbility.SUBSTITUTE, "veggiePatty");//2
    // < 36

    int tradeCost;
    IngredientCategory category;
    IngredientAbility ability;
    List<Ingredient> listOfCards;
    String name;
    /*ImageView iView;*/

//    IngredientDetails(int tradeCost, IngredientCategory category, IngredientAbility ability, List<Ingredient> list, String name)
//    {
//        this.tradeCost = tradeCost;
//        this.category = category;
//        this.ability = ability;
//        this.name = name;
//    }

    IngredientDetails(int tradeCost, IngredientCategory category, IngredientAbility ability, String name)
    {
        this.tradeCost = tradeCost;
        this.category = category;
        this.ability = ability;
        this.name = name;
    }

    public ImageView getImageView()
    {
        ImageView imageView = new ImageView(MyApplication.getInstance());
        listOfCards = new ArrayList<>();
        listOfCards.add(new Ingredient(IngredientDetails.STRAWBERRY));
        switch (this)
        {
            case TRUFFLE_OIL:
                imageView.setImageResource(R.drawable.oils_truffle);
                listOfCards.addAll(Game.listOfOrderedIngredients);
                break;
            case BUTTER:
                imageView.setImageResource(R.drawable.oil_butter);
                listOfCards.addAll(Game.listOfOrderedIngredients);
                break;
            case OLIVE_OIL:
                imageView.setImageResource(R.drawable.oil_olive);
                listOfCards.addAll(Game.listOfOrderedIngredients);
                break;
            case GRAPESEED_OIL:
                imageView.setImageResource(R.drawable.oils_grapeseed);
                listOfCards.addAll(Game.listOfOrderedIngredients);
                break;
            case CHEESE:
                imageView.setImageResource(R.drawable.dairy_cheese);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(4,5));
                break;
            case EGGS:
                imageView.setImageResource(R.drawable.dairy_eggs);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(7,11));
                break;
            case MILK:
                imageView.setImageResource(R.drawable.dairy_milk);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(7,11));
                break;
            case BACON:
                imageView.setImageResource(R.drawable.meat_bacon);
                listOfCards.addAll(Game.listOfOrderedIngredients);
                break;
            case CHICKEN:
                imageView.setImageResource(R.drawable.meat_chicken);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(30,31));
                break;
            case STEAK:
                imageView.setImageResource(R.drawable.meat_steak);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(9,10));
                break;
            case TOFURKY:
                imageView.setImageResource(R.drawable.meat_tofurky);
                listOfCards.addAll(Game.otherListOfOrderedIngredients.subList(0,14));//grains + vegetables
                break;
            case CORN:
                imageView.setImageResource(R.drawable.grain_corn);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(29,36));
                break;
            case LENTILS:
                imageView.setImageResource(R.drawable.grain_lentils);
                listOfCards.addAll(Game.otherListOfOrderedIngredients.subList(14,25));//meats + vegetables
                break;
            case OATS:
                imageView.setImageResource(R.drawable.grain_oats);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(16,17));
                break;
            case PASTA:
                imageView.setImageResource(R.drawable.grain_pasta);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(17,18));
                break;
            case QUINOA:
                imageView.setImageResource(R.drawable.grain_quinoa);
                listOfCards.addAll(Game.otherListOfOrderedIngredients.subList(25,30));
                break;
            case RICE:
                imageView.setImageResource(R.drawable.grain_rice);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(16,17));
                break;
            case WHOLE_WHEAT_PASTA:
                imageView.setImageResource(R.drawable.grain_whole_wheat);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(14,15));
                break;
            case ORANGE:
                imageView.setImageResource(R.drawable.fruit_orange);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(27,29));
                break;
            case POMEGRANATE:
                imageView.setImageResource(R.drawable.fruit_pomegranite);
                listOfCards.addAll(Game.listOfOrderedIngredients);
                break;
            case STRAWBERRY:
                imageView.setImageResource(R.drawable.fruit_strawberry);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(20,21));
                break;
            case TOMATO:
                imageView.setImageResource(R.drawable.fruit_tomato);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(29,36));
                break;
            case APPLE:
                imageView.setImageResource(R.drawable.fruit_apple);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(22,23));
                break;
            case AVOCADO:
                imageView.setImageResource(R.drawable.fruit_avocado);
                listOfCards.addAll(Game.listOfOrderedIngredients);
                break;
            case BANANA:
                imageView.setImageResource(R.drawable.fruit_banana);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(24,25));
                break;
            case BLUEBERRY:
                imageView.setImageResource(R.drawable.fruit_blueberry);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(25,26));
                break;
            case GRAPES:
                imageView.setImageResource(R.drawable.fruit_grape);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(26,27));
                break;
            case LEMON:
                imageView.setImageResource(R.drawable.fruit_lemon);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(28,29));
                break;
            case LIME:
                imageView.setImageResource(R.drawable.fruit_lime);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(27,28));
                break;
            case ASPARAGUS:
                imageView.setImageResource(R.drawable.veg_asparagus);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(29,30));
                break;
            case BROCCOLI:
                imageView.setImageResource(R.drawable.veg_broccoli);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(8,9));
                break;
            case CARROTS:
                imageView.setImageResource(R.drawable.veg_carrots);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(31,32));
                break;
            case LETTUCE:
                imageView.setImageResource(R.drawable.veg_lettuce);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(32,33));
                break;
            case MUSHROOM:
                imageView.setImageResource(R.drawable.veg_mushroom);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(0,1));
                break;
            case SPINACH:
                imageView.setImageResource(R.drawable.veg_spinach);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(4,7));
                break;
            case VEGGIE_PATTY:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                listOfCards.addAll(Game.listOfOrderedIngredients.subList(7,11));
                break;
            default:
                //System.out.print("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
                //listOfCards.add(new Ingredient(IngredientDetails.STRAWBERRY));
                break;
        }
        return imageView;
    }
}