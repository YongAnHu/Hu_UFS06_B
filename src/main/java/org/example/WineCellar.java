package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class WineCellar {
    private static WineCellar INSTANCE;
    private List<Wine> wineList = new ArrayList<>();

    private WineCellar() {}

    public static WineCellar getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WineCellar();
        }

        return INSTANCE;
    }

    public String toJson() {
        Gson gson = new Gson();
        String s = gson.toJson(wineList);

        return s;
    }
}
