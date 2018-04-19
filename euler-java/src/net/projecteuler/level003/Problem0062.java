package net.projecteuler.level003;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.projecteuler.utils.Utils;

/*
 * The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and
 * 66430125 (405^3). In fact, 41063625 is the smallest cube which has exactly three permutations of
 * its digits which are also cube.
 *
 * Find the smallest cube for which exactly five permutations of its digits are cube.
 */
public class Problem0062 {

  public static void main(String[] args) {
    Utils.stopwatch(Problem0062::first_try);
  }

  public static void first_try() {

    Map<String, List<Integer>> map = new HashMap<>();

    for (int i = 10; i < 10000; i++) {

      BigInteger n = new BigInteger("" + i);

      BigInteger c = n.pow(3);

      char[] ordered = c.toString().toCharArray();
      Arrays.sort(ordered);

      String key = new String(ordered);

      List<Integer> list = map.get(key);

      if (list == null) {
        list = new ArrayList<>();
        map.put(key, list);
      }

      list.add(i);

      if (list.size() == 5) {

        BigInteger res = new BigInteger("" + list.get(0)).pow(3);
        System.out.println("result : " + res);
        break;

      }

    }

  }

}
