import java.util.*;

class Card {
    String name;
    String suit;

    public Card(String name, String suit) {
        this.name = name;
        this.suit = suit;
    }

    public int getValue() {
        if (name.equals("Ace")) return 11;
        if (name.equals("King") || name.equals("Queen") || name.equals("Jack")) return 10;
        return Integer.parseInt(name);
    }

    public String toString() {
        return name + " of " + suit;
    }
}

class Deck {
    ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] names = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        for (String suit : suits) {
            for (String name : names) {
                cards.add(new Card(name, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        return cards.remove(0);
    }
}

class Player {
    String name;
    int bankroll;
    ArrayList<Card> hand = new ArrayList<>();

    public Player(String name, int bankroll) {
        this.name = name;
        this.bankroll = bankroll;
    }

    public void addCard(Card c) {
        hand.add(c);
    }

    public void clearHand() {
        hand.clear();
    }

    public int handValue() {
        int value = 0;
        int aces = 0;

        for (Card c : hand) {
            value += c.getValue();
            if (c.name.equals("Ace")) aces++;
        }

        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        return value;
    }
}

class Dealer extends Player {
    public Dealer(String name) {
        super(name, 0);
    }
}

public class Blackjack {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Player user = new Player("player", 500);
        Dealer dealer = new Dealer("dealer");

        while (user.bankroll > 0) {
            Deck deck = new Deck();
            deck.shuffle();
            user.clearHand();
            dealer.clearHand();

            System.out.println("bankroll: " + user.bankroll);
            System.out.print("place your bet (0 to quit): ");
            int bet = sc.nextInt();
            if (bet == 0) break;
            if (bet > user.bankroll) {
                System.out.println("not enough money, enter different amount.");
                continue;
            }

            user.addCard(deck.deal());
            user.addCard(deck.deal());
            dealer.addCard(deck.deal());
            dealer.addCard(deck.deal());

            System.out.println("your hand: " + user.hand + " (" + user.handValue() + ")");
            System.out.println("dealer shows: " + dealer.hand.get(0));

            while (user.handValue() < 21) {
                System.out.print("choose to hit or stand: ");
                String choice = sc.next();
                if (choice.equalsIgnoreCase("h")) {
                    user.addCard(deck.deal());
                    System.out.println("your hand: " + user.hand + " (" + user.handValue() + ")");
                } else break;
            }

            int userTotal = user.handValue();
            if (userTotal > 21) {
                System.out.println("bust! play again!");
                user.bankroll -= bet;
                continue;
            }

            while (dealer.handValue() < 17) {
                dealer.addCard(deck.deal());
            }

            int dealerTotal = dealer.handValue();
            System.out.println("dealer's hand: " + dealer.hand + " (" + dealerTotal + ")");

            if (dealerTotal > 21 || userTotal > dealerTotal) {
                System.out.println("you got the dub!!");
                user.bankroll += bet;
            } else if (userTotal < dealerTotal) {
                System.out.println("dealer wins.");
                user.bankroll -= bet;
            } else {
                System.out.println("push");
            }
        }

        System.out.println("game ends, final bankroll is " + user.bankroll);
    }
}
