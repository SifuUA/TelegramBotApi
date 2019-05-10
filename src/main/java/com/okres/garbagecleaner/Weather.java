package com.okres.garbagecleaner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Weather {

    //4d627bf370a64e0717f9fe763ceaffd3
    public static String getWeather(String message, Model model) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + message + "&units=metric&appid=4d627bf370a64e0717f9fe763ceaffd3");

        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";

        while (in.hasNext()) {
            result += in.nextLine();
        }

        //get string
        JSONObject object = new JSONObject(result);
        model.setName(object.getString("name"));

        //get object
        JSONObject main = object.getJSONObject("main");
        model.setTemp(main.getDouble("temp"));
        model.setHumidity(main.getDouble("humidity"));

        //get array
        JSONArray jsonArray = object.getJSONArray("weather");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            model.setIcon(jsonObject.getString("icon"));
            model.setMain(jsonObject.getString("main"));
        }

        return String.format("City: %s\nTemperature: %f\nHumidity: %f\nMain: %s\nhttp://openweathermap.org/img/w/%s.png",
                model.getName(), model.getTemp(), model.getHumidity(), model.getMain(), model.getIcon());
    }
}
