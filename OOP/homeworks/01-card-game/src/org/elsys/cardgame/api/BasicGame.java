package org.elsys.cardgame.api;

import java.util.ArrayList;
import java.util.List;

public class BasicGame implements Game {

    private Deck myDeck;
    private Hand myHand;

    private List<Operation> MyOperations = new ArrayList<>();

    public BasicGame(Deck deck) {
        this.myDeck = deck;
    }

    @Override
    public Deck getDeck() {
        return myDeck;
    }

    @Override
    public Hand getDealtHand() {
        return myHand;
    }

    @Override
    public void setDealtHand(Hand hand) {
        myHand = hand;
    }

    @Override
    public void process(String command) {
        for(Operation i : MyOperations) {
            if(i.getName().equals(command)) {
                i.execute();
            }
        }
    }

    @Override
    public void addOperation(Operation operation) {
        MyOperations.add(operation);
    }


}
