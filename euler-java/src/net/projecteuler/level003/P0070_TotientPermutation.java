package net.projecteuler.level003;

import net.projecteuler.utils.Permutation;
import net.projecteuler.utils.Utils;
import java.util.ArrayList;
import net.projecteuler.utils.Totient;

public class P0070_TotientPermutation {

	public static void main(String[] args) {

		first_try();

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
