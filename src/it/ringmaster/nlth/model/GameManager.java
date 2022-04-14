package it.ringmaster.nlth.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        this.status = new Status();
        this.playersCards = new HashMap<Long, List<Card>>();
        this.table = new Table();
        this.tableCards = new ArrayList<Card>();
    }

    public void startGame()
    {

    }


}
