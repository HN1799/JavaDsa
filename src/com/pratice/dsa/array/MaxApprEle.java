package com.pratice.dsa.array;

// based on prefix
// maximum appring element in ranges
public class MaxApprEle {
	
	
//	naive solution  O(n*max)  here max is 100
//	because the first for loop is of n times and after that
//	we are running a loop for every range we can say all 0-99 are there if
/*
 * traverse to every range then traverse to every element of the every range
 * and for every element it increase its frequency by 1.
 * then it travel to the frequency array and finds out the index which has
 * the maxiumum value
 */
	static int maxAppear(int left[],int right[],int n) {
		int freq[] = new int[100];
		
		for (int i = 0; i < n; i++) 
			for(int k = left[i];k<=right[i];k++) 
				freq[k]+=1; 
//		after processing all the element
//		int freq [] = {0,1,2,2,3,1,2,1...}; ex:-
		int rs = 0;
		for(int i =0;i<freq.length;i++) {
			if(freq[i]>freq[rs])
				rs = i;
		} //rs is the index which is the element
		return rs;
	}
	
	
/*  theta(n+max)  and it is linear earlier it is quadratic
 * Idea for efficeint solution 
 * 	int left []={1,2,4};
	int right []={4,5,7};
	Freq ={0,0,0,0,0,0,0,....}
 * 	
 * 
 * 1) traverse through all the ranges and mark the begining and ending of the 
 *    in freq
 *    
 *    freq[left[i]]++,   freq[right[i]+1]--
 *    
 *    i = 0,
 *    freq[] = {0,1,0,0,0,-1,0,0,0,0.....}
 *    i =1,
 *    freq[] = {0,1,1,0,0,-1,-1,0,0,0.....}
 *    i=2
 *    freq[] = {0,1,1,0,1,-1,-1,0,-1,0.....}
 *    
 *    
 *    
 * 2)Do prefix sum in freq[] 
 *   freq[] = {0,1,2,2,3,2,1,1,0,0,0....}
 *   
 * 3)Return index of the maximum value :return 4
 * 
 * 
 */
	
	static int maxAppearEff(int left[],int right[],int n) {
		int freq[] = new int[100];
		for (int i = 0; i < n; i++) {   //theta(n)
			freq[left[i]]++;
			freq[right[i]+1]--;
		}
		
		int res = 0;
		for (int i = 0; i < 100; i++) {  //theta(max)
			freq[i] = freq[i-1]+freq[i];
			if(freq[i]> freq[res])
				res = i;
		}
		
		return res;
	}
	

	

	
/*
 * I/p : left ={1,2,5,15};
 * 		 right={5,8,7,18};
 * O/p : 5
 * 
 * I/p : left = {1,2}
 * 	     right= {5,4}
 * O/p : 2
 * constraint : 0<= left[i]<= right[i]<100
 */
	public static void main(String[] args) {
	
		int left []={1,2,4};
		int right []={4,5,7};
		
		System.out.println(maxAppear(left, right, left.length));

	}

}
