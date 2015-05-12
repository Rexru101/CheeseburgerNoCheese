package com.rexru.cheeseburgernocheese;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Rexru101 on 5/2/2015.
 */
public class Trash
{
    List<Ingredient> trash;
    ImageView imageView;

    Trash()
    {
        imageView = new ImageView(MyApplication.getInstance());
        imageView.setImageResource(0);
    }

    public void addToTrash(Ingredient ingredient)
    {
        trash = new ArrayList<>();
        trash.add(ingredient);
        imageView = ingredient.imageView;
    }
}
