package it.ringmaster.nlth.model;
import it.ringmaster.nlth.model.Enums.Suit;
import it.ringmaster.nlth.model.Enums.Value;

public class Card
{
    private Suit suit;
    private Value value;

    public Card(Value value, Suit suit)
    {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue()
    {
        return this.value;
    }

    public Suit getSuit() {
        return this.suit;
    }
}
