package Entity.Impl;

import Entity.Card;
import Entity.DiscardPile;
import Entity.Impl.Uno;
import Entity.types.CardColor;

import java.util.List;
import java.util.Scanner;

public class WildUnoCards extends Card {

    public WildUnoCards(String value, CardColor color) {
        super(value, color);
    }

    @Override
    public UnoPlayer playCard(Card cardThrowed, Uno uno) {
        final List<UnoPlayer> unoPlayers = uno.getUnoPlayers();
        UnoPlayer currentPlayer = null;

        if (cardThrowed.getValue().equals("+4")) {
            System.out.println("Please enter your color ");
            Scanner scanner1 = new Scanner(System.in);
            String color = scanner1.nextLine();
            System.out.println("player color " + CardColor.valueOf(color));
            uno.getDiscardPile().addCardToPile(cardThrowed);
            uno.getDiscardPile().setColor(CardColor.valueOf(color));
            currentPlayer = unoPlayers.get(uno.getNextPlayerIndex(uno.getCurrentPlayer()));
            for (int i = 0; i < 4; i++) {
                currentPlayer.addCard(uno.getDeck().getTop());
            }
        } else if (cardThrowed.getValue().equals("wild")) {
            System.out.println("player enter your color ");
            Scanner scanner1 = new Scanner(System.in);
            String color = scanner1.nextLine();
            System.out.println("player color " + CardColor.valueOf(color));

            currentPlayer = unoPlayers.get(uno.getNextPlayerIndex(uno.getCurrentPlayer()));
            uno.getDiscardPile().addCardToPile(cardThrowed);
            uno.getDiscardPile().setColor(CardColor.valueOf(color));
        }
        return currentPlayer;
    }


}
