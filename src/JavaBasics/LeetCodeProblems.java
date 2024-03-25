package JavaBasics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCodeProblems {
	
	public static int[] twoSum(int[] nums, int target) {
		  /*brute force:
        int[] indices = new int[2];
        for(int i = 0; i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    indices[0] = i;
                    indices[1] = j;
                }
                
            }
        }
       return indices; 
       */
       //optimised approach:
		 Map<Integer, Integer> numsMap = new HashMap<>();

	       for(int i = 0; i<nums.length;i++){
	        int secondValue = Math.abs(nums[i]-target);

	            if(numsMap.containsKey(secondValue)){
	                return new int[]{numsMap.get(secondValue),i };
	            }
	        numsMap.put(nums[i], i); 
	       }
	            
	            return new int[]{};

    }
	public static void main(String[] args) {
		int [] arr = {2,5,5,11};
		int target  = 10;
		int[] twoSum = twoSum(arr,target);
		for(int s:twoSum) {
			System.out.println(s);
		}
		
		
	}

}
