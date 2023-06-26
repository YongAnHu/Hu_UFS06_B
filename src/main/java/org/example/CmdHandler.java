package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class CmdHandler {
    private static CmdHandler INSTANCE;
    private List<String> cmdList = new ArrayList<>();

    private CmdHandler() {
        cmdList.add("red");
        cmdList.add("white");
        cmdList.add("sorted_by_name");
        cmdList.add("sorted_by_price");
        cmdList.add("help");
    }

    public static CmdHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CmdHandler();
        }

        return INSTANCE;
    }

    public String getCmd() {
        Gson gson = new Gson();
        String res = gson.toJson(cmdList);

        return res;
    }

    public String getAction(String inCmd) {
        String output = "";

        switch (inCmd) {
            case "red":
                output = WineCellar.getInstance().getWine("red");
                break;

            case "white":
                output = WineCellar.getInstance().getWine("white");
                break;

            case "sorted_by_name":
                output = WineCellar.getInstance().getSortedName();
                break;

            case "sorted_by_price":
                output = WineCellar.getInstance().getSortedPrice();
                break;

            case "help":
                output = getCmd();
                break;

            default:
                output = "Command not found!";
                break;
        }

        return output;
    }
}
