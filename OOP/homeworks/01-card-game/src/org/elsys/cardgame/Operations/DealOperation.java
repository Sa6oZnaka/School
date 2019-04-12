package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;
import org.elsys.cardgame.api.Deck;

public class DealOperation extends BasicOperation {

    private Deck myDeck;

    public DealOperation(Deck deck){
        super("deal");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        System.out.println( myDeck.deal() );
    }

}
