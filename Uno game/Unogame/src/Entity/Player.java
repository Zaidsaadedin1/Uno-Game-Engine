package Entity;

import Entity.Impl.UnoDeck;

import java.util.List;

public interface Player {
    Card throwCard(final Card playedCard, final Card topCardPile, final UnoDeck deck);

    List<Card> getHand();

    void setHand(List<Card> hand);

    void addCard(Card card);
    int handSize();
    Card drawCard(UnoDeck unoDeck);
    Card getCardByIndex(int index);
}