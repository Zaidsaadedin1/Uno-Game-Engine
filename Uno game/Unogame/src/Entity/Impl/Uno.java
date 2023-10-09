package Entity.Impl;

import Entity.Card;
import Entity.Deck;
import Entity.DiscardPile;
import Entity.Player;
import Entity.types.CardColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static Utils.CardUtils.isWildCard;

public class Uno extends Game {

    private static Uno instant;
    private int currentPlayerIndex;
    private List<UnoPlayer> unoPlayers;
    private UnoDeck deck;
    private DiscardPile discardPile;
    private UnoPlayer winner;

    private Uno() {
        System.out.println("please enter the number of players");
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = scanner.nextInt();
        this.unoPlayers = new ArrayList<>();
        this.deck = new UnoDeck();
        this.discardPile = new UnoDiscardPile();
        this.winner = null;
        for (int i = 0; i < numberOfPlayers; i++) {
            unoPlayers.add(new UnoPlayer());
        }
    }

    static public Uno getInstance() {
        if (instant == null) {
            instant = new Uno();
        }

        return instant;
    }

    public List<UnoPlayer> getUnoPlayers() {
        return unoPlayers;
    }

    public Deck<Card> getDeck() {
        return deck;
    }

    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    public UnoPlayer getWinner() {
        return winner;
    }

    private void checkWinner(UnoPlayer unoPlayer) {
        for (UnoPlayer player : unoPlayers) {
            if (player.handSize() == 0) {
                winner = player;
                break;
            }
        }
    }

    @Override
    public void dealCards() {
        deck.shuffleCards();
        for (UnoPlayer unoPlayer : unoPlayers) {
            List<Card> hand = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                hand.add(deck.getTop());
            }
            unoPlayer.setHand(hand);

        }
    }

    private void showPlayerHand(UnoPlayer unoPlayer) {

        for (Card card : unoPlayer.getHand()) {
            System.out.print(" ( color: " + card.getColor() + " value: " + card.getValue() + " ) ");
        }
    }


    public int getCurrentPlayer() {
        return currentPlayerIndex;
    }


    public int getNextPlayerIndex(int currentPlayerIndex) {
        return (currentPlayerIndex + 1) % unoPlayers.size();
    }

    public int getNextNextPlayerIndex(int currentPlayerIndex) {
        return (currentPlayerIndex + 2) % unoPlayers.size();
    }

    private void displayGameStatus() {
        int index = 1;
        System.out.println("------ UNO Game Status ------");
        System.out.println();
        System.out.println("Player " + index + " hand");
        showPlayerHand(unoPlayers.get(0));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(String.format("%-20s", ("DiscardPile " + "\n" + discardPile.getTop().getValue() + "\n" + discardPile.getTop().getColor())));
        index++;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Player " + index + " hand");
        showPlayerHand(unoPlayers.get(1));
    }

    @Override
    public void play() {
        dealCards();
        discardPile.addCardToPile(deck.getTop());
        currentPlayerIndex = 0;
        displayGameStatus();
        UnoPlayer currentPlayer = unoPlayers.get(currentPlayerIndex);

        while (winner == null) {
            System.out.println();
            System.out.println("It's Player " + (currentPlayerIndex + 1) + "'s turn.");
            System.out.println("Please choose the index of the card you want to play: ");
            Scanner scanner = new Scanner(System.in);
            int indexOfTheCard = scanner.nextInt();
            Card cardThrowed = currentPlayer.throwCard(currentPlayer.getCardByIndex(indexOfTheCard), discardPile.getTop(), deck);

            if (cardThrowed == null) {
                continue;
            }
            if (isWildCard(cardThrowed) || cardThrowed.getColor().equals(discardPile.getTop().getColor()) || cardThrowed.getValue().equals(discardPile.getTop().getValue())) {
                currentPlayer = cardThrowed.playCard(cardThrowed, this);

            } else {
                currentPlayer.addCard(deck.getTop());
            }

            checkWinner(currentPlayer);
            displayGameStatus();
            currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
            currentPlayer = unoPlayers.get(currentPlayerIndex);
        }
        System.out.println("Player " + (unoPlayers.indexOf(winner) + 1) + " wins the game!");
    }
}



