package org.elsys.cardgame.api;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicDeck implements Deck{

    private List<Card> myList = new ArrayList<>();
    private Hand myHand;

    @Override
    public List<Card> getCards(){
        return myList;
    }

    public int size(){
        return myList.size();
    }

    public int handSize(){
        return myHand.size();
    }

    //public Card drawTopCard(){
    //    Card result;
    //    return result;
    //}

    public Card topCard(){
        return myList.get(size() - 1);
    }

    /*Card drawBottomCard();

    Card bottomCard();

    Hand deal();

    void sort();

    void shuffle();
    */

}
