package net.projecteuler.level003;

import net.projecteuler.utils.Utils;

public class P0069_TotientMaximum {

	public static void main(String[] args) {
	
		// aim =  1000000
		int max = 1000;

		int nn = 0;
		float maxf = 0f;
		// n = 6; Relatively Prime = 1, 5; φ(n) = 2; n/φ(n) = 3;
		for(int n = 6; n <= max; n += 6) {
			int to = n/2;

			//System.out.print(n + ":");

			int cnt = 0;
			for(int i = 1; i <= to; i++) {
				
				if(i < n - i && Utils.gcd(i, n - i) == 0) {
					//System.out.print(i + " " + (n - i) + " ");
					cnt += 2;

				}
			}
			//System.out.println();
			if(cnt == 0) continue;
			float f = (float)n/cnt;
			if(maxf < f) {
				maxf = f;
				nn = n;
			}
			
			
		}

		System.out.println(nn + "," + maxf);




	}
}
