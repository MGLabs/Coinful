package com.mglabs.digitalgain;

import android.content.Context;

import com.mglabs.digitalgain.model.Coin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Static list of coins for other parts of the app to access (i.e detailed pages)
 */
public class CoinStore {

    private static List<Coin> coinList = new ArrayList<>();
    private final Context mContext;


    //Constructor
    public CoinStore(Context context) {
        this.mContext = context;
    }

    public static List<Coin> getCoinList() {
        return coinList;
    }

    public static void setCoinList(List<Coin> coinList) {
        CoinStore.coinList = coinList;
    }

    /**
     * Method to initialize the set of data from resources
     */
    public static void initializeData() {
        coinList = Arrays.asList(
                new Coin("BTC", "$2,364.04"),
                new Coin("ETH", "$301.04"),
                new Coin("IOT", "$0.68"));

        CoinStore.setCoinList(coinList);
    }


}
