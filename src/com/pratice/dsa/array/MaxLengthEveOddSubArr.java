package com.pratice.dsa.array;
// find maximum lenth even off alternating sum
// based on kadane algortihm
public class MaxLengthEveOddSubArr {
	
	
//	My solution this is for the only max lenght of even or add not 
//	not for alternating
	static int maxEvenOdd(int arr[],int n) {
		int count = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2==0) {
				count++;
				max = Math.max(max, count);
			}
			else
				count=0;
		}
		return max;
	}
	
//	naive solution O(n2)
//	arr[] {5,10,20,6,3,8}
/*
 * i = 0; curr = 2;res = 2
 * i = 1; curr = 1
 * i = 2; curr = 1
 * i = 3; curr = 3,res = 3
 * i = 4; curr = 2
 * i = 5;: curr = 1
 * 
 */
	static int maxEvenOddNaive(int arr[],int n) {
		int res = 1;
		for (int i = 0; i < n; i++) {
			int curr = 1;
			for (int j = i+1; j < n; j++) {
				if((arr[j]%2==0 && arr[j-1]%2!=0) || 
						(arr[j]!=0 && arr[j-1]%2==0)) 
					curr++;
				else
					break;
		}
			res = Math.max(res, curr);
		
		}
		return res;
	}

/*
 * Eff O(n)
 * based on kadane algo
 * 
 */
	
	static int maxEvenOddEff(int arr[],int n) {
		int res = 1;
		int curr= 1;
		for (int i = 0; i < arr.length; i++) {
			if((arr[i]%2==0 && arr[i-1]%2!=0) || 
					(arr[i]!=0 && arr[i-1]%2==0)) {
				curr++; //like we are extending the subarray like kadane
				res = Math.max(curr, res);
			}
			else
				curr = 1;
		}
		return res;
	}
	
	
	
	
	public static void main(String[] args) {
		int arr[] = {5,10,20,6,3,8};
		System.out.println(maxEvenOdd(arr, arr.length));
		
	}

}
