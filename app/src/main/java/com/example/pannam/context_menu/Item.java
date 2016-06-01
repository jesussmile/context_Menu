package com.example.pannam.context_menu;

/**
 * Created by pannam on 6/1/2016.
 */
public class Item {
    public Item() {
    }

    String name;
    boolean checkbox;

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(String country, boolean status) {
        this.name = country;
        this.checkbox = status;

    }
}
