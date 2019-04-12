package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;

public class Size extends BasicOperation {

    private BasicDeck myDeck;

    Size(BasicDeck deck){
        super("size");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        System.out.println( this.myDeck.size() );
    }

}
