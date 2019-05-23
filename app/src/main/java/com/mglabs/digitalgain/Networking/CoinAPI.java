package com.mglabs.digitalgain.Networking;

import com.mglabs.digitalgain.model.CoinResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class CoinAPI {

    public static final String API_KEY = "";
    public static final String API_BASE_URL = "https://min-api.cryptocompare.com/data/pricemulti?";

    // Retrofit Interface
    public interface CoinService {
        @GET("fsyms=" + "&tsyms=USD")
        Call<CoinResponse> getCoins (@Query("fsyms") String fsyms);
    }
}
