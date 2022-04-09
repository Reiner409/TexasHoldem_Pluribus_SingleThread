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

class TreeNode<T> implements Iterable<TreeNode<T>>{

    T data;
    TreeNode<T> parent;
    List<TreeNode<T>> children;

    public TreeNode(T data)
    {
        this.data=data;
        this.children = new LinkedList<TreeNode<T>>();
    }

    @Override
    public Iterator<TreeNode<T>> iterator() {
        return this.children.iterator();
    }
}