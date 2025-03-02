import java.util.*;

class Card {
    String symbol;
    String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public void display() {
        System.out.println(value + " of " + symbol);
    }
}

public class CardCollection {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        deck.add(new Card("Hearts", "Ace"));
        deck.add(new Card("Spades", "King"));
        deck.add(new Card("Diamonds", "Queen"));
        deck.add(new Card("Clubs", "Jack"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter symbol to search: ");
        String searchSymbol = scanner.nextLine();
        
        for (Card c : deck) {
            if (c.symbol.equalsIgnoreCase(searchSymbol)) {
                c.display();
            }
        }
    }
}
