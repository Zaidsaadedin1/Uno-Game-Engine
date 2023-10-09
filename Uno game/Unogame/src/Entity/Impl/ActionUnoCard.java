package Entity.Impl;

import Entity.Card;
import Entity.DiscardPile;
import Entity.Player;
import Entity.types.CardColor;

import java.util.Collections;
import java.util.List;

public class ActionUnoCard extends Card {

    public ActionUnoCard(String value, CardColor color) {
        super(value, color);
    }

    @Override
    public UnoPlayer playCard(Card cardThrowed, Uno uno) {
        final List<UnoPlayer> unoPlayers = uno.getUnoPlayers();
         UnoPlayer currentPlayer = unoPlayers.get(uno.getCurrentPlayer());

        if (cardThrowed.getValue().equals("skip")) {
            currentPlayer = unoPlayers.get(uno.getNextNextPlayerIndex(uno.getCurrentPlayer()));
        } else if (cardThrowed.getValue().equals("reverse")) {
            if (unoPlayers.size() > 2) {
                Collections.reverse(unoPlayers);
                currentPlayer = unoPlayers.get(uno.getNextPlayerIndex(uno.getCurrentPlayer()));
            }
        } else if (cardThrowed.getValue().equals("+2")) {
            currentPlayer = unoPlayers.get(uno.getNextPlayerIndex(uno.getCurrentPlayer()));
            for (int i = 0; i < 2; i++) {
                currentPlayer.addCard(uno.getDeck().getTop());
            }
        }
        uno.getDiscardPile().addCardToPile(cardThrowed);
        return currentPlayer;
    }


}
