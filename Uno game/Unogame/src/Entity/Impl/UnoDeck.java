package Entity.Impl;

import Entity.Card;
import Entity.Deck;
import Entity.types.ActionCardTypes;
import Entity.types.CardColor;
import Entity.types.WildCardTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnoDeck implements Deck<Card> {
    private final List<Card> cards;

    public UnoDeck(){
        cards = new ArrayList<>();

        for (CardColor color : CardColor.values()) {
            cards.add(new NumberUnoCards("0", color ));
            for (int i = 0; i < 2; i++) {
                for (int number = 1; number < 10; number++) {
                    cards.add(new NumberUnoCards(String.valueOf(number), color));
                }

                for (ActionCardTypes actionCardTypes : ActionCardTypes.values()) {
                    cards.add(new ActionUnoCard(actionCardTypes.toString(), color));
                }
                for (WildCardTypes wildCardTypes : WildCardTypes.values()) {
                    cards.add(new WildUnoCards(wildCardTypes.toString(), null));
                }
            }
        }
    }


    public List<Card> getCards() {

       for (Card card: cards) {
           System.out.println(card.getValue() + " - " + card.getColor());
       }
        return cards;
    }


    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public Card getTop(){
       return cards.remove(0);
    }

    @Override
    public int getSize() {
        return cards.size();
    }

    @Override
    public void addCardsToDeck(List<Card> newCards) {
        cards.addAll(newCards);
    }


}


