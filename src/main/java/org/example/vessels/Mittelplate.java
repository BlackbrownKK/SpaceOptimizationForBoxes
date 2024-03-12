package org.example.vessels;

import org.example.model.Vessel;

public class Mittelplate extends Vessel {

    private String name = "Mittelplate";
    private int length = 59230;
    private int width = 10200 ;
    private int height = 3980;
    public Mittelplate() {
        super.setName(name);
        super.setLength(length);
        super.setWidth(width);
        super.setHeight(height);
    }
}
