package org.example.vessels;

import org.example.model.Vessel;

public class Bergen extends Vessel {

    private String name = "Bergen";
    private int length = 87000;
    private int width = 13500 ;
    private int height = 4970;
    public Bergen( ) {
        super.setName(name);
        super.setLength(length);
        super.setWidth(width);
        super.setHeight(height);
    }
}