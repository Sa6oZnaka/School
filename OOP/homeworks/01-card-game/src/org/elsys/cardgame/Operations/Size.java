package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.BasicDeck;
import org.elsys.cardgame.api.BasicOperation;
import org.elsys.cardgame.api.Deck;

public class Size extends BasicOperation {

    private Deck myDeck;

    public Size(Deck deck){
        super("size");

        this.myDeck = deck;
    }

    @Override
    public void execute(){
        System.out.println( this.myDeck.size() );
    }

}
