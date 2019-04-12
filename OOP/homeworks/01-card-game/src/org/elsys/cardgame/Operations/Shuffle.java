package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;

public class Shuffle extends BasicOperation {

    private BasicDeck myDeck;

    Shuffle(BasicDeck deck){
        super("shuffle");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        myDeck.shuffle();
    }

}
