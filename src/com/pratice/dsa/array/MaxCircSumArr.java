package com.pratice.dsa.array;
// uses kadane algorithm
public class MaxCircSumArr {
/* {10,5,-5}
 * 
 *All circular subarray are 
 *
 *Normal {10},{5},{-5},{10,5},{5,-5},{10,5,-5}
 *circular {5,-5,10} {-5,10},{-5,10,5}
 * 
 */
	
//	naive solution O(nsquare)
/*
 * arr[] = {5,-2,3,4}
 * res = 5\
 * i = 0 curr_max=10,res =10
 * i = 1 curr_max=10
 * i = 2 curr_max=12
 * i = 3 curr_max=10
 * 
 */
	static int maxCircuSum(int arr[],int n) {
		int res = arr[0];
		for (int i = 0; i < n; i++) {
			int curr_sum= arr[i];
			int curr_max=arr[i];
			for (int j = 1; j < n; j++) {
				int index = (i+j)%n; //modular arthimetic 
				curr_sum += arr[index];
				curr_max= Math.max(curr_sum, curr_max);
			}
			res =Math.max(res, curr_max);
		}
		return res;
	}
/*Eff solution O(n)
 * Idea: Take the maximum of the follwing two:
 * 	1. Maximum  sum of normal sub array (kadane's algo)
 * 	2. Maxiumum sum of circular sub array (?)
 * arr[] = [5,-2,3,4]  
 *          _    _,_
 * arr[] = {8,-4,3,-5,4}
 *          _         _
 * {x0,x1---xi,xi+1,....xj-1,xJ+1,....xn-1}
 * ____________                       ____
 * Idea to fix 2nd part
 * To find the Max circular sum first we find minimum sum normal sub array
 * and substract it with the overall array sum.
 * 
 * arr[] = {8,-4,3,-5,4}
 * max_nomral = 8
 * res = 6
 * 
 * after inversion
 * 
 * arr[] = -8,4,-3,5,-4
 * max_circulaar= 6-(-MaxSum)
 * max_circular = 6+6
 * 				=12
 * res =(max_normal,max_circular)
 * res = 12
 * 
 */
	
//	kadane algotithm to find normal sum array
	static int normalMaxSum(int arr[],int n) {
		int res = arr[0];
		int maxEnding = arr[0];
		for (int i = 1; i < n; i++) {
			maxEnding = Math.max(arr[i], maxEnding+arr[i]);
			res = Math.max(res, maxEnding);
			}
		return res;
	}

	static int maxCircuSumEff(int arr[],int n) {
		int max_normal  = normalMaxSum(arr, n);
//		if max_normal is less than zero it means all the element
//		int the array is negative and also optimze and make code correct
//		because else the  circular sum will give 0 as deafualt 
//		which is wrong
		if(max_normal<0)
			return max_normal;
		int arr_sum=0;
//		circular sum
		for (int i = 0; i < n; i++) {
			arr_sum +=arr[i];
			arr[i]=  -arr[i];
		}
//		maximum sum in a inverted array is equal to the 
//		minimum sum in a normal array
//		so insted of substracint the minimumSum
//		we do inverted so  - - becomes +
		int max_circular= arr_sum+ normalMaxSum(arr, n);
		return Math.max(max_normal, max_circular);
	}
	
	
	
	public static void main(String[] args) {
		int arr[] = {10,5,-5};
		System.out.println(maxCircuSum(arr, arr.length));
		System.out.println(maxCircuSumEff(arr, arr.length));
	}

	
//	for every sub array there will be an n number of subarray to
//	begin with becaues of cirvular sum array (by applying modiying kadane)
}
