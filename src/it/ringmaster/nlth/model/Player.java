package it.ringmaster.nlth.model;

// - Player (Current bet, Enum -> Player status (idle, active), Utility)

import it.ringmaster.nlth.model.Enums.*;

public class Player {
    private final Long id;
    private static Long lastId;
    private double utility;
    private int current_bet;
    private State currentStatus;

    public Player(){
        //Initializing the player id and modifying the
        // field lastId for the next player to create.
        this.id = lastId++;

        this.utility=0;
        this.current_bet=0;
        this.currentStatus = State.inactive;
    }
    public Long getId() {
        return id;
    }

    public double getUtility() {
        return utility;
    }

    public void setUtility(double utility) {
        this.utility = utility;
    }

    public int getCurrent_bet() {
        return current_bet;
    }

    public void setCurrent_bet(int current_bet) {
        this.current_bet = current_bet;
    }

    public State getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(State currentStatus) {
        this.currentStatus = currentStatus;
    }
}
