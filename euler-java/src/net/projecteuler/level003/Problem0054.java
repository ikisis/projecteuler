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
    String[][] hands = hands();

    for (int i = 0; i < hands.length; i++) {
      for (int j = 0; j < hands[i].length; j++) {
        System.out.print(hands[i][j]);
      }
      System.out.println();
    }

  }

  /*
   * High Card: Highest value card.
   * One Pair: Two cards of the same value.
   * 300 - Two Pairs: Two different pairs.
   * 400 - Three of a Kind: Three cards of the same value.
   * 500 - Straight: All cards are consecutive values.
   * 600 - Flush: All cards of the same suit.
   * 700 - Full House: Three of a kind and a pair.
   * 800 - Four of a Kind: Four cards of the same value.
   * 900 - Straight Flush: All cards are consecutive values of same suit.
   * 1000 - Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
   *
   * 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
   * 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
   */
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

  }

  static class Hand {

    public Card[] cards = new Card[5];
    public int highestCard = 0;

    private int index = 0;

    public void add(Card card) {
      cards[index] = card;
      index++;

      if (index == 5) {
        Arrays.sort(cards);
      }
    }

  }

  public static String[][] hands() {
    String[][] hands = null;

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

    hands = new String[rows.length][];

    System.out.println(rows.length);

    for (i = 0; i < rows.length; i++) {
      String[] pairOfHand = rows[i].split("[ ]");
      hands[i] = pairOfHand;
    }

    return hands;
  }
}
