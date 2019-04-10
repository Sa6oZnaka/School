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

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj == this)
            return true;

        if (! (obj instanceof Card) )
            return false;

        Card otherCard = (Card)obj;
        return otherCard.getRank().getSymbol().equals(this.getRank().getSymbol()) && otherCard.getSuit().getSymbol().equals(this.getSuit().getSymbol());
    }
}
