package org.example.handlers;

import org.example.annotation.EventHandler;

@EventHandler
public class ProtectionSale {
    private static final String HELM = "Miracle";
    public String getProtection(){
        return "Hero buy " + HELM;
    }

    @Override
    public String toString() {
        return getProtection();
    }
}
