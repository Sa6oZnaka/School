package org.elsys.cardgame.api;

import org.elsys.cardgame.Operations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameImplement implements Game {

    private Deck myDeck;
    private Hand myHand;

    private List<Operation> MyOperations = new ArrayList<>();

    public GameImplement(Deck deck) {
        this.myDeck = deck;

        addOperation(new Size(deck));
        addOperation(new BottomCard(deck));
        addOperation(new TopCard(deck));
        addOperation(new DrawBottomCard(deck));
        addOperation(new DrawTopCard(deck));
        addOperation(new DealOperation(this, deck));
        addOperation(new Sort(deck));
        addOperation(new Shuffle(deck));
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
        boolean executed = false;
        for(Operation i : MyOperations) {
            if(i.getName().equals(command)) {
                i.execute();
                executed = true;
            }
        }
        if(! executed){
            System.out.println("Error: Command not found");
        }
    }

    @Override
    public void addOperation(Operation operation) {
        MyOperations.add(operation);
    }
    
}
