package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;
import org.elsys.cardgame.api.Deck;

public class BottomCard extends BasicOperation {

    private Deck myDeck;

    public BottomCard(Deck deck){
        super("bottom_card");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        System.out.println( myDeck.bottomCard().getSuit() + "" + myDeck.bottomCard().getRank() );
    }

}
