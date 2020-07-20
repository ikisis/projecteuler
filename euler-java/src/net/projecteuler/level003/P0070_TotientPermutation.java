package net.projecteuler.level003;

import net.projecteuler.utils.Permutation;
import net.projecteuler.utils.Utils;
import java.util.ArrayList;
import net.projecteuler.utils.Totient;

public class P0070_TotientPermutation {

	public static void main(String[] args) {

		//first_try();
		solution();

	}

	public static void solution() {

		int max = 10000;
		boolean[] primesSieve = Utils.primes_sieve(max);

		ArrayList<Integer> primes = new ArrayList();
		for(int i = 2; i < max; i ++) {
			if(primesSieve[i])
				primes.add(i);
		}
		
		int nMax = 10_000_000;

		System.out.println(primes.size());
		int minN = 0;
		double min = 100d;
		for(int i = 0; i < primes.size() - 1; i++){
			for(int j = i + 1; j < primes.size(); j++) {
				int n = primes.get(i) * primes.get(j);
				if(nMax < n)break;
				int phi = (primes.get(i) - 1) * (primes.get(j) - 1); 
				if(Permutation.isPermutation(n, phi)) {
				double ratio = (double)n/phi;
						if(ratio < min) {
						minN = n;
						min = ratio;
					}
				}

			}
		}
		System.out.println(minN + "  >  " + min + " --- " + Totient.doPf(minN));
	}

	public static void first_try() {

		int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

		int max = 9876543;

//		boolean[] isPrime = Utils.primes_sieve(max);

		ArrayList<Integer> perm = new ArrayList<>();
		Permutation.make(digits, 7, seq -> {
			int num = 0, digit = 1;
			
			for(int i = 0; i < 7; i ++)  {
				num += seq[i] * digit;	
				digit *= 10;
			}

			if(Utils.isPrime(num)) {
				return;
			}
			
			perm.add(num);
			
		});
		//604800
		//565805

		for(int i = 0; i < perm.size();i ++ ) {
			Totient.calc(perm.get(i));
			if(i % 1000 == 0) {
				System.out.println(i);
			}
		}
		
	}
}
