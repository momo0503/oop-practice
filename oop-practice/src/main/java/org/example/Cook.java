package org.example;

public class Cook {
    private final int price;
    private final String name;

    public Cook(String name, int price) {
        this.price = price;
        this.name = name;

    }

    public Cook(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();

    }
}
