package com.rexru.cheeseburgernocheese;

import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;

import java.util.ArrayList;
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
    int drawableResource;

    Order(OrderDetails orderDetails)
    {
        starValue = orderDetails.starValue;
        name = orderDetails.name;
        orderAbility = orderDetails.orderAbility;
        recipe = new ArrayList<>();
        recipe = orderDetails.recipe;
        drawableResource = orderDetails.getDrawableResource();
        //imageView.getLayoutParams().height = 10;
        //imageView.requestLayout();
    }

    public void setImageView(ImageView imageV)
    {
        imageView = imageV;
    }

    public int getDrawableResource()
    {
        return drawableResource;
    }
//    Order(OrderDetails orderDetails)
//    {
//        this.starValue = orderDetails.starValue;
//        this.name = orderDetails.name;
//        this.orderAbility = orderDetails.orderAbility;
//        recipe = new ArrayList<>();
//        this.recipe = orderDetails.recipe;
//        this.imageView = orderDetails.getImageView();
//    }
}