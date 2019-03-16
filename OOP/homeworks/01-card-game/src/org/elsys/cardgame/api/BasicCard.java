package org.elsys.cardgame.api;

public class BasicCard implements Card{

    private Suit mySuit;
    private Rank myRank;

    public BasicCard(Rank rank, Suit suit){
        this.myRank = rank;
        this.mySuit = suit;
    }

    @Override
    public Suit getSuit() {
        return mySuit;
    }

    @Override
    public Rank getRank() {
        return myRank;
    }

}
