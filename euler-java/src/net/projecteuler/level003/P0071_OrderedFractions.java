package net.projecteuler.level003;

public class P0071_OrderedFractions {


	public static void main(String[] args) {

		//brute_force();
		solution();

		System.out.println((double)428570/999999 + "..." + (double)428570/999997);
	}

	public static void solution() {
		int n = 3, d = 7;
		int m = 1_000_000/d;
		n *= m;
		d *= m;
		System.out.println(n + "/" + d);
	}
	public static void brute_force() {

		int max_d = 1_000_000;

		int half_n = 3;
		int half_d = 7;

		int n = 2;
		int d = 5;

		System.out.println((double)3/7);
		System.out.println((double)2/5); // start
		System.out.println((double)5/12); // n * 2 + 1 / d * 2 + 2
		System.out.println((double)11/24); // n * 2 + 1 
		System.out.println((double)11/26);
		System.out.println((double)23/54);
		System.out.println((double)23/54);
		
		System.out.println("---");

		double a = (double)3/7;
		double max_f = (double)2/5;
		int max_n = 2;
		int max_dd = 5;
		//for(int x = 0; x < 100; x ++) {
		while(true) {

			while((double)n/d <= a) {
				n++;
			}
			while((double)n/d > a) {
				d++;
			}

			double f = (double)n/d;
			if(max_f < f && a > f) {
				max_f = (double)n/d;
				max_n = n;
				max_dd = d;
			}
			System.out.println(n + "/" + d + "=" + (double)n/d);
			if(d > max_d)break;
		}
		System.out.println(max_n + "/" + max_dd + "=" + max_f);

		for(int i = 2; i <= max_n; i++) {
			if(max_n % i == 0 && max_dd % i == 0) {
				max_n /= i;
				max_dd /= i;
				i--;
			} else {
				i++;
			}

		}

		
	}
}
