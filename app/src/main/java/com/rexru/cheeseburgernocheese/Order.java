package com.rexru.cheeseburgernocheese;

import android.widget.ImageView;

import java.util.List;

/*
 * Created by Rexru on 4/15/2015.
 */
public class Order
{
    int starValue;
    OrderAbility orderAbility;
    //OrderDetails orderDetails;
    List<Object> recipe;
    String name;
    ImageView imageView;

    Order(OrderDetails orderDetails)
    {
        this.starValue = orderDetails.starValue;
        this.name = orderDetails.name;
        this.orderAbility = orderDetails.orderAbility;
        this.recipe = orderDetails.recipe;
        this.imageView = orderDetails.getImageView();
    }
}