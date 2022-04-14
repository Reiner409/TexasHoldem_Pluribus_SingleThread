package it.ringmaster.nlth.model;

import it.ringmaster.nlth.model.Enums.Suit;
import it.ringmaster.nlth.model.Enums.Value;

import java.util.*;

// - Dealer (Init cards, Give cards, Shuffle Cards)

public class Dealer {
    private List<Card> cards;

    public Dealer()
    {
        cards = generateCards();
    }

    private List<Card> generateCards() {
        List<Card> cards = new LinkedList<>();
        for (Value v : Value.values()) {
            for (Suit s : Suit.values()) {
                cards.add(new Card(v, s));
            }
        }
        return cards;
    }

    /**
     * Gets all the necessary cards for the game to begin.
     * Shuffles the cards from the deck and returns the cards
     * necessary for the game to be played.
     * @param playersCards A map containing all the players to initialize their cards
     * @return A List containing 5 cards which are destined to the table.
     */
    public List<Card> shuffleAndDealCards(Map<Long, List<Card>> playersCards){
        Collections.shuffle(cards);
        ListIterator<Card> cardListIterator = cards.listIterator();
        for (Long playerId: playersCards.keySet()) {
            List<Card> playerCards = new ArrayList<>();
            playerCards.add(cardListIterator.next());
            playersCards.put(playerId, playerCards);
        }

        List<Card> tableCards = new ArrayList<>();
        for(int i=0;i<5;i++){
            tableCards.add(cardListIterator.next());
        }
        return tableCards;
    }
}
