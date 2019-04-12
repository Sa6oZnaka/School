package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.OperationImplement;
import org.elsys.cardgame.api.Deck;

public class TopCard extends OperationImplement {

    private Deck myDeck;

    public TopCard(Deck deck){
        super("top_card");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        System.out.println(myDeck.topCard().getSuit() + "" +  myDeck.topCard().getRank());
    }
}
