package org.example.handlers;

import org.example.annotation.EventHandler;

@EventHandler
public class HeroCall {
    public static  final String NAME = "Wolverine";
    public String callHero(){
        return "Hero, I invoke you : " + NAME;
    }

    @Override
    public String toString() {
        return callHero();
    }
}
