package net.projecteuler.level002;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import net.projecteuler.level001.Problem0022;
import net.projecteuler.utils.Utils;

/*
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten
 * triangle numbers are:
 *
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * By converting each letter in a word to a number corresponding to its alphabetical position and
 * adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 =
 * 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.
 *
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly
 * two-thousand common English words, how many are triangle words?
 */
public class Problem0042 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0042::first_try);

  }

  public static void first_try() {

    String[] words = words();

    int max = 0;

    int[] word_values = new int[words.length];
    int diff = 1 - ('A');

    for (int i = 0; i < words.length; i++) {
      int sum = 0;
      for (int j = 0; j < words[i].length(); j++) {
        sum += words[i].charAt(j) + diff;
      }
      word_values[i] = sum;
      if (sum > max) {
        max = sum;
      }
    }

    System.out.println(max);

    boolean[] triangles = new boolean[max + 1];
    int n = 1;
    int t = 1;
    while (t < max + 1) {

      triangles[t] = true;
      System.out.println(t);
      n++;
      t = n * (n + 1) / 2;
    }

    int count = 0;

    for (int i = 0; i < word_values.length; i++) {
      if (triangles[word_values[i]]) {
        count++;
      }
    }

    System.out.println("result : " + count);

  }

  public static String[] words() {

    String[] words = null;

    InputStream is = Problem0022.class.getClassLoader()
        .getResourceAsStream("net/projecteuler/res/p042_words.txt");

    InputStreamReader isr = new InputStreamReader(is);

    List<String> list = new ArrayList<>();
    int i = 0;
    try {
      int status = 0;
      StringBuilder sb = new StringBuilder();

      while ((i = isr.read()) != -1) {
        char c = (char) i;
        switch (status) {
          case 0:
            if (c == '"') {
              status = 1;
            }
            break;
          case 1:
            if (c == '"') {
              status = 0;
              list.add(sb.toString());
              sb = new StringBuilder();
            } else {
              sb.append(c);
            }
            break;
          default:
            break;
        }
      }
    } catch (IOException e) {
      // ignored
    }

    words = new String[list.size()];

    for (int j = 0; j < list.size(); j++) {
      words[j] = list.get(j);
    }

//    Arrays.sort(words);

    return words;
  }

}
