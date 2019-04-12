package org.elsys.cardgame;

import org.elsys.cardgame.Operations.*;
import org.elsys.cardgame.api.*;
import org.elsys.cardgame.factory.DeckFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deck deck;

        String type = scanner.nextLine();
        if (type.equals("Santase")){
            deck = DeckFactory.defaultSantaseDeck();
        }
        else if(type.equals("Belote")){
            deck = DeckFactory.defaultBeloteDeck();
        }
        else{
            deck = DeckFactory.defaultWarDeck();
        }

        GameImplement game = new GameImplement(deck);

        game.addOperation(new BottomCard(deck));
        game.addOperation(new DealOperation(deck));
        game.addOperation(new DrawBottomCard(deck));
        game.addOperation(new DrawTopCard(deck));
        game.addOperation(new Shuffle(deck));
        game.addOperation(new Size(deck));
        game.addOperation(new Sort(deck));
        game.addOperation(new TopCard(deck));

        while(scanner.hasNext()){
            String input = scanner.nextLine();
            if(input.equals("quit")) break;

            game.process(input);
        }

    }

}