package com.example.demo.demo.lld.pen;

public abstract class pen {
    private String name;
    private String company;
    private int price;
    private PenType type;
    //
    abstract void write();
    abstract String getColour();

    pen(PenType type){
        this.type = type;
    }
}
