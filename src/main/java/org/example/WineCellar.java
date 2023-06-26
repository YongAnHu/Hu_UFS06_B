package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class WineCellar {
    private static WineCellar INSTANCE;
    private List<Wine> wineList = new ArrayList<>();
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private WineCellar() {
        // IF type is true -> type = white
        // IF type is false -> type = red
        wineList.add(new Wine(2, "Pignoli Radikon Radikon 2009", 133,  false));
        wineList.add(new Wine(1, "Dom Perignon Vintage Moet and Chandon 2008", 225.94, true));
        wineList.add(new Wine(3, "Pinot Nero Elena Walch Elena Walch 2018", 43, false));
        wineList.add(new Wine(4, "Penfolds Yattarna Chardonnay 2015", 199.65, true));
        wineList.add(new Wine(5, "Conterno Giacomo Barbera D alba Doc Vigna Francia 2019", 71.10, false));
    }

    public static WineCellar getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WineCellar();
        }

        return INSTANCE;
    }

    public String getWine(String type) {
        ArrayList<Wine> save = new ArrayList<>();

        for (Wine wine: wineList) {
            if (wine.getType().equalsIgnoreCase(type)) {
                save.add(wine);
            }
        }

        String res = gson.toJson(save);
        return res;
    }

    public String getSortedName() {
        List<Wine> listCopy = new ArrayList<>();
        listCopy.addAll(wineList);

        listCopy.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });

        return gson.toJson(listCopy);
    }

    public String getSortedPrice() {
        List<Wine> listCopy = new ArrayList<>();
        listCopy.addAll(wineList);

        listCopy.sort((o1, o2) -> {
            if (o1.getPrice()>o2.getPrice())
                return -1;
            if (o1.getPrice()<o2.getPrice())
                return 1;
            return 0;
        });

        String res = gson.toJson(listCopy);
        return res;
    }
}
