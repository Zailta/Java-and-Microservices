package JavaBasics;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DSALevel1 {

	public static int BaseConversion(int number, int sourceBase, int targetBase ) {
		int convertedValue = 0;
		int power = 0;
		while (number>0) {
			int remainder = number%targetBase;
			number = number/targetBase;
			convertedValue += remainder * Math.pow(sourceBase, power);
			power++;
			
		}
		
		return convertedValue;
	}
	
	public static void barGraph(int[] arr) {
		int max = arr[0];
		for(int i = 0; i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		for(int  y = max ; y>=0; y--) {
			for(int i = 0; i<arr.length; i++) {
				if(y<=arr[i]) {
					System.out.print("*\t");
				}
				else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}
	
	public static void duplicateBrackets(String str) {
		Stack<Character> stack =  new Stack<>();
		for(int i = 0; i<str.length();i++) {
			if(str.charAt(i) == ')') {
				if(stack.peek() == '(') {	
					System.out.println(true);
					return;
				}else {
					while (stack.peek()!= '(') {
						stack.pop();
					}
					stack.pop();
				}
			}
			else {
				stack.push(str.charAt(i));
			}
		}
		System.out.println(false);
		
	}
	
	public static  boolean isValid(String str) {
        Stack<Character> stack = new Stack<Character>();
        int count  = 0;
      Map<Character, Character> paranthesisMap = new HashMap<Character, Character>();
      paranthesisMap.put(')', '(');
      paranthesisMap.put('}', '{');
      paranthesisMap.put(']', '[');
      
		for(int i = 0; i<str.length();i++){
          
			if(str.charAt(i) == ')' || str.charAt(i) == '}'  || str.charAt(i) == ']' ) {
              count--;
				if(stack.contains((char)paranthesisMap.get(str.charAt(i)))) {
				while(stack.peek() != (char)paranthesisMap.get(str.charAt(i))) {
					stack.pop();
				}
				stack.pop();
				}
				else {return false;}
			}
			else {
				stack.push(str.charAt(i));
              count++;
			}
			
		}
		if(stack.isEmpty() && count ==0)
			return true;
		
		return false;
  }
        
    
	public static void main(String[] args) {
		int anybasetoDecimal = BaseConversion(172, 8, 10);
		int anyBasetoAnyBase = BaseConversion(anybasetoDecimal, 10, 2);
		int[] arr = {1,2,3,4};
		barGraph(arr);
		String str = "({[)";
		boolean balancedParenthesis = isValid(str);
		System.out.println(balancedParenthesis);
		duplicateBrackets(str);
		
		
	}

}
