package org.example.vessels;

import org.example.model.Vessel;

public class London extends Vessel {

    private String name = "London";
    private int length = 87000;
    private int width = 12800 ;
    private int height = 5950;
    public London( ) {
        super.setName(name);
        super.setLength(length);
        super.setWidth(width);
        super.setHeight(height);
    }
}
