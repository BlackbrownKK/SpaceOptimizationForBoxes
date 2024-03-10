package org.example.model;

public class Item {
    private String name;
    private int itemId;
    private int quantity;
    private int length;
    private int width;
    private int height;
    private double weight;

    private int coordinateX;
    private int coordinateY;


    public Item(String name, int itemId, int quantity, int length, int width, int height, double weight) {
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

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public String toString() {
        return "Id " + itemId;
    }
}

