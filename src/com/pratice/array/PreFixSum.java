package com.pratice.array;

public class PreFixSum {
	
	
//	naive solution 
//	      theta(r-l+1) or O(n)          O(1)Aux spac
	static int getSum(int arr[],int l,int r) {
		int res = 0;
		for(int i = l;i<=r;i++) {
			res += arr[i];
		}
		return res;
	}

	
//	idea
/*	arr = {2,8,3,9,6,5,4}
 * 1) precompute prefix Array
 * 		pSum= summation of arr[i]
 * 		pSum = [2,10,13,22,28,33,37]
 * 
 * 2) getSum(l,r) = { pSum[r] if l = 0,.
 * 					  pSum[r]- pSum[l-1] otherwise..
 * 
 * 	  getSum(1,3) = pSum(3)-pSum(0) = 20
 */
	
//	efficeint    
//	O(1) Time          Theta(n) Aux spac
	static int getSumEff(int arr[],int l,int r) {
//		if this is preproceesed then it is O(1)
		int[] pSum = preComputePrefixArray(arr);
		
		if (l ==0)
				return pSum[r];
		
		return pSum[r]-pSum[l-1];
	}

//	efficeint      theta(n)       
	private static int[] preComputePrefixArray(int[] arr) {
		int pSum[]=new int[arr.length];
		pSum[0] = arr[0];
		
		for(int i = 1;i<arr.length;i++) {
			pSum[i]= pSum[i-1]+arr[i];
		}
		return pSum;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {2,8,3,9,6,5,4};
		
//		Queries getSum(0,2), getSum(1,3), getSum(2,6)
//		op   13 20 27
		
		System.out.println(getSum(arr, 1, 3));
		System.out.println(getSumEff(arr, 1, 3));

		
	}

}
