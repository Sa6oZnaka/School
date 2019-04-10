package org.elsys.cardgame.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BasicDeck implements Deck{

    private List<Card> myDeck;
    private int myHandSize;
    private Comparator<Card> cmp;

    public BasicDeck(List<Card> deckCards,int handSize, Comparator<Card> cmp){
        this.myDeck = deckCards;
        this.myHandSize = handSize;
        this.cmp = cmp;
    }

    @Override
    public List<Card> getCards(){
        return myDeck;
    }

    @Override
    public int size(){
        return myDeck.size();
    }

    @Override
    public int handSize(){
        return myHandSize;
    }

    @Override
    public Card drawTopCard(){
        Card result;
        result = myDeck.get(0);
        myDeck.remove(0);
        return result;
    }

    @Override
    public Card topCard(){
        check();
        return myDeck.get(0);
    }

    @Override
    public Card drawBottomCard(){
        Card result;
        result = myDeck.get(size() - 1);
        myDeck.remove(size() - 1);
        return result;
    }

    @Override
    public Card bottomCard(){
        return myDeck.get(size() - 1);
    }

    @Override
    public Hand deal() {
        List<Card> result = new ArrayList<Card>();
        for(int i = 0;i < myHandSize;i ++){
            Card tmp = drawTopCard();
            result.add(tmp);
        }
        return new BasicHand(result ,myHandSize);
    }

    @Override
    public void sort(){
        myDeck.sort(cmp);
    }

    @Override
    public void shuffle(){
        Collections.shuffle(myDeck);
    }

    private void check() throws CardException{
        if(this.myDeck.size() == 0) {
            //throw new CardException("ERROR: Not enough cards in deck");
            throw new CardException();
        }
    }


}
