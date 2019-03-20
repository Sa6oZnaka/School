package org.elsys.cardgame.api;

import java.util.List;

public class BasicHand implements Hand{

    private List<Card> myCards;
    private int size;

    BasicHand(List<Card> cards, int size){
        this.myCards = cards;
        this.size = size;
    }

    @Override
    public List<Card> getCards() {
        return myCards;
    }

    @Override
    public int size(){
        return size;
    }

}
