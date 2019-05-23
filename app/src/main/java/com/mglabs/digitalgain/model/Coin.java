package com.mglabs.digitalgain.model;

public class Coin {

    private String name;
    //TODO change to int
    private String price;
    //state of the item for accordion on mainActivity
    private boolean expanded;

    public Coin(String name, String price) {
        this.name = name;
        this.price = price;
    }

    //Empty constructor
    public Coin() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
