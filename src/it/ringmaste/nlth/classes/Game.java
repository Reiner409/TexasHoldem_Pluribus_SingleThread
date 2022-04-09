package it.ringmaste.nlth.classes;

import java.util.LinkedList;
import java.util.List;

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