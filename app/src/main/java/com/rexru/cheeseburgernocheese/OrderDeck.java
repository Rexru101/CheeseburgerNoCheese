package com.rexru.cheeseburgernocheese;

import java.util.Collections;
import java.util.List;

/*
 * Created by Rexru101 on 5/2/2015.
 */
public class OrderDeck
{
    List<Order> orderDeck;

    OrderDeck()
    {
        orderDeck.add(new Order(OrderDetails.SMOOTHIE));
        orderDeck.add(new Order(OrderDetails.VEGGIE_PILAF));
        orderDeck.add(new Order(OrderDetails.GUACAMOLE));
        orderDeck.add(new Order(OrderDetails.PASTA_WITH_SAUCE));
        orderDeck.add(new Order(OrderDetails.FRUIT_SALAD));
        orderDeck.add(new Order(OrderDetails.VEGGIE_KEBAB));
        orderDeck.add(new Order(OrderDetails.WILD_RICE));
        orderDeck.add(new Order(OrderDetails.VEGGIE_ROLL));
        orderDeck.add(new Order(OrderDetails.OATMEAL_WITH_FRUIT));
        orderDeck.add(new Order(OrderDetails.SALSA_AND_CHIPS));
        orderDeck.add(new Order(OrderDetails.STEAK_AND_MASH));
        orderDeck.add(new Order(OrderDetails.VEGGIE_FRIED_RICE));
        orderDeck.add(new Order(OrderDetails.LETTUCE_WRAP));
        orderDeck.add(new Order(OrderDetails.CHICKEN_STIR_FRY));
        orderDeck.add(new Order(OrderDetails.RICE_PUDDING));
        orderDeck.add(new Order(OrderDetails.CREAMY_SPINACH_PASTA));
        orderDeck.add(new Order(OrderDetails.CAESAR_SALAD));
        orderDeck.add(new Order(OrderDetails.CARROT_CAKE));
        orderDeck.add(new Order(OrderDetails.OMELETTE));
        orderDeck.add(new Order(OrderDetails.RICE_KRISPIE_TREAT));
        orderDeck.add(new Order(OrderDetails.SPAGHETTI_AND_MEATBALLS));
        Collections.shuffle(orderDeck);
    }

    public Order draw()
    {
        return orderDeck.remove(0);
    }
}
