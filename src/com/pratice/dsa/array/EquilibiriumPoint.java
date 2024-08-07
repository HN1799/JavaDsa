package com.pratice.dsa.array;
// based on prefix sum
public class EquilibiriumPoint {
//	sum of element before & sum of element after is same
/*
 *  I/p arr = [3,4,8,-9,20,6] O/p True    20
 *  I/p arr = [4,2,-2]    O/p True   4 before it is zero
 *  I/p arr = [4,2,,2]  O/p false
 */
	
	
//	naive solution    0(nsquare)        O(1)
//	first loop O(n) inner loop O(n)
	static boolean ePoint(int arr[],int n) {
		
		for(int i = 0;i<n;i++) {
			int ls = 0,rs = 0;
			
			for(int j= 0;j<i;j++) 
				ls += arr[j];
			
			for(int k = i+1;k<n;k++) 
				rs += arr[k];
			
			if(ls == rs)
				return true;
		}
		return false;
	}
	
//	efficeint solution 
/*
 * Idea
 * int arr [] = {3,4,8,-9,9,7};
 * 1) compute prefix sum array
 * 		ps [] = [3,7,15,6,15,22];
 * 2) compute suffix sum array
 * 		ss[] = [22,19,15,7,16,7]
 * 3)for every element except corner case
 * 		check if ps[i-1] is same as ss[i+1]
 * 	 for coner cases 
 * 		left coner most element ss[i+1] is zero or not
 * 		right corner we check if ps[i-1] is zero or not
 * 
 * this require 3 traversal of the code 
 * 
 * Optimizated to 2 traversal
 * Idea 
 * 	compute the total sum. traverse the element to left to right 
 * and we get the prefix sum in a single variable and suffix sum by subtracting the elemtnt
 *  
 */
	
	static boolean ePointEff(int arr[],int n) {
		int rs = 0;
		for(int i = 0;i<n;i++) 
			rs += arr[i];
		
		int ls = 0;
		for(int i = 0;i<n;i++) {
			rs -= arr[i];
			if(ls==rs)
				return true;
			ls +=arr[i];
		}
		
		
		return false;
	}
	
	
	public static void main(String[] args) {
		int arr [] = {3,4,8,-9,9,7};
		System.out.println(ePoint(arr, arr.length));
		System.out.println(ePointEff(arr, arr.length));

		
		
	}
	
	
	
/*
 * left sum of the first element in the array is zero
 * 
 * int arr [] = {3,4,8,-9,9,7};
 * rs = 22, ls = 0
 * i = 0, ls = 0, rs = 19
 * i = 1, ls = 3, rs = 15
 * i = 2, ls = 7, rs = 7
 * return true;
 * 
 *    
 */

}
