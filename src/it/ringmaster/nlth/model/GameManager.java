package it.ringmaster.nlth.model;

import java.util.*;

/**
 * This class represents the manager for the current game.
 * He keeps tracking of :
 *  - the current status of the game
 *  - the table
 *  - the cards of the players.
 */
public class GameManager {
    Status status;

    // HashMap (idPlayer, List<Cards>)
    Map<Long, List<Card>> playersCards;
    Table table;
    List<Card> tableCards;

    public GameManager()
    {
        this.status = null;
        this.playersCards = new HashMap<Long, List<Card>>();
        this.table = new Table();
        this.tableCards = new ArrayList<Card>();
    }

    public void startGame(Set<Player> players)
    {
        this.status = new Status();
        this.playersCards = new HashMap<>();
        //The first 2 players put the blind bets.
        for (Player p: players) {
            p.setCurrent_bet(1);
            playersCards.put(p.getId(), new ArrayList<Card>());
        }
        Dealer dealer = new Dealer();
        tableCards = dealer.shuffleAndDealCards(playersCards);

    }


}
