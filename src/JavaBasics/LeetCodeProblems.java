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
     
     public void setZeroes(int[][] arr) {
         int[][] helper =  new int[arr.length][arr[0].length];
         for(int i = 0; i< arr.length;i++){
             for(int j = 0; j<arr[0].length;j++){
                     helper[i][j] = arr[i][j];
             }
         }

         for(int i = 0; i< arr.length;i++){
             for(int j = 0; j<arr[0].length;j++){
                 if(helper[i][j] == 0){
                     for(int a = 0; a < arr.length; a++){
                         arr[a][j] = 0;
                     }

                     for(int b = 0; b < arr[0].length; b++){
                         arr[i][b] = 0;
                     }
                 }
             }
         }
         
     }
     
     public boolean isAnagram(String s, String t) {

         // Appraoch 1:
         if(s.length() != t.length()){
              return false;
          }
              char [] a = s.toCharArray();
              char [] b = t.toCharArray();
              Arrays.sort(a);
              Arrays.sort(b);
          for(int i = 0; i< a.length;i++){
              if(a[i]!=b[i])
              return false;
          }
          

          //Approcah 2:
         /* if(s.length() != t.length()){
              return false;
          }
          int[] alphabetArr = new int[26];

          for(int i = 0; i<s.length();i++){
              alphabetArr[s.charAt(i) - 'a']++;
              alphabetArr[t.charAt(i) - 'a']--;
          }

          for(int counter: alphabetArr ){
              if(counter!=0)
              return false;
          }
          */

          return true;
          
      }
     
     public static void charWithMaxOccurence(String str) {
    	 Map<Character, Integer> tracker = new HashMap<Character, Integer>();
    	 for(int i = 0; i<str.length();i++) {
    		 if(tracker.containsKey(str.charAt(i))) {
    			 Integer value = tracker.get(str.charAt(i))+1;
    			 
    			 tracker.put(str.charAt(i), value);
    		 }
    		 else {
    		 tracker.put(str.charAt(i), 1);
    		 }
    	 }
    	 
    	 System.out.println(tracker);
    	 int max = 0;
    	 Character key =  null;
    	 for(Character c: tracker.keySet()) {
    		 if(tracker.get(c) > max) {
    			 key = c;
    			 max = tracker.get(c);
    		 }
    	 }
    	 System.out.println("max occurences for '"+key +"' with max occurence of : "+max);
    	 
     }
     
     public boolean isIsomorphic(String s, String t) {
         //Approach 1
       char[] source =  s.toCharArray();
       char[] target =  t.toCharArray();
        Map<Character, Character> isoTracker = new HashMap<>();
        for(int i  = 0; i< s.length(); i++){
            if(isoTracker.containsKey(source[i])){
                if(isoTracker.get(source[i])!= target[i] )
                return false;
            }
            else{
                if(isoTracker.containsValue(target[i]))
                return false;
            isoTracker.put(source[i], target[i]);
            }
        }
        return true;
    }
     
     public static String findMax(String [] str) {
    	String maxString = str[0];
    	for (int i = 0; i < str.length; i++) {
    		//purify both :
    		String a = purifyString(maxString), b  = purifyString(str[i]);
    		
			//cases:
    		//if max> str[i]
    		if(a.length() > b.length()) return maxString;
    		//if max< str[i]
    		if(a.length() < b.length()) return str[i];
    		//case where length is same -> then we do the char comparison
    		for (int j = 0; j < str.length; j++) {
				if(a.charAt(i) != b.charAt(i)) {
					if (a.charAt(i) > b.charAt(i)) return maxString;
					else return str[i];
				}
			}
    		//if both are same
		}
    	 
    	 return null;
    	 
     }
     
     public static String purifyString(String s) {
    	 for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)!='0') return s.substring(i);
		}
    	 
    	 return s;
    	 
     }
     
     public int compress(char[] chars) {
         int  i =0, j = 0; 
        StringBuilder res = new StringBuilder();

         while (j<chars.length){
             if(chars[j]  == chars[i]) j++;
             else {
                 res.append(chars[i]);
                 int len = (j-i);
                 if(len > 1)
                     res.append(len);
                 i = j;
             }
         }
             res.append(chars[i]);
             int len = (j-i);
             if(len > 1)
               res.append(len);
            String str =  res.toString();
           for(int k = 0; k< str.length();k++){
                 chars[k] = str.charAt(k);
           }  
         return str.length();
         
     }
     
     public int majorityElement(int[] nums) {
    	 
    	 //approach 1:
    	 Arrays.sort(nums);
    	 //Approach 2:
         for(int i = 0; i< nums.length;i++){
             int item = nums[i];
             int j = i-1;
             while(j>=0 && nums[j] > item){
                 nums[j+1] = nums[j];
                 j--;
             }
             nums[j+1] = item;
         }
         return nums[nums.length/2];
     }
     
     public static int[] transformArray(int [] arr) {
    	 int [] copy = Arrays.copyOf(arr, arr.length);
    	 Arrays.sort(copy);
    	 for(int  i = 0; i< arr.length;i++) {
    		 for (int j = 0; j < copy.length; j++) {
				if(copy[i] == arr[j]) {
					arr[j] = i;
				}
			}
    	 }
    	 return arr;
     }
     
     public int search(int[] nums, int target) {
         int low = 0, high = nums.length-1;
         while(low<=high)  {
        	 //for supporting higher Numbers because (low+high)/2 won't work 
           int mid = low+ (high-low)/2;
           if(nums[mid] == target) return mid;
           else if(nums[mid] > target) high = mid -1;
           else low = mid+1;
         }
         return -1;
       }
     
     public int lowerBound(int [] nums , int target) {
    	 int low = 0, high = nums.length-1;
         while(low<=high)  {
        	 //for supporting higher Numbers because (low+high)/2 won't work 
        	 int lb = high;
           int mid = low+ (high-low)/2;
            if(nums[mid] >= target)
            	{
            	lb  = Math.min(lb, mid);
            	high = mid -1;
            	
            	}
           else low = mid+1;
         }
         return -1;
     }
     public int[] searchRange(int[] nums, int target) {
         int[] ans = {-1, -1};
         boolean flag = false;
          int low = 0, high = nums.length-1;
          
          while(low<=high)  {
         	 //for supporting higher Numbers because (low+high)/2 won't work 
            int mid = low+ (high-low)/2;
            if(nums[mid] == target){
                 flag = true;
                 break;
            }
            else if(nums[mid] > target) high = mid -1;
            else if(nums[mid] < target)low = mid+1;
          }
          if(flag == false) return ans;
         

            low = 0; high = nums.length-1;
            int lb = nums.length;
          while(low<=high)  {
         	 //for supporting higher Numbers because (low+high)/2 won't work 
            int mid = low+ (high-low)/2;
             if(nums[mid] >= target)
             	{
             	lb  = Math.min(lb, mid);
             	high = mid -1;
             	
             	}
            else low = mid+1;
          }
             ans[0] = lb;
            low = 0; high = nums.length-1;
            int ub = nums.length;
          while(low<=high)  {
         	 //for supporting higher Numbers because (low+high)/2 won't work 
            int mid = low+ (high-low)/2;
             if(nums[mid] > target)
             	{
             	ub  = Math.min(ub, mid);
             	high = mid -1;
             	
             	}
            else low = mid+1;
          }
          ans[1] = ub-1;

          return ans;
     }
     public int peakIndexInMountainArray(int[] arr) {
         int low = 1, high  = arr.length-2;
         int peak  = 0;
         while(low<=high){
             int mid = low+(high - low)/2;
             if(arr[mid-1] < arr[mid] && arr[mid+1] < arr[mid]) return mid;
             else if(arr[mid-1] > arr[mid] && arr[mid+1] < arr[mid]) high = mid-1;
             else if(arr[mid-1] < arr[mid] && arr[mid+1] > arr[mid]) low = mid+1;
         }
        return 0; 
     }
     public int mySqrt(int x) {
         long low = 0, high = (long)x;
         while (low<=high){
             long mid = low+(high -low)/2;
             if(mid*mid == (long)x) return (int)mid;
             else if(mid*mid > (long)x) high  = mid-1;
             else low = mid+1;
         }
         return (int)high;
     }
     
     public int bs(int [] nums, int low, int high, int target){
         while(low<=high)  {

           int mid = low+ (high-low)/2;
           if(nums[mid] == target) {
                return mid;
           }
           else if(nums[mid] > target) high = mid -1;
           else low = mid+1;
         }
         return -1;
    }
    public int searchInRotatedArray(int[] nums, int target) {

        if(nums.length <= 2){
            for(int i =0; i<nums.length ; i++){
                if(nums[i] == target)
                    return i; 
            }
            return -1;
        }
        int low = 1, high  = nums.length-2;
        int pivot  = -1;
        while (low<=high){
            int mid = low+(high -low)/2;
            if(nums[mid+1] < nums[mid]  && nums[mid-1]< nums[mid])
            { 
                pivot  = mid;
                break;

            }
            else if (nums[mid+1] > nums[mid]  && nums[mid-1]> nums[mid])
            { 
                pivot  = mid-1;
                break;

            }

             else if (nums[mid+1] < nums[mid]  && nums[mid-1] > nums[mid]){
                if(nums[mid] > nums[nums.length-1]) low  = mid+1;
                else high = mid-1;
             } 
        }
        if(pivot ==-1){
            return bs(nums, 0, nums.length-1, target);
        }
        int left  = bs(nums, 0, pivot, target);
        if(left != -1) return left;
        int right  = bs(nums, pivot+1, nums.length-1, target);
        
        return right;
        
    }
    
    public int searchinRoatateArrayOptimised(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
           else if(nums[mid] <= nums[nums.length-1]){
            if( target > nums[mid]  && target <= nums[high])
                low = mid+1;
            else 
                high  = mid-1;
           }
           else{
            if( target >= nums[low]  && target < nums[mid])
                high  = mid-1;
            else 
                low = mid+1;
           }
           
        }
        return -1;
}
    
    public int countPairs(List<Integer> nums, int target) {
        int low = 0, high = nums.size()-1;
        int count  = 0; 
        while(low<=high){
            
             if(low < high )
           {
           if(nums.get(low) + nums.get(high) < target){
             count ++;
             high-=1;
           }
           else high -=1;
           }
           else 
           {
            high = nums.size()-1;
            low+=1;
           }
        }
        return count;
    }
    public int countNegatives(int[][] grid) {
        int m = grid[0].length;
        int count = 0;
        for (int[] ints : grid) {
            int start = 0;
            int end = m - 1;
            while (start <= end) {
                int mid = start - (start - end) / 2;
                if (ints[mid] < 0) {
                    end = mid - 1;
                    if (mid == 0 || ints[mid - 1] >= 0) count += m - mid;
                } else start = mid + 1;
            }
        }
        return count;
    }
    
    public int countNegativesoptimised(int[][] grid) {
        int count  = 0; 
        int checker = 0;
       
       for(int[] rows : grid){
        int low = 0, high = rows.length-1;
        while (low<= high){
                int mid = low + (high -low)/2;
                if(rows[mid] < 0)
                {
                    high  = mid-1;
                 if(mid == 0 || rows[mid-1] >= 0) count+= grid[0].length - mid;
                }
                else low = mid+1;
        }
       }
        return count;
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
       List<Integer> a = new ArrayList<>();
       for(int i = 0;i<nums.length;i++){
           if (nums[i] == target){
               a.add(i);
           }else if(nums[i] > target){
               break;
           }
       }
       return a;
   }
    
  //optimised approach:
    public int [] intersection(int[] nums, int[] nums1) {
    boolean [] seen  = new boolean[1001];

    for(int num: nums){
        seen[num] = true;
    }
    List<Integer> intersectionList = new ArrayList<>();
    for(int num: nums1){
        if(seen[num]){
        intersectionList.add(num);
        seen[num] = false;
        }
    }
    int[] result = new int[intersectionList.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = intersectionList.get(i);
        }

    return result;


    //absolute worst approach :
   /* public int [] intersection(int[] nums, int[] nums1) {
        int count = 0;
        Map<Integer, Integer> checker1 = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
             for(int j = 0; j< nums1.length; j++){
            if(nums[i] == nums1[j] && !checker1.containsKey(nums[i])){
               count++;
               checker1.put(nums[i], 1);
               break;
            }
        }
        }
    int[] ans = new int[count];
    int index = 0;
    Map<Integer, Integer> checker = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
             for(int j = 0; j< nums1.length; j++){
            if(nums[i] == nums1[j] && !checker.containsKey(nums[i])){
               ans[index++] = nums[i];
               checker.put(nums[i], 1);
               break;
            }
        }
        }
       return ans;
       */
    }
    
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        //Bse case if x< arr[0]
        if(x < arr[0]){
            for(int i = 0 ; i< k; i++){
                ans.add(arr[i]);
            }
            return ans;
        }
         if(x > arr[arr.length -1]){
            Arrays.sort(arr);
            for(int i = arr.length -1 ; i>= arr.length -1 - k; i--){
                ans.add(arr[i]);
            }
            return ans;
        }

        //first calciulate the lowerbound of that Number 
        int low = 0, high  = arr.length-1;
        int lowerBound = high;
        while(low <= high){
                int mid = low + (high - low )/2;
                if(arr[mid] >= x){
                    lowerBound = Math.min(lowerBound, mid);
                    high  = mid -1;
                }
                else {
                    low = mid+1;
                }
        }
        //lowerbound will be the starting point for the Closest Algo

        int index_i = lowerBound, index_j = lowerBound-1;
        while(k> 0  && index_j >= 0  && index_i < arr.length){
            int difference_i = Math.abs(x-arr[index_i]);
            int difference_j = Math.abs(x-arr[index_j]);
            if(difference_j <= difference_i ){
               ans.add(arr[index_j]); 
               index_j--;
               k--;
            }
            else {
               ans.add(arr[index_i]); 
               index_i++; 
               k--;
            }
            

            if(index_j < 0 && k > 0 ){
               ans.add(arr[index_i]); 
               index_i++;
               k--;
            }
            if(index_i == arr.length -1 && k > 0 ){
               ans.add(arr[index_j]); 
               index_j--;
               k--;
            }
        }
        Collections.sort(ans);
        
        return ans;
    }

    public String reversePrefix(String word, char ch) {
        final int index = word.indexOf(ch)+1;
         
        return new StringBuilder(word.substring(0, index))
                    .reverse() 
                    .append(word.substring(index)).toString();
        
    }
	public static void main(String[] args) {
		
		/*
		 * List<List<Integer>> generate = generate(5); System.out.println(generate);
		 */
		//String s = "anaaaaaabbbbaacccccccccccccccccccccccgram";
		
		//charWithMaxOccurence(s);
		//Map<Character, Character> isoTracker = new HashMap<>();
		/*
		 * String [] str = {"234", "234", "00000011","234"}; String findMax =
		 * findMax(str); System.out.println(findMax); char c = 'a'; String.valueOf(c);
		 * StringBuilder sb = new StringBuilder();
		 */
		
		/*
		 * int arr[][] = {{1,2,3},{5,6,7},{8,9,10}}; sumElement2D(arr);
		 */
		int arr[] = {5,7,7,8,8,10};
		
		 
		/*
		 * int[] transformArray = transformArray(arr); for(int el: transformArray) {
		 * System.out.print(el +", "); }
		 */
		int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		
		 
	}
	

}
