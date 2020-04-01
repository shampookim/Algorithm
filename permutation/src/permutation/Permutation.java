package permutation;

import java.util.Arrays;

public class Permutation {
	static int N;
	static int[] arr;
	static int[] sel;
	static boolean[] visited;
	public static void main(String[] args) {
		
		N = 3;
		arr = new int[N];
		for (int i = 0; i <N; i++) {
			arr[i] = i+1;
		}
		
		System.out.print("array : ");
		System.out.println(Arrays.toString(arr));
		System.out.println();
		
		sel = new int[N];
		visited= new boolean[N];
		
//		permutation_visited_method(0);
//		re_permutation_visited_method(0);
//		permutation_swap_method(0);
		
		int[] test_array = {1,2,3,5,4};
		next_permutation(test_array);
	}

	
	private static void next_permutation(int[] test_array) {
		// TODO Auto-generated method stub
		int[] tmp_array = test_array.clone();
		
		int idx = 0;
		
		for (int i = 0; i < tmp_array.length; i++) {
			if(tmp_array[i] < tmp_array[i+1]) {
				idx = i;
			}
			else break;
		}
		if(idx == 0) return; 				//!!!!!!!!!!!!
		
		for (int i = tmp_array.length-1 ; i > idx; i--) {
			if(tmp_array[idx] < tmp_array[i]) {
				int tmp = tmp_array[idx];
				tmp_array[idx] = tmp_array[i];
				tmp_array[i] = tmp;
				break;
			}			
		}
		
		idx++;
		int toswap = tmp_array.length-1;
		
		while(idx < toswap) {
			int tmp = tmp_array[idx];
			tmp_array[idx] = tmp_array[toswap];
			tmp_array[toswap] = tmp;
			idx++;
			toswap--;
		}
		System.out.println("tmp_array: " + Arrays.toString(tmp_array));
		
	}


	private static void permutation_swap_method(int idx) {
		// TODO Auto-generated method stub
		if(idx == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for (int i = idx; i < N; i++) {
			swap(idx, i);
			permutation_swap_method(idx+1);
			swap(idx, i);
			
		}
	}
	private static void swap(int idx, int i) {
		// TODO Auto-generated method stub
		int tmp = arr[idx];
		arr[idx] = arr[i];
		arr[i] = tmp;
	}
	private static void re_permutation_visited_method(int idx) {
		// TODO Auto-generated method stub
		if(idx == N) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int j = 0; j < N; j++) {
			sel[idx] = arr[j];
			re_permutation_visited_method(idx+1);
		}
	}
	public static void permutation_visited_method(int idx) {
		// TODO Auto-generated method stub
		if(idx == N) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int j = 0; j < N; j++) {
			
			if(!visited[j]) {
				visited[j] = true;
				
				sel[idx] = arr[j];
				permutation_visited_method(idx+1);
				
				visited[j] = false;
			}
			
			
		}
	}
}
