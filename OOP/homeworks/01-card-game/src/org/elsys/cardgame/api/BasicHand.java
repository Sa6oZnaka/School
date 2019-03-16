package org.elsys.cardgame.api;

import java.util.List;

public class BasicHand implements Hand{

    private List<Card> myCards;

    BasicHand(List<Card> cards){
        this.myCards = cards;
    }

    @Override
    public List<Card> getCards() {
        return myCards;
    }

    @Override
    public int size(){
        return myCards.size();
    }

}
