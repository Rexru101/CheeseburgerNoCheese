package com.rexru.cheeseburgernocheese;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
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
    //does not check whether the ingredient selected/effected is from hand or store
    //on completed orders, hand only fills to what was used instead of 5
    static List<Ingredient> listOfOrderedIngredients;
    static List<Ingredient> otherListOfOrderedIngredients;

    IngredientDeck ingredientDeck;
    OrderDeck orderDeck;
    Player p1;
    Player p2;
    List<Player> listOfPlayers;
    Store store;
    Trash trash;
    OrderArea orderArea;
    BitmapFactory.Options options;
    Resources res = MyApplication.getInstance().getResources();
    boolean allowedToTrade = true;
    boolean player1Turn = true;
    //Point[] indicesOfImageViews;
    int indexNumberOfPoints = 0;

    List<ImageView> selectedViews = new ArrayList<>();
    List<ImageView> effectedViews = new ArrayList<>();
    List<ImageView> handView = new ArrayList<>();
    boolean selectEffectedViews = false;

    //Game(Participant participant1, Participant participant2)
    Game(final GridLayout gridLayout)
    {
//        indicesOfImageViews = new Point[15];
//        for (int i = 0; i < 3; i++)
//        {
//            for (int j = 0; j < 6; j++)
//            {
//                if (j == 0 && i != 1)
//                    continue;
//                if (j == 5 && i == 0)
//                    continue;
//                indicesOfImageViews[indexNumberOfPoints] = new Point(i, j);
//                indexNumberOfPoints++;
//            }
//        }
//        indexNumberOfPoints = 0;
        listOfOrderedIngredients = new ArrayList<>();
        otherListOfOrderedIngredients = new ArrayList<>();
        //p1 = new Player(participant1);
        //p2 = new Player(participant2);
        p1 = new Player();
        p2 = new Player();
        listOfPlayers = new ArrayList<>();
        listOfPlayers.add(p1);
        listOfPlayers.add(p2);

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
        int c = 1;
        //setUpBitmap(orderDeck.getDrawableResource(), gridLayout, c, 0);
        setUpBitmap(orderDeck.getDrawableResource(), gridLayout, c, 0, orderDeck);
        for (Order ordersInOrderArea: orderArea.activeOrders)
        {
            c++;
            //setUpBitmap(ordersInOrderArea.getDrawableResource(), gridLayout, c, 0);
            setUpBitmap(ordersInOrderArea.getDrawableResource(), gridLayout, c, 0, ordersInOrderArea);
        }
        c = 0;
        //setUpBitmap(ingredientDeck.getDrawableResource(), gridLayout, c, 1);
        setUpBitmap(ingredientDeck.getDrawableResource(), gridLayout, c, 1, ingredientDeck);
        for (Ingredient ingredientInStore: store.store)
        {
            c++;
            //setUpBitmap(ingredientInStore.getDrawableResource(), gridLayout, c, 1);
            setUpBitmap(ingredientInStore.getDrawableResource(), gridLayout, c, 1, ingredientInStore);
        }
        c = 0;
        for (Ingredient ingredientInHand: p1.hand)
        {
            c++;
            //setUpBitmap(ingredientInHand.getDrawableResource(), gridLayout, c, 2);
            setUpBitmap(ingredientInHand.getDrawableResource(), gridLayout, c, 2, ingredientInHand);
        }

        Button action = new Button(MyApplication.getInstance());
        Button next = new Button(MyApplication.getInstance());
        action.setText("Action");
        next.setText("Next");
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.columnSpec = GridLayout.spec(5);
        layoutParams.rowSpec = GridLayout.spec(0);
        action.setLayoutParams(layoutParams);
        gridLayout.addView(action);
        layoutParams = new GridLayout.LayoutParams();
        layoutParams.columnSpec = GridLayout.spec(6);
        layoutParams.rowSpec = GridLayout.spec(0);
        next.setLayoutParams(layoutParams);
        gridLayout.addView(next);

        action.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (allowedToTrade)//trade
                {
                    if (selectedViews.size() > 0 && effectedViews.size() > 0)
                    {
                        int sumOfTradeCosts = 0;
                        for (ImageView viewInSelectedViews : selectedViews)
                            sumOfTradeCosts += ((Ingredient) viewInSelectedViews.getTag()).tradeCost;
                        if (sumOfTradeCosts == ((Ingredient) effectedViews.get(0).getTag()).tradeCost)
                        {
                            if (selectedViews.size() > 1)//trading multiple for one
                            {
                                //for (int i = 0; i < selectedViews.size(); i++)
                                for (ImageView selectedViewIngredients: selectedViews)
                                {
                                    Ingredient tempIngredient = (Ingredient) selectedViewIngredients.getTag();
                                    selectedViewIngredients.setImageResource(0);
                                    selectedViewIngredients.setTag(null);
                                    trash.addToTrash(tempIngredient);
                                    //listOfPlayers.get(0).hand.set(listOfPlayers.get(0).hand.indexOf(tempIngredient), null);
                                    listOfPlayers.get(0).hand.remove(tempIngredient);
                                }
                                Ingredient tempIngredient = ingredientDeck.draw();
                                store.store.add(tempIngredient);
                                listOfPlayers.get(0).hand.add((Ingredient)effectedViews.get(0).getTag());
                                //listOfPlayers.get(0).hand.indexOf(effectedViews.get(0).getTag());
                                selectedViews.get(0).setTag(listOfPlayers.get(0).hand.get(listOfPlayers.get(0).hand.size() - 1));
                                selectedViews.get(0).setImageBitmap(decodeSampledBitmapFromResource(res, ((Ingredient)effectedViews.get(0).getTag())
                                    .getDrawableResource(), 125, 125));
                                effectedViews.get(0).setTag(tempIngredient);
                                effectedViews.get(0).setImageBitmap(decodeSampledBitmapFromResource(res, tempIngredient.getDrawableResource(), 125, 125));
                                for (ImageView viewInSelectedView: selectedViews)
                                {
                                    viewInSelectedView.setAlpha(1f);
                                }
                                for (ImageView viewInEffectedView: effectedViews)
                                {
                                    viewInEffectedView.clearColorFilter();
                                }
                                effectedViews.clear();
                                selectedViews.clear();
                            }
                            else//trading one for one
                            {
                                Ingredient ingredientFromStore = ((Ingredient) effectedViews.get(0).getTag());
                                Ingredient ingredientFromHand = ((Ingredient) selectedViews.get(0).getTag());
                                effectedViews.get(0).setTag(ingredientFromHand);
                                effectedViews.get(0).setImageBitmap(decodeSampledBitmapFromResource(res, ingredientFromHand.getDrawableResource(), 125, 125));
                                selectedViews.get(0).setTag(ingredientFromStore);
                                selectedViews.get(0).setImageBitmap(decodeSampledBitmapFromResource(res, ingredientFromStore.getDrawableResource(), 125, 125));
                                effectedViews.get(0).setAlpha(1f);
                                selectedViews.get(0).setAlpha(1f);
                                store.store.set(store.store.indexOf(ingredientFromStore), ingredientFromHand);
                                listOfPlayers.get(0).hand.set(listOfPlayers.get(0).hand.indexOf(ingredientFromHand), ingredientFromStore);
                                effectedViews.clear();
                                selectedViews.clear();
                            }
                            allowedToTrade = false;
                            //selectEffectedViews = false;
                        }
                        else//not equal. reset everything
                        {
                            for (ImageView viewInEffectView: effectedViews)
                                viewInEffectView.getDrawable().clearColorFilter();
                            for (ImageView viewInSelectedView: selectedViews)
                                viewInSelectedView.setAlpha(1f);
                            effectedViews.clear();
                            selectedViews.clear();
                            allowedToTrade = true;
                        }
                        selectEffectedViews = false;
                    }
                    else
                    {
                        //selecting effectView
                        selectEffectedViews = true;
                    }
                }
                else//complete order
                {
                    if (selectedViews.size() > 0 && effectedViews.size() > 0)
                    {
                        List<Ingredient> tempIngredList = new ArrayList<>();
                        for (ImageView viewInSelected: selectedViews)
                             tempIngredList.add((Ingredient)viewInSelected.getTag());
                        if (listOfPlayers.get(0).completeOrder(tempIngredList, (Order)effectedViews.get(0).getTag()))
                        {
                            for (Ingredient ingredientGoingToTrash: tempIngredList)
                            {
                                trash.addToTrash(ingredientGoingToTrash);
                                listOfPlayers.get(0).hand.remove(ingredientGoingToTrash);
                                listOfPlayers.get(0).addHand(ingredientDeck.draw());
                                selectedViews.get(0).setTag(listOfPlayers.get(0).hand.get(listOfPlayers.get(0).hand.size() - 1));
                                selectedViews.get(0).setImageBitmap(decodeSampledBitmapFromResource(res, listOfPlayers.get(0).hand.get(listOfPlayers.get(0)
                                    .hand.size() - 1).getDrawableResource(), 125, 125));
                                selectedViews.get(0).setAlpha(1f);
                                selectedViews.remove(0);
                            }
                            orderArea.activeOrders.remove((Order)effectedViews.get(0).getTag());
                            orderArea.getMoreOrders(orderDeck);
                            effectedViews.get(0).setTag(orderArea.activeOrders.get(orderArea.activeOrders.size() - 1));
                            effectedViews.get(0).setImageBitmap(decodeSampledBitmapFromResource(res, orderArea.activeOrders.get(orderArea
                                .activeOrders.size() - 1).getDrawableResource(), 125, 125));

                            //next turn
                            allowedToTrade = true;
                            //for (int i = 0; i < 5; i++)
                            int i = 0;
                            for (ImageView imageViewInHand: handView)
                            {
                                //imageViewInHand.setTag(listOfPlayers.get(1).hand.get(i));
                                //imageViewInHand.setImageBitmap(decodeSampledBitmapFromResource(res, listOfPlayers.get(1).hand.get(i).drawableResource, 125, 125));
                                //ImageView temp = (ImageView) handView;
                                //ImageView temp = (ImageView) gridLayout.findViewWithTag(listOfPlayers.get(0).hand.get(i));
                                if (listOfPlayers.get(1).hand.size() <= i)
                                {
                                    imageViewInHand.setImageBitmap(decodeSampledBitmapFromResource(res, 0, 125, 125));//.setTag(i + 10,);//set null tag
                                }
                                else
                                {
                                    imageViewInHand.setTag(listOfPlayers.get(1).hand.get(i));
                                    imageViewInHand.setImageBitmap(decodeSampledBitmapFromResource(res, listOfPlayers.get(1).hand.get(i).drawableResource, 125, 125));
                                }
                                i++;
                            }
                            player1Turn = !player1Turn;
                            listOfPlayers.add(listOfPlayers.get(0));
                            listOfPlayers.remove(0);
                        }
                        else
                        {
                            for (ImageView viewInSelected: selectedViews)
                                viewInSelected.setAlpha(1f);
                        }
                        System.out.println("CLEAR COLOR FILTER");
                        effectedViews.get(0).getDrawable().clearColorFilter();
                        effectedViews.clear();
                        selectedViews.clear();
                    }
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (allowedToTrade)
                    allowedToTrade = false;
                else
                {
                    for (ImageView viewInEffectView: effectedViews)
                        viewInEffectView.getDrawable().clearColorFilter();
                    for (ImageView viewInSelectedView: selectedViews)
                        viewInSelectedView.setAlpha(1f);
                    effectedViews.clear();
                    selectedViews.clear();

                    allowedToTrade = true;
                    //for (int i = 0; i < 5; i++)
                    int i = 0;
                    for (ImageView imageViewInHand: handView)
                    {
                        //imageViewInHand.setTag(listOfPlayers.get(1).hand.get(i));
                        //imageViewInHand.setImageBitmap(decodeSampledBitmapFromResource(res, listOfPlayers.get(1).hand.get(i).drawableResource, 125, 125));
                        //ImageView temp = (ImageView) handView;
                        //ImageView temp = (ImageView) gridLayout.findViewWithTag(listOfPlayers.get(0).hand.get(i));
                        if (listOfPlayers.get(1).hand.size() <= i)
                        {
                            imageViewInHand.setImageBitmap(decodeSampledBitmapFromResource(res, 0, 125, 125));//.setTag(i + 10,);//set null tag
                        }
                        else
                        {
                            imageViewInHand.setTag(listOfPlayers.get(1).hand.get(i));
                            imageViewInHand.setImageBitmap(decodeSampledBitmapFromResource(res, listOfPlayers.get(1).hand.get(i).drawableResource, 125, 125));
                        }
                        i++;
                    }
                    player1Turn = !player1Turn;
                    listOfPlayers.add(listOfPlayers.get(0));
                    listOfPlayers.remove(0);
                }
            }
        });
        //setUpBitmap(p1.completedOrders.get(p1.completedOrders.size() - 1).drawableResource, gridLayout, 6, 2);
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
    public void setUpBitmap(int imageID, GridLayout gridLayout, int c, int r, Object obj)
    {
        //Resources res = MyApplication.getInstance().getResources();
        BitmapFactory.decodeResource(res, imageID, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        //String imageType = options.outMimeType;
        calculateInSampleSize(options, imageWidth, imageHeight);
        ImageView imageView = new ImageView(MyApplication.getInstance());
        imageView.setImageBitmap(decodeSampledBitmapFromResource(res, imageID, 125, 125));
        GridLayout.LayoutParams param = new GridLayout.LayoutParams();
//        param.height = GridLayout.LayoutParams.WRAP_CONTENT;
//        param.width = GridLayout.LayoutParams.WRAP_CONTENT;
        param.rightMargin = 5;
        param.topMargin = 5;
        param.columnSpec = GridLayout.spec(c);
        param.rowSpec = GridLayout.spec(r);
        imageView.setLayoutParams(param);
        imageView.setTag(obj);
        //imageView.setTag(indexNumberOfPoints, obj);
        if (indexNumberOfPoints > 9)
            handView.add(imageView);
        indexNumberOfPoints++;
        imageView.setOnTouchListener(new Touch());
        gridLayout.addView(imageView);
    }

    public class Touch implements View.OnTouchListener
    {
        @Override
        public boolean onTouch(View v, MotionEvent event)
        {
            ImageView tempView = ((ImageView) v);
            if (v.getTag().getClass().equals(Ingredient.class))//ingredient
            {
                if (!selectEffectedViews)
                {
                    if (!selectedViews.contains(tempView))
                    {
                        tempView.setAlpha(0.25f);
                        selectedViews.add(tempView);
                    }
                    else
                    {
                        tempView.setAlpha(1f);
                        selectedViews.remove(tempView);
                    }
                }
                else
                {
                    if (effectedViews.size() < 1)
                    {
                        tempView.getDrawable().setColorFilter(Color.rgb(64, 128, 64), PorterDuff.Mode.MULTIPLY);
                        effectedViews.add(tempView);
                    }
                    else
                    {
                        effectedViews.get(0).getDrawable().clearColorFilter();
                        effectedViews.clear();
                    }
                }
            }
            else if (v.getTag().getClass().equals(Order.class))//order
            {
                if (!allowedToTrade)
                {
                    if (effectedViews.size() < 1)
                    {
                        tempView.getDrawable().setColorFilter(Color.rgb(128, 64, 64), PorterDuff.Mode.MULTIPLY);
                        effectedViews.add(tempView);
                    }
                    else
                    {
                        effectedViews.get(0).getDrawable().clearColorFilter();
                        effectedViews.clear();
                    }
                }
            }
            else if (v.getTag().getClass().equals(IngredientDeck.class))//ingredientDeck
            {
                System.out.println(((IngredientDeck)v.getTag()).ingredientDeck.size());
            }
            else if (v.getTag().getClass().equals(OrderDeck.class))//orderDeck
            {
                System.out.println(((OrderDeck)v.getTag()).orderDeck.size());
            }
            return false;
        }
    }
}