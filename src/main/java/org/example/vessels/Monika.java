package org.example.vessels;

import org.example.model.Vessel;

public class Monika extends Vessel {

    private String name = "Monika";
    private int length = 65000;
    private int width = 11600 ;
    private int height = 4160;
    public Monika( ) {
        super.setName(name);
        super.setLength(length);
        super.setWidth(width);
        super.setHeight(height);
    }
}
