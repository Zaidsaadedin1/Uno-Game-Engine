package Entity.Impl;

import Entity.Card;
import Entity.Deck;
import Entity.Player;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

import static Utils.CardUtils.isWildCard;


public class UnoPlayer implements Player {


    private  List<Card> hand;

    public UnoPlayer() {
        this.hand=new ArrayList<>();
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    @Override
    public void addCard(Card card) {
        hand.add(card);
    }

    @Override
    public List<Card> getHand() {
        return hand;
    }


    public String sayUno(){
       return "Uno";
    }

    public String uno(){
        if (hand.size()==1){
           return sayUno();
        }else {
            return "You cant say uno unless you have one card in your hand";
        }
    }

    private Card getValidCard(final Card topCard) {
        for (Card card: hand) {
            if (isWildCard(card) || card.getColor().equals(topCard.getColor()) || card.getValue().equals(topCard.getValue())){
                return card;
            }
        }
        return null;
    }


    public Card throwCard(final Card playedCard, final Card topCardPile, UnoDeck deck) {
        if(getValidCard(topCardPile) == null) {

            return drawCard(deck);
        }
       if ( isWildCard(playedCard) || playedCard.getColor().toString().equals(topCardPile.getColor().toString()) ||
       playedCard.getValue().equals(topCardPile.getValue())
       ) {
           hand.remove(playedCard);
           return playedCard;
       }

       else return null;
    }

    public int handSize(){
        return hand.size();
    }

    public Card drawCard(UnoDeck unoDeck){
        Card card =  unoDeck.getTop();
        hand.add(card);
        return card;
    }

    public Card getCardByIndex(int index){
        Card chosenCard=hand.get(index);
        return chosenCard;
    }

}
