package Entity;

import Entity.Impl.Uno;
import Entity.Impl.UnoPlayer;
import Entity.Impl.UnoDeck;


public class GameDriver {
    public static void main(String[] args) {
        Uno uno= Uno.getInstance();
        uno.play();


    }
}
