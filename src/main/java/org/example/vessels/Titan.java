package org.example.vessels;

import org.example.model.Vessel;

public class Titan extends Vessel {

    private String name = "Titan";
    private int length = 97330;
    private int width = 14300 ;
    private int height = 5110;
    public Titan( ) {
        super.setName(name);
        super.setLength(length);
        super.setWidth(width);
        super.setHeight(height);
    }
}
