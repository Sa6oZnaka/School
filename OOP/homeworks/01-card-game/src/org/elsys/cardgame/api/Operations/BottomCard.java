package org.elsys.cardgame.api.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;

public class BottomCard extends BasicOperation {

    private BasicDeck myDeck;

    BottomCard(BasicDeck deck){
        super("bottom_card");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        System.out.println( myDeck.bottomCard() );
    }

}
