package Entity.Impl;

import Entity.Card;
import Entity.DiscardPile;
import Entity.types.CardColor;

import java.util.List;

public class NumberUnoCards extends Card {

    public NumberUnoCards(String value, CardColor color) {
        super(value, color);
    }

    @Override
    public UnoPlayer playCard(Card cardThrowed, Uno uno) {
        final List<UnoPlayer> unoPlayers = uno.getUnoPlayers();
        uno.getDiscardPile().addCardToPile(cardThrowed);
        return unoPlayers.get(uno.getNextPlayerIndex(uno.getCurrentPlayer()));
    }


}
