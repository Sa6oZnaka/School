package org.elsys.cardgame.api.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;

public class Suffle extends BasicOperation {

    private BasicDeck myDeck;

    Suffle(BasicDeck deck){
        super("shuffle");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        myDeck.shuffle();
    }

}
