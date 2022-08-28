package com.android.desafioandroidsprint2.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GetCovidDataListFromJson implements GetCountryCovidDataListUseCase {

    private final String TAG = "Get Covid Data List";
    private final String filePath = "covid_all.json";

    public List<CountryCovidData> execute(Context appContext) {
        String jsonFileString = JsonReader.jsonToString(appContext, filePath);
        Gson gson = new Gson();
        Type dataType = new TypeToken<List<CountryCovidData>>() { }.getType();
        List<CountryCovidData> data = gson.fromJson(jsonFileString, dataType);
        return  data;
    }
}
