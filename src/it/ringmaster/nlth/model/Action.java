package it.ringmaster.nlth.model;

import java.util.ArrayList;
import java.util.List;

public class Action {
    private static List<String> Actions;

    public Action() {
        Actions = new ArrayList<>();
        Actions.add("B"); // Bet
        Actions.add("C"); // Check/Call
        Actions.add("F"); // Fold
    }

    public List<String> getActions()
    {
        return Actions;
    }
}
