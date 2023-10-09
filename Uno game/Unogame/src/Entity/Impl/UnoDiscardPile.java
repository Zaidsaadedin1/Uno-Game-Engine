package Entity.Impl;

import Entity.Card;
import Entity.Deck;
import Entity.DiscardPile;
import Entity.types.CardColor;

import java.util.ArrayList;
import java.util.List;

public class UnoDiscardPile implements DiscardPile {
    private List<Card> discardPile;


    public UnoDiscardPile() {
        this.discardPile = new ArrayList<>();
    }

    public Card getTop() {

        int discardPileSize=discardPile.size()-1;
        return discardPile.get(discardPileSize);
    }

    public void setColor(CardColor color) {
        Card top = getTop();
        top.setColor(color);

        discardPile.set(discardPile.size() -1 , top);
    }
    public void addCardToPile(Card card){
        discardPile.add(card);
    }

    public void resetPile(Deck deck){
        deck.addCardsToDeck(discardPile);
        discardPile.removeAll(discardPile);
    }


}
