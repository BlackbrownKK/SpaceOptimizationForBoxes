package org.example.vessels;

import org.example.model.Vessel;

public class Anna extends Vessel {

    private String name = "Anna";
    private int length = 92000;
    private int width = 11700 ;
    private int height = 4550;
    public Anna( ) {
        super.setName(name);
        super.setLength(length);
        super.setWidth(width);
        super.setHeight(height);
    }
}