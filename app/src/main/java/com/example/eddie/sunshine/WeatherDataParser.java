package com.example.eddie.sunshine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by eddie on 2014/08/06.
 */
public class WeatherDataParser {


    public static Double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
    throws JSONException {
        JSONObject weather = new JSONObject(weatherJsonStr);
        JSONArray days = weather.getJSONArray("list");
        JSONObject dayInfo = days.getJSONObject(dayIndex);
        JSONObject temperatureInfo = dayInfo.getJSONObject("temp");
        return temperatureInfo.getDouble("max");
    }
}
