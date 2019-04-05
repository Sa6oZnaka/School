package org.elsys.cardgame.api.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;

public class Sort extends BasicOperation {

    private BasicDeck myDeck;

    Sort(BasicDeck deck){
        super("sort");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        myDeck.sort();
    }

}
