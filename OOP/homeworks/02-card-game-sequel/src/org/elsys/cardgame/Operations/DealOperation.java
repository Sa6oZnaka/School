package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.OperationImplement;
import org.elsys.cardgame.api.Deck;

public class DealOperation extends OperationImplement {

    private Deck myDeck;

    public DealOperation(Deck deck){
        super("deal");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        myDeck.deal();
    }

}
