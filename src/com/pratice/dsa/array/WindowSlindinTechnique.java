package com.pratice.dsa.array;
// find the maximum sum of k consequitve element
public class WindowSlindinTechnique {

//	naive solution   O(n*k)     O(1) Aux space
	static int maxSum(int arr[],int n,int k) {
		int res = Integer.MIN_VALUE;
		for (int i = 0; i+k-1 < n; i++) {
			int curr=0;
			for (int j = 0; j<k ; j++) 
				curr += arr[j+i];
			
		res = Math.max(res, curr);
		}
		return res;
	}
	
//	Time theta(n)          O(1) aux space
/*
 * Windows Sliding technique
 * compute sum of current window using the sum of previous window in O(1) time
 * {1,8,30,-5,-20,7};
 * intially curr= 1+8+30-5 = 34, res = 34
 * 1st slide: curr = 34+20-1 = 53, res = 53
 * 20 is the Adding the last of the current video
 * -1 is removing First of Previous window
 * 
 * Similarly, curr = 53+7-8 = 52, res = 53
 */
	static int maxSumEff(int arr[],int n,int k) {
		int curr = 0;
		for (int i = 0; i < k; i++) 
			curr+=arr[i];
		int res = curr;
		for (int i = k; i < n; i++) {
			curr = curr+ arr[i]+ arr[i-k];
			res = Math.max(res, curr);
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {
		
		int arr []= {1,8,30,-5,-20,7};
		System.out.println(maxSum(arr, arr.length, 4));
		System.out.println(maxSumEff(arr, arr.length, 4));

		}
		
	}
	

