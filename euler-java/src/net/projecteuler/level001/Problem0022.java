package net.projecteuler.level001;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.projecteuler.utils.Utils;

/*
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over
 * five-thousand first names, begin by sorting it into alphabetical order. Then working out the
 * alphabetical value for each name, multiply this value by its alphabetical position in the list to
 * obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 +
 * 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 */
public class Problem0022 {

  public static void main(String[] args) {
    Utils.time(Problem0022::first_try);
  }

  public static void first_try() {

    int diff = 1 - ('A');

    // System.out.println('A' + diff);

    String[] names = names();

    long total = 0;
    for (int i = 0; i < names.length; i++) {
      int sum = 0;
      for (int j = 0; j < names[i].length(); j++) {
        sum += names[i].charAt(j) + diff;
      }
      total += sum * (i + 1);
    }

    System.out.println(total);
  }

  public static String[] names() {

    String[] names = null;

    InputStream is = Problem0022.class.getClassLoader()
        .getResourceAsStream("net/projecteuler/res/p022_names.txt");

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

    names = new String[list.size()];

    for (int j = 0; j < list.size(); j++) {
      names[j] = list.get(j);
    }

    Arrays.sort(names);

    return names;
  }

}
