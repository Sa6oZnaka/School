package org.elsys.cardgame;

import org.elsys.cardgame.api.*;
import org.elsys.cardgame.factory.DeckFactory;
import org.elsys.cardgame.factory.GameFactory;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Card> cardsArr = new ArrayList<>();
        String cardsString;

        cardsString = scanner.nextLine();
        String[] SingleCard = cardsString.split("\\s+");

        for (String s1 : SingleCard) {

            Rank rank = null;
            Suit suit = null;

            String s = s1.substring(0, 1);
            String r = s1.substring(1);

            for (Suit j : Suit.values()) {
                if (j.getSymbol().equals(s)) {
                    suit = j;
                }
            }
            for (Rank j : Rank.values()) {
                if (j.getSymbol().equals(r)) {
                    rank = j;
                }
            }

            CardImplement card = new CardImplement(rank, suit);
            cardsArr.add(card);

        }

        Game game = null;

        boolean initalised = false;
        while(scanner.hasNext()){
            String input = scanner.nextLine();

            if(input.equals("quit")) break;

            if(input.equals("Santase")){
                game = CreateGame(cardsArr, "Santase");
            }
            else if(input.equals("Belote")){
                game = CreateGame(cardsArr, "Belote");
            }
            else if(input.equals("War")){
                game = CreateGame(cardsArr, "War");
            }

            else {
                if (game != null) {
                    game.process(input);
                } else {
                    System.out.println("ERROR: Deck not initialed");
                }
            }
        }

    }
    private static Game CreateGame(List<Card> cardsArr, String type){
        List<Card> testCards = new ArrayList<>(cardsArr);

        Deck defaultDeck;
        DeckImplement testDeck;

        if(type.equals("Santase")) {
            defaultDeck = DeckFactory.defaultSantaseDeck();
            testDeck = new DeckImplement(testCards, 6, DeckFactory.cmp());
        }
        else if(type.equals("Belote")) {
            defaultDeck = DeckFactory.defaultBeloteDeck();
            testDeck = new DeckImplement(testCards, 8, DeckFactory.cmp());
        }else{
            defaultDeck = DeckFactory.defaultWarDeck();
            testDeck = new DeckImplement(testCards, 26, DeckFactory.cmp());
        }

        testDeck.sort();
        defaultDeck.sort();

        List<Card> Trash = new ArrayList<>();

        for(int i=0; i < testDeck.size();){

            if(testDeck.size() == 0) break;
            if(testDeck.topCard().equals(defaultDeck.topCard())){
                testDeck.drawTopCard();
                defaultDeck.drawTopCard();
            }else{
                Card c = testDeck.drawTopCard();
                Trash.add(c);
                i++;
            }
        }

        if(testDeck.size() == defaultDeck.size()) {

            for (int i = 0; i < cardsArr.size() - Trash.size(); i++) {
                for (int j = 0; j < Trash.size(); j++) {
                    if (cardsArr.get(i).equals(Trash.get(j))) {
                        cardsArr.remove(i);
                    }
                }
            }

            DeckImplement finalDeck = new DeckImplement(cardsArr, 6, DeckFactory.cmp());
            finalDeck.printCards(0, cardsArr.size());

            if(type.equals("Santase")){
                return GameFactory.createSantaseGame(cardsArr);
            }
            else if(type.equals("Belote")){
                return GameFactory.createSantaseGame(cardsArr);
            }
            else{
                return GameFactory.createSantaseGame(cardsArr);
            }
        }else{
            System.out.println("ERROR: Not enough cards for " + type);
            return null;
        }

    }
}