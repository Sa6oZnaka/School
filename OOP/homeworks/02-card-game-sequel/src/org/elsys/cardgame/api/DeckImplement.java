package org.elsys.cardgame.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DeckImplement implements Deck{

    private List<Card> myDeck;
    private int myHandSize;
    private Comparator<Card> cmp;

    public DeckImplement(List<Card> deckCards, int handSize, Comparator<Card> cmp){
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
        checkDraw();

        Card result;
        result = myDeck.get(0);
        myDeck.remove(0);
        return result;
    }

    @Override
    public Card topCard(){
        checkDraw();
        return myDeck.get(0);
    }

    @Override
    public Card drawBottomCard(){
        checkDraw();

        Card result;
        result = myDeck.get(size() - 1);
        myDeck.remove(size() - 1);
        return result;
    }

    @Override
    public Card bottomCard(){
        checkDraw();
        return myDeck.get(size() - 1);
    }

    @Override
    public Hand deal() {
        checkDeal();
        printCards(0, myHandSize);

        List<Card> result = new ArrayList<Card>();
        for(int i = 0;i < myHandSize;i ++){
            Card tmp = drawTopCard();
            result.add(tmp);
        }
        return new HandImplement(result ,myHandSize);
    }

    @Override
    public void sort(){
        myDeck.sort(cmp);
        printCards(0, size());
    }

    @Override
    public void shuffle(){
        Collections.shuffle(myDeck);
        printCards(0, size());
    }

    private void checkDraw() throws CardException{
        if(this.myDeck.size() == 0) {
            throw new CardException("ERROR: Not enough cards in deck");
        }
    }

    private void checkDeal() throws CardException{
        if(this.myDeck.size() < myHandSize) {
            throw new CardException("ERROR: Not enough cards in deck");
        }
    }

    public void printCards(int from, int to){
        for(int i = from;i < to;i ++){
            System.out.print(myDeck.get(i).getSuit() + "" + myDeck.get(i).getRank() + " ");
        }
        System.out.println();
    }


}
