package it.ringmaster.nlth.model;

import java.util.*;

public class PlayersTurn {
    private Queue<Player> playersQueue;

    public PlayersTurn(Set<Player> players)
    {
       this.playersQueue = initializeStack(players);
    }

    private Queue<Player> initializeStack(Set<Player> players) {
        Queue<Player> stack = new LinkedList<>();
        Iterator<Player> iterator = players.iterator();
        while(iterator.hasNext())
        {
            stack.add(iterator.next());
        }
        return stack;
    }


    public Player getNextPlayer()
    {
        //Takes out the first player in the queue and re-adds him back in.
        Player tmp = this.playersQueue.remove();
        this.playersQueue.add(tmp);
        return tmp;
    }
}
