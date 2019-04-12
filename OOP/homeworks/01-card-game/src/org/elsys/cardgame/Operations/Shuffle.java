package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;
import org.elsys.cardgame.api.Deck;

public class Shuffle extends BasicOperation {

    private Deck myDeck;

    public Shuffle(Deck deck){
        super("shuffle");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        myDeck.shuffle();
    }

}
