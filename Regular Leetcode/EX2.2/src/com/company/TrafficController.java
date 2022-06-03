package com.company;

public class TrafficController {

    private volatile int blue = 0, red = 0;

    //red
    public void enterLeft() {
        //Red entering from left-hand side
        while (blue > 0) {
            //wait
        }
        red++;
    }

    public void leaveRight() {
        //Red leaving tunnel at right-hand side
        red--;
    }

    //blue
    public void enterRight() {
        //Blue entering from right-hand side
        while (red > 0) {
            //wait
        }
        blue++;
    }

    public void leaveLeft() {
        //Blue leaving tunnel at left-hand side
        blue--;
    }



}