package com.pratice.dsa.array;

// using window sliding technique
public class SubArrWthGivSum {
	
	
//	naive solution   Time O(nsquare)   Aux Space O(1)
	static boolean isSubSum(int arr[],int n, int sum) {
		for (int i = 0; i < n; i++) {
			int curr = 0;
			for (int j = i; j < n; j++) {
				curr+=arr[j];
				if(curr==sum)
					return true;
			}
			
		}
		
		return false;
	}
	
//	Idea: we use window sliding technique with variaable size
/*	Time O(n) Aux space O(1)
 * it is not quadratic becaue loop takes O(n) time and in the while loop
 * we are dooing subraction and in for loop adding which is in contant time 
 * {1,4,20,3,10,5}; sum = 33
 * while curr is smaller than the sum, extend the window by increasing by e
 * s=0, e=0, curr=1
 * s=0, e=1, curr=5
 * s=0, e=2, curr=25
 * s=0, e=3, curr=28
 * s=0, e=4, curr=38
 * while curr is  greater, shrink the video by removing by increasing the strating 
 * point or removing the starting of the window
 * s=1, e=4, curr=37
 * s=2, e=4, curr=33
 * 
 * here the array is non negative and we have to find sum of consequitve sum
 *   
 */
	
	static boolean isSubSumEff(int arr[],int n, int sum) {
		int s = 0;
		int curr= 0;
		for (int e = 0; e < n; e++) {
			curr+=arr[e];
			while(sum<curr) {
				curr-=arr[s];
				s++;
			}
		if(curr==sum)
			return true;
		}
		return false;
	}

	
	public static void main(String[] args) {
		int arr[] = {1,4,20,3,10,5};
		System.out.println(isSubSum(arr, arr.length, 33));
	}
}
