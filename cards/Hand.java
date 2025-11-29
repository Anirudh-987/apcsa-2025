package cards;

public class Hand {
   private Card[] cards;
    private int size;  // number of cards currently in hand

    public Hand(int maxSize) {
        cards = new Card[maxSize];
        size = 0;
    }

    public void add(Card c) {
        if (size < cards.length) {
            cards[size] = c;
            size++;
        }
    }

    public int length() {
        return size;
    }

    public Card get(int index) {
        if (index < 0 || index >= size)
            return null;
        return cards[index];
    }

    public Card remove(int index) {
        if (index < 0 || index >= size)
            return null;

        Card removed = cards[index];

        // shift elements left
        for (int i = index; i < size - 1; i++) {
            cards[i] = cards[i + 1];
        }

        cards[size - 1] = null;
        size--;

        return removed;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += cards[i] + " ";
        }
        return result.trim();
    }
}
