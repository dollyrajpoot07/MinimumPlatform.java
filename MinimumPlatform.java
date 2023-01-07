// Given the arrival and departure times of all trains that reach a railway 
// station, the task is to find the minimum number of platforms required for 
// the railway station so that no train waits. We are given two arrays that 
// represent the arrival and departure times of trains that stop.
// Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}, dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00} 
// Output: 3 
// Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)

import java.util.*;

class MinimumPlatform {

	static int findPlatform(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);

		int plat_needed = 1, result = 1;
		int i = 1, j = 0;

		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				plat_needed++;
				i++;
			}

			else if (arr[i] > dep[j]) {
				plat_needed--;
				j++;
			}

			if (plat_needed > result)
				result = plat_needed;
		}

		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int n = arr.length;
		System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr, dep, n));
	}
}
