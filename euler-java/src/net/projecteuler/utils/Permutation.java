package net.projecteuler.utils;

import java.util.function.Consumer;

public class Permutation {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		make(arr, 3, seq -> {
			printArray(seq);
		});
		System.out.println(isPermutation(87109, 79180));
	}
	
	public static boolean isPermutation(int n1, int n2) {
		int[] n1_used = new int[10];
		int[] n2_used = new int[10];

		while(n1 > 1) {
			n1_used[n1 % 10]++;
			n1 /= 10;
		}

		while(n2 > 1) {
			n2_used[n2 % 10]++;
			n2 /= 10;
		}
		
		for(int i = 0; i < 10; i ++) {
			if(n1_used[i] != n2_used[i])
				return false;
		}
		return true;
	}

	public static void make(int[] arr, int length, Consumer<int[]> consumer) {

		make(arr, new boolean[arr.length], new int[length], 0, consumer); 

	}	

	public static void make(int[] arr, boolean[] used, int[] seq, int index, Consumer<int[]> consumer) {


		if(seq.length  == index) {
			consumer.accept(seq);
			return;
		}


		for(int i = 0; i < arr.length; i ++) {
			if(!used[i]) {
				seq[index] = arr[i];
				used[i] = true;
				make(arr, used, seq, index + 1, consumer);
				used[i] = false;
			}
		}


	}

	public static void printArray(int[] arr) {
		System.out.print("arr : ");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
