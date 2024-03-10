package org.example.controller;

import org.example.model.Item;
import org.example.model.Vessel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class PlannerController {

    private ArrayList<Item> cargoCollectionInput;
    private ArrayList<Item> cargoCollectionTemp;
    private ArrayList<Item> cargoCollectionResult;
    private Vessel currentVessel;
    private int gapX;
    private int gapY;

    private int tempX;
    private int tempY;

    int tempMaxLength = 0;


    public PlannerController(ArrayList<Item> cargoCollection, Vessel currentVessel, int gapX, int gapY) {
        this.cargoCollectionInput = cargoCollection;
        this.currentVessel = currentVessel;
        this.gapX = gapX;
        this.gapY = gapY;
    }


    public ArrayList<Item> planer() {
        initialize();
        while (!cargoCollectionTemp.isEmpty() &&
                (currentVessel.getLength() - tempX) > cargoCollectionTemp.getFirst().getLength()) {
            buildNextRowOfCargo();
            removeItemsThatWasUsed();
            tempX += tempMaxLength + gapX;
        }
        planRemainUnits();

        return cargoCollectionResult;
    }

    private void planRemainUnits() {

        int startX = 0;
        int startY = currentVessel.getWidth()+2000;

        for (Item item : cargoCollectionTemp) {
            item.setCoordinateX(startX);
            item.setCoordinateY(startY);
            cargoCollectionResult.add(item);
            startX += item.getLength() + gapX;
            if (startX + item.getLength() > currentVessel.getLength()) {
                startY += 2000;
                startX = 0;
            }

        }
    }

    private void removeItemsThatWasUsed() {
        Iterator<Item> iterator = cargoCollectionTemp.iterator();
        while (iterator.hasNext()) {
            Item tempItem = iterator.next();
            for (Item resultItem : cargoCollectionResult) {
                if (tempItem.getItemId() == resultItem.getItemId()) {
                    iterator.remove();
                    break; // Exit the inner loop since the item has been found and removed
                }
            }
        }
    }

    private void initialize() {
        cargoCollectionTemp = sortCollection();
        cargoCollectionResult = new ArrayList<>();
    }

    private void buildNextRowOfCargo() {
        int tempWidth = 0;
        int localMaxLength = 0;
        tempY = 0;
        for (Item item : cargoCollectionTemp) {
            if (tempWidth > currentVessel.getWidth()) break;
            if (item.getWidth() + gapY * 2 > currentVessel.getWidth() - tempWidth) break;

            if (item.getLength() + gapX * 2 > currentVessel.getLength() - tempX) break;

            if (item.getLength() > localMaxLength) localMaxLength = item.getLength();
            item.setCoordinateX(tempX + gapX);
            item.setCoordinateY(tempY + gapY);
            tempY = item.getCoordinateY() + item.getWidth();
            tempWidth = item.getCoordinateY() + item.getWidth();
            cargoCollectionResult.add(item);
        }
        tempMaxLength = localMaxLength;
    }


    private ArrayList<Item> sortCollection() {
        ArrayList<Item> temp = new ArrayList<>();
        for (Item item : cargoCollectionInput) {
            if (item.getHeight() <= currentVessel.getHeight() - 150) {
                temp.add(item);
            }
        }
        Collections.sort(temp, Comparator.comparingDouble(Item::getWidth));
        return temp;
    }
}



