package com.pratice.dsa.array;

public class MaxSumSubArray {
	
//	 naaive O(n2)
	static int maxSum(int arr[],int n) {
		int res = arr[0];
		for (int i = 0; i < n; i++) {
			int curr = 0;
			for (int j = i; j < n; j++) {
				curr = curr + arr[j];
				res = Math.max(curr, res);
			}
		}
		return res;
	}
	
/*Efficient solution
 * maxEnding(i) = max(maxEnding(i-1)+ arr[i],arr[i]);
 * 
 * { -5 , 1 , -2 , 3 , -1 , 2 , -2}
 *   -5   1    -1  3    2   4    2
 *   result is 2
 *   
 *   idea is the extend the previous sub array or start the 
 *   new one. 
 *   if you have to find the maxium ending with the current ele
 *   you have to go the previous element and you already 
 *   caluclated the max of previous element
 * 
 */
	
	static int maxSumEff(int arr[],int n) {
		int res = arr[0];
		int maxEnding = arr[0];
		for (int i = 0; i < n; i++) {
			maxEnding = Math.max(maxEnding+arr[i], arr[i]);
			res = Math.max(maxEnding, res);
		}
		return res;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int arr[] = { -5 , 1 , -2 , 3 , -1 , 2 , -2};
		System.out.println(maxSum(arr, arr.length));
		System.out.println(maxSumEff(arr, arr.length));
	}

	
//	maximum sum of subarray of all positive is total sum
	
}
