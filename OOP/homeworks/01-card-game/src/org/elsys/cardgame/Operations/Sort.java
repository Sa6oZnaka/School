package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;
import org.elsys.cardgame.api.Deck;

public class Sort extends BasicOperation {

    private Deck myDeck;

    public Sort(Deck deck){
        super("sort");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        if(myDeck.size() > 0) {
            myDeck.sort();
        }
    }

}
