package it.ringmaster.nlth.classes;

import java.util.*;

public class Game {

    private static List<Card> cards;

    public Game()
    {
        cards = generateCards();

    }

    private List<Card> generateCards()
    {
        List<Card> cards = new LinkedList<>();
        for (Value v: Value.values())
        {
            for (Suit s: Suit.values())
            {
                cards.add(new Card(v,s));
            }
        }
        return cards;
    }

    /**
     * Gets all the necessary cards for the game to begin.
     * @param n_players Number of players in game.
     * @return A List containing 2*n_players (players' hands) + 5 (field) cards
     */
    public List<Card> getCards(int n_players){
        Collections.shuffle(cards);

        List<Card> game_cards = new LinkedList<Card>();
        game_cards.addAll(cards.subList(0,2*n_players+5));
        return game_cards;
    }
}

enum Value
{
    ace,
    two,
    three,
    four,
    five,
    six,
    seven,
    eight,
    nine,
    jack,
    queen,
    king
}

enum Suit
{
    heart,
    diamond,
    spade,
    club
}

class Card
{
    Suit suit;
    Value value;

    public Card(Value value, Suit suit)
    {
        this.value = value;
        this.suit = suit;
    }
}

//Tree containing every possible state for the game.
class TreeStates
{
    class Node {
        private int payoff;
        private String action;
        private List<Node> children;

        public Node(String action, int payoff) {
            this.action = action;
            this.payoff = payoff;
            this.children = null;
        }

        public String getAction()
        {
            return this.action;
        }
        public int getPayoff()
        {
            return this.payoff;
        }

        public void setChildren(List<Node> children)
        {
            this.children = children;
        }
        public List<Node> getChildren()
        {
            return this.children;
        }
    }

    public void insert(Node node)
    {

    }

    public List<Node> generateChildren(int check, int bet, int fold, Node previous_node)
    {
        if((fold-1)==(n_players))
            return null;

        String previous_action = previous_node.getAction();

        List<Node> children_nodes = new LinkedList<>();
        int previous_payoff = previous_node.getPayoff();

        //To calculate the payoff, this code will check if the previous action was a bet.
        //If in the next turn there's  going to be call/bet, the bet value should be added.
        //Otherwise, if there's going to be a fold, there's no need to modify the payoff of that turn

        for (String action: Action.Actions) {
            if(action.equals("B") && bet<3*n_players){
                Node node = new Node(action, previous_payoff + 1 + (previous_action == "B"? 1:0));
                node.setChildren(generateChildren(check,bet+1,fold, node));
                children_nodes.add(node);
            }
            //Should check if the last plays were final.
            if(action.equals("C") && !check_final_hand){
                Node node = new Node(action, previous_payoff + (previous_action == "B"? 1:0));
                node.setChildren(generateChildren(check+1,bet,fold, node));
                children_nodes.add(node);
            }
            if(action.equals("F")){
                Node node = new Node(action, previous_payoff);
                node.setChildren(generateChildren(check,bet,fold+1, node));
                children_nodes.add(node);
            }
        }
        return children_nodes;
    }
}


class Action
{
    public static List<String> Actions;

    public Action()
    {
        Actions = new LinkedList<>();
        Actions.add("B"); // Bet
        Actions.add("C"); // Check/Call
        Actions.add("F"); // Fold
    }
}