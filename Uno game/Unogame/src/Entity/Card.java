package Entity;

import Entity.Impl.Uno;
import Entity.Impl.UnoDeck;
import Entity.Impl.UnoPlayer;
import Entity.types.CardColor;

public abstract class Card {

    private  String value;
    private  CardColor color;

    public void setValue(String value) {
        this.value = value;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }

    public Card(String value, CardColor color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public CardColor getColor() {
        return color;
    }



    public abstract UnoPlayer playCard(Card card, Uno uno);

}