package com.pratice.dsa.array;

// find majority element in an array
// with the help of moore voting algorithm
public class MajorityEle {
	/*
	 * majority element is an element which appears more than N/2 times in an array
	 * is called majority element
	 * 
	 * I/p :{8,3,4,8,8} O/p: O or 3 or 4 (any index of 4)
	 * 
	 * I/p : {3,7,5,7,7,4} O/p : -1 no majoirty element
	 */

//	naive solution O(nsquare)
	static int findMajority(int arr[], int n) {

		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = i; j < n; j++)
				if (arr[j] == arr[i])
					count++;

			if (count > n / 2)
				return i;

		}

		return -1;
	}

// Eff solution 
	/*
	 * arr[] = {8,8,6,6,6,4,6} 0,1,2,3,4,5,6} Initially : count = 1,res = 0 i = 1,
	 * count =2; i=2 , count = 1; i=3,count=0, res = 3,count=1 i=4,count=2 i
	 * =5,count=1 I=6,count=2
	 */

	static int findMajorityEff(int arr[], int n) {
//		Find a candidate
		int res = 0;
		int count = 1;
		for (int i = 0; i < n; i++) {
			if (arr[i] == arr[res])
				count++;
			else
				count--;

			if (count == 0)
				res = i;
			count = 1;
		}
//  check if the candiate is actaully a majority
		count = 0;
		for (int i = 0; i < n; i++) 
			if (arr[res] == arr[i])
				count++;
		

		if (count <= n / 2)
			return arr[res];

		return res;
	}

	public static void main(String[] args) {

		int arr[] = { 8, 7, 6, 8, 6, 6, 6, 6 };
		System.out.println(findMajority(arr, arr.length));
		System.out.println(findMajorityEff(arr, arr.length));

	}

}
