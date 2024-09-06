package org.example.handlers;

import org.example.annotation.EventHandler;

@EventHandler
public class PlayerCount {
    private static final byte NUMBER = Byte.MAX_VALUE;
    public String countPlayer(){
        return  ("Players in Play : " + NUMBER );
    }

    @Override
    public String toString() {
        return "Count = " + countPlayer();
    }
}
