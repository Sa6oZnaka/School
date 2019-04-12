package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.OperationImplement;
import org.elsys.cardgame.api.Deck;

public class Size extends OperationImplement {

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
