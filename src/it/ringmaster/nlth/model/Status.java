package it.ringmaster.nlth.model;

// - Status (Actual status (Flop, ecc...), Past status(number of bets/check/fold))

public class Status {
    String actualStatus;

    //Keeping track of the number of actions
    // that happened during the game.
    int bet;
    int fold;
    //check/call
    int check_call;

    public Status()
    {
        //New Game
        //The game begins during the 'pre-flop' status.
        //Every player already bet 1 fiches, and they got the cards.

        //Status= Pre-flop, Flop, Turn, River, Showdown
        this.actualStatus ="pre-flop";
        this.bet=0;
        this.check_call=0;
        this.fold=0;
    }

    public void addAction(String action)
    {
        if(action.equals("B"))
            this.bet++;
        else if(action.equals("C"))
            this.check_call++;
        else if(action.equals("F"))
            this.fold++;
    }

    public String getActualStatus() {
        return actualStatus;
    }

    public void setActualStatus(String actualStatus)
    {
        this.actualStatus = actualStatus;
    }

    public int getBet() {
        return bet;
    }

    public int getCheck_call() {
        return check_call;
    }

    public int getFold() {
        return fold;
    }
}
