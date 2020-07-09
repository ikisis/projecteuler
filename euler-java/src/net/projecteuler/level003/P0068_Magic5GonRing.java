package net.projecteuler.level003;

import net.projecteuler.utils.Permutation;
import net.projecteuler.utils.Utils;

public class P0068_Magic5GonRing {

	public static void main(String[] args) {

		Utils.time(P0068_Magic5GonRing::brute_forced);
		

	}

	public static void brute_forced() {

		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		Permutation.make(nums, nums.length, seq -> {

			if(seq[5] == 10 || seq[6] == 10 || seq[7] == 10 || seq[8] == 10 || seq[9] == 10) {
				return;
			}

			int sum = 0;
			boolean sameAll = true;
			int minIndex = 0;
			int minA = 1098; 
			for(int i = 0; i < 5; i++) {
				int a = seq[i];
				int b = seq[i + 5];
				int c = 0;
				if(i < 4) {
					c = seq[i + 6];
				} else {
					c = seq[5];
				}
				if(sum > 0 && sum != a + b + c) {
					sameAll = false;
					break;
				}
				int aa = a * 100 + b * 10 + c;
				if(minA > aa) {
					minA = aa;
					minIndex = i;
				}
				sum = a + b + c;
			}
			
			if(sameAll && minA == 653) {
				System.out.print(minA + "> ");
				for(int i = 0 ; i < 5; i ++) {
					int a = seq[i];
					int b = seq[i + 5];
					int c = 0;
					if(i < 4) {
						c = seq[i + 6];
					} else {
						c = seq[5];
					}
					System.out.print("[" + a + " " + b + " " + c + "]");
				}
				System.out.println();
			}

		});

	}
}

