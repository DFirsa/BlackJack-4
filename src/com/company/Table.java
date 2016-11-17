package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by falyanguzov on 17.11.2016.
 */
public class Table {

    private LinkedList<Player> players;
    private Dealer dealer;

    public void initTable(){
        System.out.print("Enter your name: ");
        String name = HumanIntellect.in.nextLine();
        players = new LinkedList<Player>();
        dealer = new Dealer();

        players.add(new Computer(new LimitIntellect(14)));
        players.add(new Computer(new LimitIntellect(20)));
        players.add(new Human(name));
        players.add(dealer);
    }
    public void startRound(){
        for (Player player : players) {
            dealer.deal(player);
            dealer.deal(player);
        }
    }

    public void playRound(){
        for (Player player : players) {
            Command command;
            do {
                System.out.println(player.name+" " + player.hand.countScore() + ": " + player.hand);
                command = player.decision();
                switch (command) {
                    case HIT:
                        dealer.deal(player);
                        break;
                }
            } while (command != Command.STAND);
        }
    }
    public void decideWinners(){
        for(Player player : players){
            if(player!=dealer){
                if(player.hand.countScore()>21)
                    player.state = PlayerState.LOSS;
                else if(dealer.hand.countScore()>21)
                    player.state = PlayerState.WIN;
                else if(player.hand.countScore()>dealer.hand.countScore())
                    player.state = PlayerState.WIN;
                else
                    player.state = PlayerState.LOSS;
                System.out.println(player.name+" "+player.state+" with "+player.hand);
            }
        }
    }
}
