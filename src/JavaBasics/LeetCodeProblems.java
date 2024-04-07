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

	public static void main(String[] args) {
		int[] arr = { 2, 5, 5, 11 };
		int target = 10;
		int[] twoSum = twoSum(arr, target);
		for (int s : twoSum) {
			System.out.println(s);
		}

	}

}
