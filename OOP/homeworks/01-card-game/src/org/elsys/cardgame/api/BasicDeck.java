package org.elsys.cardgame.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BasicDeck implements Deck{

    private List<Card> myDeck = new ArrayList<>();
    private Hand myHand = new BasicHand();

    @Override
    public List<Card> getCards(){
        return this.myDeck;
    }

    public int size(){
        return this.myDeck.size();
    }

    public int handSize(){
        return this.myHand.size();
    }

    public Card drawTopCard(){
        BasicCard result;
        result = (BasicCard) myDeck.get(size() - 1);
        myDeck.remove(size() - 1);
        return result;
    }

    public Card topCard(){
        return myDeck.get(size() - 1);
    }

    public Card drawBottomCard(){
        BasicCard result;
        result = (BasicCard) myDeck.get(0);
        myDeck.remove(0);
        return result;
    }

    public Card bottomCard(){
        return this.myDeck.get(0);
    }

    public Hand deal() {
        return null;
    }

    public void sort(){
        Collections.sort(myDeck, new Comparator<Card>() {
            @Override
            public int compare(Card a, Card b){
                return  a.getRank().compareTo(b.getRank());
            }
        });
    }

    public void shuffle(){
        Collections.shuffle(myDeck);
    }

}
