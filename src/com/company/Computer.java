package com.company;

/**
 * Created by falyanguzov on 09.11.2016.
 */
public class Computer extends Player {
    static String[] names = {"Coward", "Stupid", "Stager"};

    public Computer(Intellect intellect) {
        super(intellect, names[(int)(Math.random()*names.length)]);
    }
}
