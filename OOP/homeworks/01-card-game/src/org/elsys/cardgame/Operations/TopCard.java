package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;
import org.elsys.cardgame.api.Deck;

public class TopCard extends BasicOperation {

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
