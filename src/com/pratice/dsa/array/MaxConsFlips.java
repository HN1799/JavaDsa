package com.pratice.dsa.array;

//Minimum flips require to make array same
public class MaxConsFlips {

//	static void toCountGrpOfOnes(int arr[],int n) {
//		int count1grp=0;
//		int counter=arr[0];
//		boolean check = false;
//		for (int i = 1; i < n; i++) {
//			if(counter==arr[i])
//				check = true;
//			else
//				check= false;
//			
//			if(!check || (i==n-1 && arr[i-1]==1)) {
//				if(arr[i-1]==1)
//					count1grp++;
//				
//			}	
//		}
//		System.out.println("count1grp " + count1grp);
//	}

//	Efficeint solution 
	/*
	 * Idea: fact is the if we count the number of zero of 1 and 0 there should be
	 * only two case etither group count differ by one or coutn is same.(Binary
	 * array)
	 * 
	 * beginning and end grp are same then ending diff by 1 and ifts not same then
	 * its 0
	 * 
	 * if we only flip the second grp elements then i will get the minimum flips
	 * 1)11000011001 less count 2)0011100011 equal count these two if we flip the
	 * 2nd grp its less time taking
	 * 
	 */

	static void printGroups(int arr[], int n) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				if (arr[i] != arr[0]) // for the beginning of the flip
					System.out.print("from " + i + " to ");
				else /// end of the flip
					System.out.println(i - 1);
			}

		}
//		 one last element which is differerent from the first element
		if (arr[n - 1] != arr[0])
			System.out.println(n - 1);
	}

	public static void main(String[] args) {
		int arr[] = { 0, 0, 1, 1, 0, 0, 1, 1, 0, 1 };
//		grp 1 3
//		grp 0 2
		printGroups(arr, arr.length);

	}

}
