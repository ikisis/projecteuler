package net.projecteuler.level003;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import net.projecteuler.utils.Utils;

/*
 * Triangle, square, pentagonal, hexagonal, heptagonal, and octagonal numbers are all figurate
 * (polygonal) numbers and are generated by the following formulae:
 *
 * Triangle P3,n=n(n+1)/2 1, 3, 6, 10, 15, ...
 * Square P4,n=n2 1, 4, 9, 16, 25, ...
 * Pentagonal P5,n=n(3n−1)/2 1, 5, 12, 22, 35, ...
 * Hexagonal P6,n=n(2n−1) 1, 6, 15, 28, 45, ...
 * Heptagonal P7,n=n(5n−3)/2 1, 7, 18, 34, 55, ...
 * Octagonal P8,n=n(3n−2) 1, 8, 21, 40, 65, ...
 * The ordered set of three 4-digit numbers: 8128, 2882, 8281, has three interesting properties.
 *
 * The set is cyclic, in that the last two digits of each number is the first two digits of the next
 * number (including the last number with the first).
 * Each polygonal type: triangle (P3,127=8128), square (P4,91=8281), and pentagonal (P5,44=2882), is
 * represented by a different number in the set.
 * This is the only set of 4-digit numbers with this property.
 * Find the sum of the only ordered set of six cyclic 4-digit numbers for which each polygonal type:
 * triangle, square, pentagonal, hexagonal, heptagonal, and octagonal, is represented by a different
 * number in the set.
 */
public class Problem0061_ {

  public static void main(String[] args) {

    Utils.time(Problem0061_::first_try);

  }

  public static void first_try() {

    int limit = 10000;

    boolean[][] polys = polys();

    Map<Integer, List<Integer>> polyMap = new LinkedHashMap<>();

    for (int i = 1000; i < limit; i++) {

      for (int j = 0; j < polys.length; j++) {

        if (polys[j][i]) {

          List<Integer> list = polyMap.get(i);

          if (list == null) {
            list = new ArrayList<>();

            polyMap.put(i, list);
          }

          list.add(j);

        }

      }

    }

    // System.out.println(polyMap);
    // System.out.println(polyMap.size());

    Map<Integer, List<Integer>> map =
        polyMap.entrySet().stream().filter(e -> e.getValue().size() > 1)
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

    // System.out.println(map);

//    rec(0, Collections.unmodifiableMap(polyMap), 6);

    solve(polyMap);

  }

  public static Map<Integer, List<Integer>> nextMap(Integer key, Integer poly,
      Map<Integer, List<Integer>> map) {

    return new HashMap<>(map).entrySet().stream().map(map2e -> {

      List<Integer> list = new ArrayList<>(map2e.getValue());

      list.remove(poly);

      return new AbstractMap.SimpleEntry<Integer, List<Integer>>(map2e.getKey(), list);

    }).filter(e2 -> e2.getValue().size() > 0 && !e2.getKey().equals(key))
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
  }

