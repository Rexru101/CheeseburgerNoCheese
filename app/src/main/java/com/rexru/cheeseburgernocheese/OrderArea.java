package com.rexru.cheeseburgernocheese;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Rexru101 on 5/2/2015.
 */
public class OrderArea
{
    List<Order> activeOrders;

    OrderArea(OrderDeck orderDeck)
    {
        activeOrders = new ArrayList<>();
        activeOrders.add(orderDeck.draw());
        activeOrders.add(orderDeck.draw());
        activeOrders.add(orderDeck.draw());
    }

    public void getMoreOrders(OrderDeck orderDeck)
    {
        for (; activeOrders.size() < 3;)
        {
            activeOrders.add(orderDeck.draw());
        }
    }
}