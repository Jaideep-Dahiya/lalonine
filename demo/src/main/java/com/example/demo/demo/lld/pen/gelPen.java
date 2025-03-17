package com.example.demo.demo.lld.pen;

public class gelPen extends pen implements refill{

    // we know how builder works we cannot return gelpen class but need to return gelPen factory
    // thats why the constructor here is private

    private gelPen(){
        super(PenType.GEL);
    }

    @Override
    void write() {

    }

    @Override
    String getColour() {
        return "";
    }


    public boolean hasRefill() {
        return false;
    }

    @Override
    public Reefill getRefill() {
        return null;
    }

    @Override
    public boolean refillReplaceable() {
        return false;
    }
}
