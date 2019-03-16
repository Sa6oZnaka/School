package org.elsys.cardgame.api;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BasicDeck implements Deck{

    private List<Card> myDeck;
    private int myHandSize;

    public BasicDeck(List<Card> deckCards,int handSize){
        this.myDeck = deckCards;
        this.myHandSize = handSize;
    }

    @Override
    public List<Card> getCards(){
        return this.myDeck;
    }

    @Override
    public int size(){
        return this.myDeck.size();
    }

    @Override
    public int handSize(){
        //return this.myHand.size();
        return myHandSize;
    }

    @Override
    public Card drawTopCard(){
        BasicCard result;
        result = (BasicCard) myDeck.get(size() - 1);
        myDeck.remove(size() - 1);
        return result;
    }

    @Override
    public Card topCard(){
        return myDeck.get(size() - 1);
    }

    @Override
    public Card drawBottomCard(){
        BasicCard result;
        result = (BasicCard) myDeck.get(0);
        myDeck.remove(0);
        return result;
    }

    @Override
    public Card bottomCard(){
        return this.myDeck.get(0);
    }

    @Override
    public Hand deal() {
        return new BasicHand(myDeck);
    }

    @Override
    public void sort(){
        Collections.sort(myDeck, new Comparator<Card>() {
            @Override
            public int compare(Card a, Card b){
                return  a.getRank().compareTo(b.getRank());
            }
        });
    }

    @Override
    public void shuffle(){
        Collections.shuffle(myDeck);
    }

}
