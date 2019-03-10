package org.elsys.cardgame.api;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicHand implements Hand{

    private List<Card> myList = new ArrayList<>();

    @Override
    public List<Card> getCards() {
        return myList;
    }

    public int size(){
        return myList.size();
    }

}
