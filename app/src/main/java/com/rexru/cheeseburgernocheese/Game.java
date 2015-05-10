package com.rexru.cheeseburgernocheese;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.google.android.gms.games.multiplayer.Participant;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Rexru101 on 4/27/2015.
 */
public class Game
{
    static List<Ingredient> listOfOrderedIngredients;
    static List<Ingredient> otherListOfOrderedIngredients;

    IngredientDeck ingredientDeck;
    OrderDeck orderDeck;
    Player p1;
    Player p2;
    Store store;
    Trash trash;
    OrderArea orderArea;
    BitmapFactory.Options options;
    Resources res = MyApplication.getInstance().getResources();
    //Game(Participant participant1, Participant participant2)
    Game(GridLayout gridLayout)
    {
        listOfOrderedIngredients = new ArrayList<>();
        otherListOfOrderedIngredients = new ArrayList<>();
        //p1 = new Player(participant1);
        //p2 = new Player(participant2);
        p1 = new Player();
        p2 = new Player();
        //Ingredient ingredient;

        //creates ingredient deck
        for (IngredientDetails iDetails: IngredientDetails.values())
            listOfOrderedIngredients.add(new Ingredient(iDetails));
        //creates a subset of ingredients 30 elements

        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(11,18));//grains
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(29,36));//vegetables
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(7,11));//meats
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(29,36));//vegetables
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(7,11));//meats
        otherListOfOrderedIngredients.addAll(listOfOrderedIngredients.subList(16,17));//rice

        for (Ingredient ingredientInList: listOfOrderedIngredients)
            ingredientInList.ingredientDetail.createListOfEffectedCards();

        ingredientDeck = new IngredientDeck();

        for (int i = 0; i < 5; i++)
        {
            p1.addHand(ingredientDeck.draw());
            p2.addHand(ingredientDeck.draw());
        }

        store = new Store();
        for (int i = 0; i < 5; i++)
        {
            store.addToStore(ingredientDeck.draw());
        }

        trash = new Trash();
        orderDeck = new OrderDeck();
        orderArea = new OrderArea(orderDeck);

        //15 imageviews + 5 opponent's cards if shown
        options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        setUpBitmap(orderDeck.getDrawableResource(), gridLayout);
        for (Order ordersInOrderArea: orderArea.activeOrders)
            setUpBitmap(ordersInOrderArea.getDrawableResource(), gridLayout);
        setUpBitmap(ingredientDeck.getDrawableResource(), gridLayout);
        for (Ingredient ingredientInStore: store.store)
            setUpBitmap(ingredientInStore.getDrawableResource(), gridLayout);
        for (Ingredient ingredientInHand: p1.hand)
            setUpBitmap(ingredientInHand.getDrawableResource(), gridLayout);
    }

    public void shiftStore()
    {
        trash.addToTrash(store.removeFromStore());
    }

    //taken from android dev website http://developer.android.com/training/displaying-bitmaps/load-bitmap.html#load-bitmap
    public static int calculateInSampleSize(
        BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
    //optimize later. not necessarily needed
    public void setUpBitmap(int imageID, GridLayout gridLayout)
    {
        //Resources res = MyApplication.getInstance().getResources();
        BitmapFactory.decodeResource(res, imageID, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        //String imageType = options.outMimeType;
        calculateInSampleSize(options, imageWidth, imageHeight);
        ImageView imageView = new ImageView(MyApplication.getInstance());
        imageView.setImageBitmap(decodeSampledBitmapFromResource(res, imageID, 200, 200));
        gridLayout.addView(imageView);
    }
}