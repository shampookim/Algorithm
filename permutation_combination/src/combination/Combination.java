package combination;

import java.util.Arrays;

public class Combination {
	static int N;
	static  int R;
	
	static int[] arr;
	static int[] sel;
	public static void main(String[] args) {
		N = 5;
		R = 3;
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		sel = new int[R];
		
		combination(0,0);
	}
	private static void combination(int idx, int s_idx) {
		// TODO Auto-generated method stub
		
		if(s_idx == R) {
			System.out.println(Arrays.toString(sel));
			return; 
		}
		if(idx == N) return;
		
		sel[s_idx] = arr[idx];
		combination(idx+1, s_idx+1);
		combination(idx+1, s_idx);
		
	}
}
