package net.projecteuler.level003;

import net.projecteuler.utils.Utils;
import java.util.ArrayList;

public class P0072_CountingFractions {

	public static void main(String[] args) {
		first_try();
	}

	public static void first_try() {
		int[] rp = new int[1_000_000];

		boolean[] primeChecker = Utils.primes_sieve(rp.length);
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i = 2; i < primeChecker.length; i ++) {
			if(primeChecker[i]) {
				primes.add(i);
			}
		}
		for(int i = 0; i < primes.size(); i ++) {
			int n = primes.get(i);
			rp[n] = n - 1;
			for(int j = i + 1; j < primes.size(); j ++) {
				int m = primes.get(j);
				if((long)n * m >= rp.length)
					continue;
				rp[n * m] = (n - 1) * (m - 1);
			}
		}
		int cnt = 0;
		for(int i = 2; i < rp.length; i ++) {
			if(rp[i] > 0)continue;
			cnt++;
		}
		System.out.println("" + cnt);

	}
	
}
