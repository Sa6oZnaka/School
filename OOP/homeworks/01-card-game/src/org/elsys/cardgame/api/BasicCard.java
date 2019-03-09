package org.elsys.cardgame.api;

public abstract class BasicCard implements Card{

    Suit mySuit;
    Rank myRank;

    @Override
    public Suit getSuit() {
        return mySuit;
    }

    public Rank getRank() {
        return myRank;
    }



}
