package net.projecteuler.level003;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import net.projecteuler.level001.Problem0022;

/*
 * In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in
 * the following way:
 *
 * High Card: Highest value card.
 * One Pair: Two cards of the same value.
 * Two Pairs: Two different pairs.
 * Three of a Kind: Three cards of the same value.
 * Straight: All cards are consecutive values.
 * Flush: All cards of the same suit.
 * Full House: Three of a kind and a pair.
 * Four of a Kind: Four cards of the same value.
 * Straight Flush: All cards are consecutive values of same suit.
 * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
 * The cards are valued in the order:
 * 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 *
 * If two players have the same ranked hands then the rank made up of the highest value wins; for
 * example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for
 * example, both players have a pair of queens, then highest cards in each hand are compared (see
 * example 4 below); if the highest cards tie then the next highest cards are compared, and so on.
 *
 * Consider the following five hands dealt to two players:
 *
 * Hand Player 1 Player 2 Winner
 * 1 5H 5C 6S 7S KD
 * Pair of Fives
 * 2C 3S 8S 8D TD
 * Pair of Eights
 * Player 2
 * 2 5D 8C 9S JS AC
 * Highest card Ace
 * 2C 5C 7D 8S QH
 * Highest card Queen
 * Player 1
 * 3 2D 9C AS AH AC
 * Three Aces
 * 3D 6D 7D TD QD
 * Flush with Diamonds
 * Player 2
 * 4 4D 6S 9H QH QC
 * Pair of Queens
 * Highest card Nine
 * 3D 6D 7H QD QS
 * Pair of Queens
 * Highest card Seven
 * Player 1
 * 5 2H 2D 4C 4D 4S
 * Full House
 * With Three Fours
 * 3C 3D 3S 9S 9D
 * Full House
 * with Three Threes
 * Player 1
 * The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the
 * file contains ten cards (separated by a single space): the first five are Player 1's cards and
 * the last five are Player 2's cards. You can assume that all hands are valid (no invalid
 * characters or repeated cards), each player's hand is in no specific order, and in each hand there
 * is a clear winner.
 *
 * How many hands does Player 1 win?
 */
public class Problem0054 {

  public static void main(String[] args) {
    Hand[][] hands = hands();

    int count = 0;
    for (int i = 0; i < hands.length; i++) {

      if (hands[i][0].compareTo(hands[i][1]) == 1) {

        count++;
        for (int j = 0; j < hands[i].length; j++) {
          System.out.print(hands[i][j] + ", ");
        }
        System.out.println();
      }

    }

    System.out.println("res : " + count);
    // 362?

  }

  public static int judge(int[] hand) {

    return 0;
  }

  static class Card implements Comparable<Card> {
    public Integer number;
    public String suit;

    /*
     * 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
     * 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
     */
    Card(String cardExp) {

      if (cardExp.charAt(0) == 'T') {
        number = 10;
      }

      switch (cardExp.charAt(0)) {
        case 'T':
          number = 10;
          break;
        case 'J':
          number = 11;
          break;
        case 'Q':
          number = 12;
          break;
        case 'K':
          number = 13;
          break;
        case 'A':
          number = 14;
          break;
        default:
          number = Integer.parseInt("" + cardExp.charAt(0));
          break;
      }

      this.suit = "" + cardExp.charAt(1);

    }

    @Override
    public int compareTo(Card o) {
      return number.compareTo(o.number);
    }

    @Override
    public String toString() {

      return String.format("[ %2d %s ]", number, suit);

    }

  }

  static class Hand implements Comparable<Hand> {

    public Card[] cards = new Card[5];
    public int highestCard = 0;

    public Integer value = 0;

    private int index = 0;

    public void add(Card card) {
      cards[index] = card;
      index++;

      if (index == 5) {
        Arrays.sort(cards);

        int consecutive = 0;
        int same_suite = 0;

        int same_value = 0;

        int pair = 0;
        int three_of_kind = 0;
        int four_of_kind = 0;

        int highest_value = 0;

        for (int i = 0; i < cards.length - 1; i++) {
          if ((cards[i].number + 1) == cards[i + 1].number) {
            consecutive++;
          } else {
            consecutive = 0;
          }

          if ((cards[i].suit) == cards[i + 1].suit) {
            same_suite++;
          } else {

          }

          if ((cards[i].number) == cards[i + 1].number) {
            same_value++;
            if (same_value == 1) {
              pair++;
            } else if (same_value == 2) {
              pair--;
              three_of_kind++;
            } else if (same_value == 3) {
              three_of_kind--;
              four_of_kind++;
            }
            if (cards[i + 1].number > highest_value) {
              highest_value = cards[i + 1].number;
            }
          } else {
            same_value = 0;
          }
        }

        if (consecutive == 4 && same_suite == 4) {
          if (cards[4].number == 14) {
            value = 1000;
          } else {
            value = 900 + cards[4].number;
          }

          return;// royal flush, straight flush
        }

        if (four_of_kind > 0) {
          value = 800 + highest_value;
          return; // Four of a Kind
        }

        if (three_of_kind > 0 && pair > 0) {
          value = 700 + highest_value;
          return; // Full House
        }

        if (same_suite == 4) {
          value = 600 + cards[4].number;
          return; // flush
        }

        if (consecutive == 4) {
          value = 500 + cards[4].number;
          return; // straight
        }

        if (three_of_kind > 0) {
          value = 400 + highest_value;
          return; // Three of a Kind
        }

        if (pair == 2) {
          value = 300 + highest_value;
          return; // two pair
        }

        if (pair == 1) {
          value = 200 + highest_value;
          return; // one pair
        }

        value = 100 + cards[4].number;

      }
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("{");

      for (int i = 0; i < cards.length; i++) {
        sb.append(cards[i].toString());
      }

      sb.append(" <" + value + "> }");

      return sb.toString();
    }

    @Override
    public int compareTo(Hand o) {

      return this.value.compareTo(o.value);
    }

  }

  public static Hand[][] hands() {
    Hand[][] hands = null;

    InputStream is = Problem0022.class.getClassLoader()
        .getResourceAsStream("net/projecteuler/res/p054_poker.txt");

    InputStreamReader isr = new InputStreamReader(is);

    int i = 0;
    StringBuilder sb = new StringBuilder();
    try {
      while ((i = isr.read()) != -1) {
        sb.append((char) i);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    String[] rows = sb.toString().split("[\n]");

    hands = new Hand[rows.length][2];

    System.out.println(rows.length);

    for (i = 0; i < rows.length; i++) {
      String[] pairOfHand = rows[i].split("[ ]");

      Hand a = new Hand();

      for (int j = 0; j < 5; j++) {
        a.add(new Card(pairOfHand[j]));
      }

      Hand b = new Hand();

      for (int j = 5; j < 10; j++) {
        b.add(new Card(pairOfHand[j]));
      }

      hands[i] = new Hand[] { a, b };
    }

    return hands;
  }
}
