package net.projecteuler.level003;

import net.projecteuler.utils.Utils;

/*
 * The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating
 * them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and
 * 1097 are prime. The sum of these four primes, 792, represents the lowest sum for a set of four
 * primes with this property.
 *
 * Find the lowest sum for a set of five primes for which any two primes concatenate to produce
 * another prime.
 */
public class Problem0060 {
  public static void main(String[] args) {

    Utils.time(Problem0060::first_try);

  }

  public static void first_try() {

    int limit = 1100;

    long[] primes = new long[limit];

    int index = 0;
    int n = 3;
    while (index < limit) {

      if (Utils.isPrime(n)) {
        primes[index] = n;
        index++;
      }

      n += 2;

      System.out.println(n + "," + index);
    }

    for (int a = 0; a < limit; a++) {

      for (int b = a + 1; b < limit; b++) {

        if (!isConPrimes(primes[a], primes[b])) {
          continue;
        }
        for (int c = b + 1; c < limit; c++) {
          if (!isConPrimes(primes[a], primes[c])
              || !isConPrimes(primes[b], primes[c])) {
            continue;
          }
          for (int d = c + 1; d < limit; d++) {
            if (!isConPrimes(primes[a], primes[d])
                || !isConPrimes(primes[b], primes[d])
                || !isConPrimes(primes[c], primes[d])) {

              continue;

            }

            for (int e = d + 1; e < limit; e++) {
              if (!isConPrimes(primes[a], primes[e])
                  || !isConPrimes(primes[b], primes[e])
                  || !isConPrimes(primes[c], primes[e])
                  || !isConPrimes(primes[d], primes[e])) {

                continue;

              }
              Utils.print_seq(new long[] { primes[a], primes[b], primes[c], primes[d], primes[e] });

              System.out.println(primes[a] + primes[b] + primes[c] + primes[d] + primes[e]);

              return;

            }
          }
        }
      }
    }

  }

  public static boolean isConPrimes(long a, long b) {

    return Utils.isPrime(Long.parseLong(a + "" + b))
        && Utils.isPrime(Long.parseLong(b + "" + a));
  }
}
