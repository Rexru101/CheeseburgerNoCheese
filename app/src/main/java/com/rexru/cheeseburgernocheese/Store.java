package com.rexru.cheeseburgernocheese;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Rexru101 on 5/2/2015.
 */
public class Store
{
    List<Ingredient> store;

    Store()
    {
        store = new ArrayList<>();
    }

    public void addToStore(Ingredient ingredient)
    {
        store.add(ingredient);
    }

    public Ingredient removeFromStore()
    {
        return store.remove(0);
    }
}