package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Table t = new Table();
        t.initTable();
        t.startRound();
        t.playRound();
        t.decideWinners();


    }
}
