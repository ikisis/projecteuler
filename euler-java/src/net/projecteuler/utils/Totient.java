package net.projecteuler.utils;

import java.util.Set;
import java.util.TreeSet;

public class Totient {

	public static void main(String[] args) throws Exception{
		for(int i = 2; i <= 500; i ++){
			int calc1 = calc(i);
			int calc2 = calc_slow(i);
			Set<Integer> pf = doPf(i);
			if(calc1 != calc2)
				System.out.println(i + "  : " + calc(i) + " -- " + doPf(i) + "-- " + calc_slow(i)); 
		}
		System.out.println(doPf(87109));
		int n = 87109;
		System.out.println(n + "  : " + calc(n) + " -- " + doPf(n) + "-- " + calc_slow(n)); 
		n = 8319823;
		System.out.println(n + "  : " + calc(n) + " -- " + doPf(n) + "-- " + calc_slow(n)); 
	}
	public static int brute_forced(int n) {

		System.out.print(n + "> ");
		int cnt = 0;
		for(int i = 1; i < n; i ++) {
			if(Utils.gcd(n, i) == 0) {
				System.out.print(i + " ");
				cnt++;
			}
		}

		return cnt;
	}
	
	public static int calc(int n) {
		Set<Integer> primes = doPf(n);

		int[] arr = new int[primes.size()];
		int i = 0;
		for(int p : primes) 
			arr[i++] = p;

		int cnt = n - 1;
		for(i = 0; i < arr.length; i ++) {
			cnt -= (n - 1) / arr[i] ;
			if(i < arr.length -1) {
				for(int j = i + 1; j < arr.length; j ++) {
					cnt += (n - 1) / (arr[i] * arr[j]);
				}
			}
		}

		return cnt;

	}

	public static int calc_slow(int n) {
		Set<Integer> primes = doPf(n);

		int cnt = 1;
		for(int i = 2; i < n; i ++) {
			boolean isRp = true;
			for(int p : primes) {
				if(i >= p && i % p == 0) 
					isRp = false;
			}
			if(isRp)
				cnt++;

		}

		return cnt;
	}

	public static Set<Integer> doPf(int n) {
		Set<Integer> primes = new TreeSet<>();

		int acc = n;

		for (int i = 2; i <= acc;) {
		  if (acc % i == 0) {
			acc = acc / i;
			primes.add(i);
		  } else {
			i++;
		  }
		}
		return primes;

	}
}
