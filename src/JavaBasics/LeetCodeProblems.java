package JavaBasics;

import java.util.*;
import java.util.Map;
import java.util.Set;

public class LeetCodeProblems {

	class Solution {
		public String truncateSentence(String s, int k) {

			/*
			 * brute force: String [] sentencesSplit = s.split(" "); StringBuilder res = new
			 * StringBuilder(); for(int i = 0 ;i < k ;i++){
			 * 
			 * res.append(sentencesSplit[i] + " "); }
			 * 
			 * return res.toString().trim();
			 */

			// optimised:
			int spaces = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ' ')
					spaces++;

				if (spaces == k)
					return s.substring(0, i);
			}

			return s;
		}
	}

	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int count = 0;
		for (int i = 0; i < items.size(); i++) {
			List<String> item = items.get(i);
			if (ruleKey.equals("type")) {
				if (item.get(0).equals(ruleValue)) {
					count++;
				}
			} else if (ruleKey.equals("color")) {
				if (item.get(1).equals(ruleValue)) {
					count++;
				}
			} else {
				if (item.get(2).equals(ruleValue)) {
					count++;
				}
			}
		}
		return count;
	}

	public String restoreString(String s, int[] indices) {
		char[] newString = new char[indices.length];
		for (int i = 0; i < indices.length; i++) {
			newString[indices[i]] = s.charAt(i);
		}
		return String.valueOf(newString);

	}

	public static int[] twoSum(int[] nums, int target) {
		/*
		 * brute force: int[] indices = new int[2]; for(int i = 0; i<nums.length;i++){
		 * for(int j = i+1; j<nums.length;j++){ if(nums[i] + nums[j] == target){
		 * indices[0] = i; indices[1] = j; }
		 * 
		 * } } return indices;
		 */
		// optimised approach:
		Map<Integer, Integer> numsMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int secondValue = Math.abs(nums[i] - target);

			if (numsMap.containsKey(secondValue)) {
				return new int[] { numsMap.get(secondValue), i };
			}
			numsMap.put(nums[i], i);
		}

		return new int[] {};

	}
	
	public void reverseArray( int[] arr, int beg, int end){
        while (beg<=end){
        int temp = arr[beg];
        arr[beg] = arr[end];
        arr[end]  = temp;
        beg++;
        end--;
        }
        }
    public void rotate(int[] nums, int k) {
        //optimised appraoch:
        int n = nums.length;
        k = k%n;
        reverseArray(nums, 0, n-k-1);
        reverseArray(nums, n-k, n-1);
        reverseArray(nums, 0, n-1);




        //brute force -  doesnt pass all test cases 
       /* int [] res = new int[nums.length];
        if(nums.length ==1){}
        else{
       for(int i = 0; i<nums.length;i++) {
        if(i<=k && ((k-i-1) !=-1) ){
        res[k-i-1] = nums[nums.length - 1-i];
       }
       else {
        res[i] = nums[i-k];
       }
       }
      for(int i = 0; i<res.length;i++){
        nums[i] = res[i];
      }
        }
        */

       


    }
    
    static int[] sortArray(int [] arr) {
    	int i = 0; 
    	int j = arr.length-1;
    	while(i<=j) {
    		if(arr[i] ==0) i++;
    		else if (arr[j] == 1) j--;
    		
    		else if(arr[i] ==1 && arr[j] ==0) {
    			arr[i] = 0;
    			arr[j] =1;
    			i++;
        		j--;
    		}
    		
    	}
    	
    	return arr;
    }
    
    public void swap(int [] arr, int a, int b ){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;


    }
    public void sortColors(int[] nums) {
        //Method 1:

      /*  int zeroes = 0; 
        int ones = 0;
        for(int i = 0 ; i<nums.length; i++){
            if(nums[i] == 0) zeroes++;
            else if(nums[i] ==1) ones++;
        }

        for(int i = 0 ; i<nums.length; i++){
            if(i<zeroes) nums[i] = 0;
            else if(i<zeroes+ones) nums[i] =1;
            else nums[i] = 2;
        }
*/
      //  Method 2: Dutch Flag Algorithm
      int mid = 0, low = 0, high = nums.length-1;

      while (mid<=high){
        if(nums[mid] == 0){
            swap(nums, mid , low);
            low++; mid++;
        }
        else if(nums[mid] == 1){
            mid++;
        }
        else{
            swap(nums, mid , high);
            high--;
        }
      }
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j=0, k=0;
        int [] res = new int[m+n];

       while (i<m && j<n){
        if(nums1[i]<=nums2[j]){
            res[k] = nums1[i];
            i++;
            
        }
        else {
            res[k] = nums2[j];
            j++;
           
        }
        k++;
        
       }

        if(m == i){
            while (j<n){
            res[k] = nums2[j];
            j++;
            k++;
            }
        }
         if(n == j){
            while (i<m){
            res[k] = nums1[i];
            i++;
            k++;
            }
        }

       
       for(int l = 0; l<nums1.length;l++){
        nums1[l] = res[l];
       }
        
    }

	


	public static void main(String[] args) {
		int[] arr = { 0,1,0,1,1,1,0};
		
		int[] sortArray = sortArray(arr);
		
	}

}
