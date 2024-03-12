package org.example.vessels;

import org.example.model.Vessel;

public class Lagos extends Vessel {

    private String name = "Lagos";
    private int length = 87000;
    private int width = 12800 ;
    private int height = 5340;
    public Lagos( ) {
        super.setName(name);
        super.setLength(length);
        super.setWidth(width);
        super.setHeight(height);
    }
}
