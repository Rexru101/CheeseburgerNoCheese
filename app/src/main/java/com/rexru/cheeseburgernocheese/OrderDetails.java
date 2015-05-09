package com.rexru.cheeseburgernocheese;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Rexru101 on 5/2/2015.
 */
public enum OrderDetails
{
    SMOOTHIE (2, OrderAbility.TRADE_DOWN, IngredientCategory.FRUIT, IngredientCategory.VEGETABLE, "smoothie"),
    VEGGIE_PILAF (2, OrderAbility.OPPONENT_TRASH_HAND, IngredientCategory.VEGETABLE, IngredientDetails.RICE, "veggiePilaf"),
    //new Ingredient? or IngredientDetails.Rice
    GUACAMOLE (2, OrderAbility.USE_INGREDIENT_FOR_ORDER, IngredientCategory.VEGETABLE, IngredientDetails.AVOCADO, "guacamole"),
    PASTA_WITH_SAUCE (3, OrderAbility.REPLACE_ACTIVE_ORDERS, IngredientCategory.VEGETABLE, IngredientDetails.PASTA, "pastaWithSauce"),
    FRUIT_SALAD (2, OrderAbility.TRASH_HAND, IngredientCategory.FRUIT, IngredientDetails.APPLE, "fruitSalad"),
    VEGGIE_KEBAB (2, OrderAbility.SHUFFLE_PLAYERS_HANDS, IngredientCategory.VEGETABLE, IngredientDetails.MUSHROOM, "veggieKebab"),
    WILD_RICE (2, OrderAbility.USE_INGREDIENT_FOR_ORDER, IngredientCategory.GRAIN, IngredientDetails.RICE, "wildRice"),
    VEGGIE_ROLL (2, OrderAbility.REVIVE_TOP_OF_TRASH, IngredientCategory.VEGETABLE, IngredientDetails.RICE, "veggieRoll"),
    OATMEAL_WITH_FRUIT (2, OrderAbility.TRADE_TWICE, IngredientCategory.FRUIT, IngredientCategory.GRAIN,"oatmealWithFruit"),
    SALSA_AND_CHIPS (3, OrderAbility.TAKE_CARD_FROM_OPPONENT, IngredientCategory.GRAIN, IngredientDetails.LEMON, IngredientDetails.LIME, "salsaAndChips"),
    STEAK_AND_MASH (3, OrderAbility.TWO_TURNS, IngredientCategory.VEGETABLE, IngredientDetails.STEAK, "steakAndMash"),
    VEGGIE_FRIED_RICE (3, OrderAbility.REVIVE, IngredientCategory.VEGETABLE, IngredientCategory.VEGETABLE, IngredientDetails.RICE, "veggieFriedRice"),
    LETTUCE_WRAP (3, OrderAbility.REPLACE_ACTIVE_ORDERS_FAST, IngredientCategory.GRAIN, IngredientCategory.FRUIT, IngredientDetails.LETTUCE, "lettuceWrap"),
    CHICKEN_STIR_FRY (3, OrderAbility.PREVENT_ORDER_ABILITY, IngredientCategory.VEGETABLE, IngredientDetails.CHICKEN, "chickenStirFry"),
    RICE_PUDDING (4, OrderAbility.OPPONENT_TRASH_HAND_FAST, IngredientCategory.FRUIT, IngredientCategory.DAIRY, IngredientDetails.RICE, "ricePudding"),
    CREAMY_SPINACH_PASTA (4, OrderAbility.SWAP_ORDER, IngredientCategory.DAIRY, IngredientDetails.PASTA, IngredientDetails.SPINACH, "creamySpinachPasta"),
    CAESAR_SALAD (4, OrderAbility.TRASH_EVERYTHING_FAST, IngredientCategory.FRUIT, IngredientCategory.MEAT, IngredientDetails.LETTUCE, "caesarSalad"),
    CARROT_CAKE (4, OrderAbility.OPPONENT_TRASH_ORDER, IngredientCategory.GRAIN, IngredientCategory.DAIRY, IngredientDetails.CARROTS, "carrotCake"),
    OMELETTE (5, OrderAbility.NONE, IngredientCategory.VEGETABLE, IngredientCategory.VEGETABLE, IngredientCategory.MEAT, IngredientDetails.EGGS, "omelette"),
    RICE_KRISPIE_TREAT (5, OrderAbility.NONE, IngredientCategory.FRUIT, IngredientCategory.FRUIT, IngredientCategory.DAIRY, IngredientDetails.RICE, "riceKrispieTreat"),
    SPAGHETTI_AND_MEATBALLS (5, OrderAbility.NONE, IngredientCategory.DAIRY, IngredientCategory.MEAT, IngredientDetails.TOMATO, IngredientDetails.PASTA, "spaghettiAndMeatballs");

