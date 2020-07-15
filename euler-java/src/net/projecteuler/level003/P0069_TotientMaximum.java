package net.projecteuler.level003;

import net.projecteuler.utils.Utils;

public class P0069_TotientMaximum {

	public static void main(String[] args) {
		solution();
	
	}

	public static void solution() {
		
		// aim =  1000000
		int max = 1000000;

		boolean[] isPrime = Utils.primes_sieve(max);

		int n = 1;

		int i = 2;

		while(n * i <= max) {
			if(isPrime[i]) {
				n = n * i;
			}
			i ++;
		}
		System.out.println("ans : " + n);
		
	}

	public static void first_try() {
		// aim =  1000000
		int max = 42;

		int nn = 0;

		float[] checked = new float[max + 1];

		boolean[] isPrime = Utils.primes_sieve(max);

		// calc primes first
		for(int n = 3; n <= max; n += 2) {
			if(checked[n] > 0)
				continue;

			if(isPrime[n]) {
				checked[n] = (float)n/(n - 1);
				float doubled = checked[n] * 2;
				for(int i = n * 2; i <= max; i *= 2) {
					checked[i] = doubled;
				}
			}
		}	

		int found_n = 0;
		float max_f = 0;

		for(int n = 2; n <= max; n += 1) {
//			if(checked[n] > 0)
//				continue;
			int rp = 1;
			for(int i = 2; i < n; i ++) {
				if(Utils.gcd(i, n) == 0)
					rp++;
			}
			checked[n] = (float)n/rp;
			for(int i = n * 2; i <= max; i *=2){
				checked[i] = checked[n];
			}
		}

		int calculated = 0;
		for(int n = 2; n <= max; n ++){
			System.out.println(n + " > " + checked[n]);
			
			if(checked[n] > max_f) {
				found_n = n;
				max_f = checked[n];
			}

			if(checked[n] > 0)
				calculated ++;
		}
		System.out.println(calculated);
		System.out.println(found_n + " > " + max_f);

		

	}
}
