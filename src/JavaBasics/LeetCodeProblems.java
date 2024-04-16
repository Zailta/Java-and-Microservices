package JavaBasics;

import java.util.*;

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

    public int[] nextGreaterElement(int[] nums, int[] nums2) {
        //worst approach
        /* boolean flag = false;
        Map<Integer, Integer> mapper = new HashMap<>();
        int[] res = new int[nums.length];
        for(int i = 0; i<nums2.length;i++){
            int num = nums2[i];
            int max = nums2[i];
            
         for(int j = i+1; j<nums2.length; j++){
                 if(nums2[j] > max){
                    max = nums2[j]; 
                if(!mapper.containsKey(num)){
                mapper.put(num, max);
                }
                }   
            }
        }   
        for(int i = 0; i<nums.length;i++){
            if(mapper.get(nums[i])!= null){
                res[i] = mapper.get(nums[i]);
            }
            else {
                res[i] = -1;
            }
            }*/
            //brute
       boolean flag = false;
        int[] res = new int[nums.length] ;
      outer: for(int i = 0; i<nums.length;i++){
        inner: for(int j = 0; j<nums2.length;j++){
            if(nums2[j] == nums[i]){
                if(j == nums2.length-1){
                    res[i] = -1;
                    break inner ;
                }
                else 
                {
                int index = 0;
                subinner: for(int k = j+1; k<nums2.length; k++){
                if(nums2[k] >nums2[j]){
                   flag = true;
                   index = k;
                    break subinner;
                }
                else{
                     flag = false;
                }
                }
                 if(flag){
                    res[i] = nums2[index];
                    break inner;
                }
                else{
                    res[i] = -1;
                     break inner;
                }

               
                }
            }
       }
    }

    return res;
}
    
     static void maxElement2D(int arr[][]) {
    	 int max = arr[0][0];
    	for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j]>max) {
					max = arr[i][j];
				}
			}
		}
    	System.out.println(max);
    }

     static void sumElement2D(int arr[][]) {
    	 int sum = 0;
    	for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sum+=arr[i][j];
			}
		}
    	System.out.println(sum);
    }
     
     public int[][] transpose(int[][] arr) {
         int [][] transpose  = new int[arr[0].length][arr.length];

       for (int i = 0; i < arr[0].length; i++) {//columns
 			for (int j = 0; j < arr.length; j++) {//rows
 				transpose[i][j] = arr[j][i];
 			}
 		}
         return transpose;  
     }
         
     public void rotate(int[][] matrix) {
         //transpose: 
         for(int i = 0 ; i< matrix.length;i++){
             for(int j = 0; j < i; j++){
                 int temp = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = temp;
             }
         }
     //rotate:

     for(int i = 0; i<matrix.length;i++){
         int low = 0, high = matrix.length-1;
         while (low<high){
             int temp = matrix[i][low];
             matrix[i][low] = matrix[i][high]; 
             matrix[i][high] = temp;
             low++;
             high--;
         }
     }
         
     }
     
     public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> res = new ArrayList<>();
         int minr=0, minc=0, maxr= matrix.length-1, maxc = matrix[0].length-1;

         while(minr<=maxr && minc<=maxc){
             //left-to-right
             for(int i = minc; i<=maxc; i++){
                     res.add(matrix[minr][i]);
             }
             minr++;
             if(minr>maxr || minc>maxc) break;
              //top-to-bottom
             for(int i = minr; i<=maxr; i++){
                     res.add(matrix[i][maxc]);
             }
             maxc--;
             if(minr>maxr || minc>maxc) break;
              //right-toleft
             for(int i = maxc; i>=minc; i--){
                     res.add(matrix[maxr][i]);
             }
             maxr--;
             if(minr>maxr || minc>maxc) break;
              //bottom-to-top
             for(int i = maxr; i>=minr; i--){
                     res.add(matrix[i][minc]);
             }
            minc++;


         }

        return res; 
     }
     
     
     public static List<List<Integer>> generate(int numRows) {
         
         List<List<Integer>> res = new ArrayList<>();

         for(int i = 0; i< numRows;i++){
             List<Integer> sub_res = new ArrayList<>();
             for(int j = 0;j<=i;j++){ 
                 if(j == 0 || j == (i)){
                     sub_res.add(1);
                     
                 }
                 else {
                	 
                     int num = res.get(i-1).get(j-1)+res.get(i-1).get(j);
                     sub_res.add(num);
                 }

             }
             res.add(sub_res);
         }
         return res;
     }
     
     public static int[][] multiplymatrix(int [][]arr1, int [][]arr2){
    	 if(arr1[0].length !=arr2.length)
    		return null;
    	 
    	 int[][] res = new int[arr1.length][arr2[0].length];
    	 for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				for (int k = 0; k < arr2.length; k++) {
					res[i][j] += arr1[i][k]*arr2[k][j];
				}
				
			}
		}
    	 
    	 return res;	 
     }
     
     public int matrixScore(int[][] grid) {
         for(int i = 0; i<grid.length; i++){
             //condition to make all 0 indexed 0s to 1
             if(grid[i][0] == 0){
                 for(int j = 0; j<grid[0].length; j++){
                     if(grid[i][j] == 0) grid[i][j] = 1;
                     else grid[i][j] = 0;
                 }
             }
         }
         
         for(int i = 1; i<grid[0].length; i++){
            int zeroes  = 0;
            int ones = 0;
                 for(int j = 0; j<grid.length; j++){
                     if(grid[j][i] == 0) zeroes++;
                     else ones++;
                     
                 }
                 if(zeroes>ones){
                   for(int j = 0; j<grid.length; j++){
                     if(grid[j][i] == 0) grid[j][i] = 1;
                     else grid[j][i] = 0;
                 }  
                 }  
         }
         int sum = 0;
         for( int i = 0; i< grid.length; i++){
             for(int j = 0; j<grid[0].length ; j++){
                 if(grid[i][j]!=0)
                 sum += grid[i][j] * Math.pow(2, grid[0].length-j-1);
             }
         }
         return sum;
     }
     
     public boolean searchMatrix(int[][] arr, int target) {
         int m = arr.length, n = arr[0].length ;
         int i = 0, j = n-1;
         while(i<m && j>=0){
             if(arr[i][j] == target ) return true;
             else if(arr[i][j] > target) j--;
             else i++;
         }
        return false; 
     }
     

	public static void main(String[] args) {
		
		List<List<Integer>> generate = generate(5);
		System.out.println(generate);
		/*
		 * int arr[][] = {{1,2,3},{5,6,7},{8,9,10}}; sumElement2D(arr);
		 */
		 
		 
	}

}
