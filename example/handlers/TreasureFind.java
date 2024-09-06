package org.example.handlers;

import org.example.annotation.EventHandler;

@EventHandler
public class TreasureFind {
    private static final String DIAMOND = "Cullinan";
    public String findTreasure(){
        return DIAMOND+"!";
    }

    @Override
    public String toString() {
        return "TreasureFind = " + findTreasure();
    }
}
