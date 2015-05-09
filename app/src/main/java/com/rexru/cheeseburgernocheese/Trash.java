package com.rexru.cheeseburgernocheese;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Rexru101 on 5/2/2015.
 */
public class Trash
{
    List<Ingredient> trash;

    public void addToTrash(Ingredient ingredient)
    {
        trash = new ArrayList<>();
        trash.add(ingredient);
    }
}
