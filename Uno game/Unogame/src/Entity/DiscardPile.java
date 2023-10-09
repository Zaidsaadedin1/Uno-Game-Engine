    package Entity;

    import Entity.types.CardColor;

    public interface DiscardPile {

        Card getTop() ;
        void addCardToPile(Card card);
        void resetPile(Deck<Card> deck);

        void setColor(CardColor color);
    }
