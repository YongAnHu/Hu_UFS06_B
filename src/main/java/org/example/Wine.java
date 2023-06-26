package org.example;

public class Wine {
    private int id;
    private String name;
    private double price;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.isBlank() ? "default name" : name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price > 0 ? price : 0;
    }

    public String getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type ? "white" : "red";
    }

    public Wine(int id, String name, double price, boolean type) {
        setId(id);
        setName(name);
        setPrice(price);
        setType(type);
    }
}
