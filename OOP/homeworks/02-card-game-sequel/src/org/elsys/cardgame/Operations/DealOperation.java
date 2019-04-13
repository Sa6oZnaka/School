package org.elsys.cardgame.Operations;

import org.elsys.cardgame.api.*;

public class DealOperation extends OperationImplement {

    private Deck myDeck;
    private Game game;

    public DealOperation(Game game, Deck deck){
        super("deal");

        this.myDeck = deck;
        this.game = game;
    }

    @Override
    public void execute(){
        Hand hand = myDeck.deal();
        game.setDealtHand(hand);
    }

}
