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
        this.actualStatus =;
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

}
