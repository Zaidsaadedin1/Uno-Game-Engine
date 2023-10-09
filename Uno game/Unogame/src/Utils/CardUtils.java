package Utils;

import Entity.Card;
import Entity.Impl.WildUnoCards;

public class CardUtils {

    public static boolean isWildCard(Card card) {
        return card instanceof WildUnoCards;
    }
}
