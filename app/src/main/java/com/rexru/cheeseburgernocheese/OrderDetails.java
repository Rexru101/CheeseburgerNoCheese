package com.rexru.cheeseburgernocheese;

import android.widget.ImageView;

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

    int pointValue;
    OrderAbility orderAbility;
    List<Ingredient> recipe;
    //List<IngredientCategory>
    String name;

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory, IngredientDetails ingredient, String name)
    {
        this.pointValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe.add();
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory1, IngredientCategory ingredientCategory2, String name)
    {
        this.pointValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe.add();
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory, IngredientDetails ingredient1, IngredientDetails ingredient2, String name)
    {
        this.pointValue = pointValue;
        this.orderAbility = orderAbility;
        this.recipe = recipe;
        this.name = name;
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory1, IngredientCategory ingredientCategory2, IngredientDetails ingredient, String name)
    {
        this.pointValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe.add();
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory1, IngredientCategory ingredientCategory2, IngredientCategory ingredientCategory3, IngredientDetails ingredient, String name)
    {
        this.pointValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe.add();
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientCategory ingredientCategory1, IngredientCategory ingredientCategory2, IngredientDetails ingredient1, IngredientDetails ingredient2, String name)
    {
        this.pointValue = pointValue;
        this.orderAbility = orderAbility;
        this.name = name;
        recipe.add();
    }

    OrderDetails(int pointValue, OrderAbility orderAbility, IngredientDetails ingredientDetails)
    {

    }

    public ImageView getImageView()
    {
        ImageView imageView = new ImageView(MyApplication.getInstance());
        switch (this)
        {
            case SMOOTHIE:
                imageView.setImageResource();
                break;
            case VEGGIE_PILAF:
                imageView.setImageResource(R.drawable.);
                break;
            case GUACAMOLE:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case PASTA_WITH_SAUCE:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case FRUIT_SALAD:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case VEGGIE_KEBAB:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case WILD_RICE:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case VEGGIE_ROLL:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case OATMEAL_WITH_FRUIT:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case SALSA_AND_CHIPS:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case STEAK_AND_MASH:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case VEGGIE_FRIED_RICE:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case LETTUCE_WRAP:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case CHICKEN_STIR_FRY:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case RICE_PUDDING:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case CREAMY_SPINACH_PASTA:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case CAESAR_SALAD:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case CARROT_CAKE:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case OMELETTE:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case RICE_KRISPIE_TREAT:
                imageView.setImageResource(R.drawable.veg_veggie_patty);
                break;
            case SPAGHETTI_AND_MEATBALLS:
                imageView.setImageResource(R.dra.veg_veggie_patty);
                break;
        }

        return imageView;
    }
}
