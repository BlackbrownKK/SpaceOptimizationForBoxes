package org.example.model;

public class Item {
    private String name;
    private int itemId;
    private int quantity;
    private double length;
    private double width;
    private double height;
    private double weight;


    public Item(String name, int itemId, int quantity, double length, double width, double height, double weight) {
        this.name = name;
        this.itemId = itemId;
        this.quantity = quantity;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
}

