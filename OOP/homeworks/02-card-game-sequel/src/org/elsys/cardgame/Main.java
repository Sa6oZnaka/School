package org.elsys.cardgame;

import org.elsys.cardgame.Operations.*;
import org.elsys.cardgame.api.*;
import org.elsys.cardgame.factory.GameFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

            //System.out.println("S: |" + s + "| R: |" + r + "|");

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

        Game game;
        String type = scanner.nextLine();
        if (type.equals("Santase")){
            game = GameFactory.createSantaseGame(cardsArr);
        }
        else if(type.equals("Belote")){
            game = GameFactory.createBeloteGame(cardsArr);
        }
        else{
            game = GameFactory.createWarGame(cardsArr);
        }

        game.addOperation(new BottomCard(game.getDeck()));
        game.addOperation(new DealOperation(game.getDeck()));
        game.addOperation(new DrawBottomCard(game.getDeck()));
        game.addOperation(new DrawTopCard(game.getDeck()));
        game.addOperation(new Shuffle(game.getDeck()));
        game.addOperation(new Size(game.getDeck()));
        game.addOperation(new Sort(game.getDeck()));
        game.addOperation(new TopCard(game.getDeck()));

        while(scanner.hasNext()){
            String input = scanner.nextLine();
            if(input.equals("quit")) break;

            game.process(input);
        }

    }

}