  public static void solve(Map<Integer, List<Integer>> map) {

    map.forEach((key, value) -> {
      Integer a = key / 100;
      Integer b = key % 100;

      value.forEach(poly -> {

        Map<Integer, List<Integer>> map2 = nextMap(key, poly, map);

        map2.entrySet().stream()
            .filter(map2e -> (new Integer(map2e.getKey() / 100)).equals(b))
            .forEach(map2e -> {
              map2e.getValue().forEach(poly2 -> {

                Integer b2 = map2e.getKey() % 100;

                Map<Integer, List<Integer>> map3 = nextMap(map2e.getKey(), poly2, map2);

                map3.entrySet().stream()
                    .filter(map3e -> (new Integer(map3e.getKey() / 100)).equals(b2))
                    .forEach(map3e -> {
                      map3e.getValue().forEach(poly3 -> {

                        Integer b3 = map3e.getKey() % 100;

                        Map<Integer, List<Integer>> map4 = nextMap(map2e.getKey(), poly3, map3);

                        map4.entrySet().stream()
                            .filter(map4e -> (new Integer(map4e.getKey() / 100)).equals(b3))
                            .forEach(map4e -> {
                              map4e.getValue().forEach(poly4 -> {

                                Integer b4 = map4e.getKey() % 100;

                                Map<Integer, List<Integer>> map5 =
                                    nextMap(map2e.getKey(), poly4, map4);

                                map5.entrySet().stream()
                                    .filter(map5e -> (new Integer(map5e.getKey() / 100)).equals(b4))
                                    .forEach(map5e -> {
                                      map5e.getValue().forEach(poly5 -> {

                                        Integer b5 = map5e.getKey() % 100;

                                        Map<Integer, List<Integer>> map6 =
                                            nextMap(map2e.getKey(), poly5, map5);

                                        map6.entrySet().stream()
                                            .filter(map6e -> (new Integer(map6e.getKey() / 100))
                                                .equals(b5))
                                            .forEach(map6e -> {

                                              map6e.getValue().forEach(poly6 -> {
                                                Integer b6 = map6e.getKey() % 100;

                                                if (b6 == a) {
                                                  System.out.println(key + ":" + poly + ", "
                                                      + map2e.getKey() + ":" + poly2
                                                      + ", " + map3e.getKey() + ":" + poly3 + ", "
                                                      + map4e.getKey() + ":" + poly4 + ", "
                                                      + map5e.getKey() + ":" + poly5 + ", "
                                                      + map6e.getKey() + ":" + poly6);

                                                  System.out.println(key + map2e.getKey()
                                                      + map3e.getKey() + map4e.getKey()
                                                      + map5e.getKey() + map6e.getKey());
                                                }
                                              });

                                            });

                                      });

                                    });

                              });

                            });

                      });

                    });

              });

            });

      });

    });

  }

  public static void rec(Integer before, Map<Integer, List<Integer>> map, int process) {
//    System.out.println(before);
//
//    System.out.println(map);
    if (process == 0) {
      System.out.println(before);
      System.out.println(map.size());
      System.out.println(map);
      return;

    }

    map.entrySet().forEach(e -> {

      e.getValue().forEach(e0 -> {

        Integer b = e.getKey() % 100;

        Map<Integer, List<Integer>> newMap = map.entrySet().stream().map(e1 -> {

          List<Integer> list = new ArrayList<>(e1.getValue());

          list.remove(e0);

          return new AbstractMap.SimpleEntry<Integer, List<Integer>>(e1.getKey(), list);

        }).filter(e2 -> e2.getValue().size() > 0)
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        newMap.entrySet().stream().filter(e2 -> (new Integer(e2.getKey() / 100)).equals(b))
            .forEach(e2 -> {

              rec(e2.getKey(), newMap, process - 1);

            });

      });

    });

  }

  public static boolean[][] polys() {
    int limit = 10000;
    boolean[] triangle = new boolean[limit],
        square = new boolean[limit],
        pentagonal = new boolean[limit],
        hexagonal = new boolean[limit],
        heptagonal = new boolean[limit],
        octagonal = new boolean[limit];

    for (int n = 1; n < limit; n++) {

      // Triangle P3,n=n(n+1)/2
      int t = n * (n + 1) / 2;
      if (t < limit) {
        triangle[t] = true;
      }

      // square P4,n=n2
      int s = n * n;
      if (s < limit) {
        square[s] = true;
      }

      // Pentagonal P5,n=n(3n−1)/2
      int p = n * (3 * n - 1) / 2;
      if (p < limit) {
        pentagonal[p] = true;
      }

      // Hexagonal P6,n=n(2n−1)
      int hex = n * (2 * n - 1);
      if (hex < limit) {
        hexagonal[hex] = true;
      }

      // Heptagonal P7,n=n(5n−3)/2
      int hep = n * (5 * n - 3) / 2;
      if (hep < limit) {
        heptagonal[hep] = true;
      }

      // Octagonal P8,n=n(3n−2)
      int o = n * (3 * n - 2);
      if (o < limit) {
        octagonal[o] = true;
      }
    }

    // triangle, square, pentagonal, hexagonal, heptagonal, and octagonal
    return new boolean[][] { triangle, square, pentagonal, hexagonal, heptagonal, octagonal };
//    return new boolean[][] { triangle, square, pentagonal };

  }

}
