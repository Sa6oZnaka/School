package org.elsys.cardgame.api;

import java.util.Objects;

public class CardImplement implements Card{

    private Suit mySuit;
    private Rank myRank;

    public CardImplement(Rank rank, Suit suit){
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardImplement that = (CardImplement) o;
        return mySuit == that.mySuit &&
                myRank == that.myRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mySuit, myRank);
    }
}
