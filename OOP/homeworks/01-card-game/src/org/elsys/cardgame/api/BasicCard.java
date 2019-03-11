package org.elsys.cardgame.api;

public class BasicCard implements Card{

    private Suit mySuit;
    private Rank myRank;

    @Override
    public Suit getSuit() {
        return mySuit;
    }

    public Rank getRank() {
        return myRank;
    }

}
