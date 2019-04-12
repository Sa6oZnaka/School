package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.OperationImplement;
import org.elsys.cardgame.api.Deck;

public class Sort extends OperationImplement {

    private Deck myDeck;

    public Sort(Deck deck){
        super("sort");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        myDeck.sort();
    }

}
