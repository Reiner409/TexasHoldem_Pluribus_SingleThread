package it.ringmaster.nlth.model;

// - Player (Current bet, Enum -> Player status (idle, active), Utility)

import it.ringmaster.nlth.model.Enums.*;

public class Player {
    final Long id;
    static Long lastId;
    double utility;
    int current_bet;
    State currentStatus;

    public Player(){
        //Initializing the player id and modifying the
        // field lastId for the next player to create.
        this.id = lastId++;

        this.utility=0;
        this.current_bet=0;
        this.currentStatus = State.inactive;
    }
}
