package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.OperationImplement;
import org.elsys.cardgame.api.Deck;

public class Shuffle extends OperationImplement {

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