    int starValue;
    OrderAbility orderAbility;
    List<Object> recipe;
    String name;
    //ImageView imageView;

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory, IngredientDetails ingredient, String name)
    {
        starValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe = new ArrayList<>();
        recipe.add(ingredientCategory);
        recipe.add(ingredient);
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory1, IngredientCategory ingredientCategory2, String name)
    {
        starValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe = new ArrayList<>();
        recipe.add(ingredientCategory1);
        recipe.add(ingredientCategory2);
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory, IngredientDetails ingredient1,
                 IngredientDetails ingredient2, String name)
    {
        starValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe = new ArrayList<>();
        recipe.add(ingredientCategory);
        recipe.add(ingredient1);
        recipe.add(ingredient2);
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory1, IngredientCategory ingredientCategory2,
                 IngredientDetails ingredient, String name)
    {
        starValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe = new ArrayList<>();
        recipe.add(ingredientCategory1);
        recipe.add(ingredientCategory2);
        recipe.add(ingredient);
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory1, IngredientCategory ingredientCategory2,
                 IngredientCategory ingredientCategory3, IngredientDetails ingredient, String name)
    {
        starValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe = new ArrayList<>();
        recipe.add(ingredientCategory1);
        recipe.add(ingredientCategory2);
        recipe.add(ingredientCategory3);
        recipe.add(ingredient);
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory1, IngredientCategory ingredientCategory2,
                 IngredientDetails ingredient1, IngredientDetails ingredient2, String name)
    {
        starValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe = new ArrayList<>();
        recipe.add(ingredientCategory1);
        recipe.add(ingredientCategory2);
        recipe.add(ingredient1);
        recipe.add(ingredient2);
    }

    public ImageView getImageView()
    {
        ImageView imageView = new ImageView(MyApplication.getInstance());
        switch (this)
        {
            case SMOOTHIE:
                imageView.setImageResource(R.drawable.recipe_01_smoothie);
                break;
            case VEGGIE_PILAF:
                imageView.setImageResource(R.drawable.recipe_02_veggie_pilaf);
                break;
            case GUACAMOLE:
                imageView.setImageResource(R.drawable.recipe_03_guac);
                break;
            case PASTA_WITH_SAUCE:
                imageView.setImageResource(R.drawable.recipe_04_pasta_sauce);
                break;
            case FRUIT_SALAD:
                imageView.setImageResource(R.drawable.recipe_05_fruit_salad);
                break;
            case VEGGIE_KEBAB:
                imageView.setImageResource(R.drawable.recipe_06_veggie_kebab);
                break;
            case WILD_RICE:
                imageView.setImageResource(R.drawable.recipe_07_wild_rice);
                break;
            case VEGGIE_ROLL:
                imageView.setImageResource(R.drawable.recipe_08_veggie_roll);
                break;
            case OATMEAL_WITH_FRUIT:
                imageView.setImageResource(R.drawable.recipe_09_oatmeal_fruit);
                break;
            case SALSA_AND_CHIPS:
                imageView.setImageResource(R.drawable.recipe_10_salsa_chips);
                break;
            case STEAK_AND_MASH:
                imageView.setImageResource(R.drawable.recipe_11_steak_mash);
                break;
            case VEGGIE_FRIED_RICE:
                imageView.setImageResource(R.drawable.recipe_12_veggie_fried_rice);
                break;
            case LETTUCE_WRAP:
                imageView.setImageResource(R.drawable.recipe_13_lettuce_wrap);
                break;
            case CHICKEN_STIR_FRY:
                imageView.setImageResource(R.drawable.recipe_14_chicken_stir_fry);
                break;
            case RICE_PUDDING:
                imageView.setImageResource(R.drawable.recipe_15_rice_pudding);
                break;
            case CREAMY_SPINACH_PASTA:
                imageView.setImageResource(R.drawable.recipe_16_creamy_spinach_pasta);
                break;
            case CAESAR_SALAD:
                imageView.setImageResource(R.drawable.recipe_17_cesar_salad);
                break;
            case CARROT_CAKE:
                imageView.setImageResource(R.drawable.recipe_18_carrot_cake);
                break;
            case OMELETTE:
                imageView.setImageResource(R.drawable.recipe_19_omelette);
                break;
            case RICE_KRISPIE_TREAT:
                imageView.setImageResource(R.drawable.recipe_20_rice_krispie);
                break;
            case SPAGHETTI_AND_MEATBALLS:
                imageView.setImageResource(R.drawable.recipe_21_spaghetti);
                break;
        }
        return imageView;
    }
}