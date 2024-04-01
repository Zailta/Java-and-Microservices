package JavaBasics;

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
				}else {
					while (stack.peek()!= '(') {
						stack.pop();
					}
				}
				stack.pop();
			}
			else {
				stack.push(str.charAt(i));
			}
		}
		System.out.println(false);
		
	}
	public static void main(String[] args) {
		int anybasetoDecimal = BaseConversion(172, 8, 10);
		int anyBasetoAnyBase = BaseConversion(anybasetoDecimal, 10, 2);
		int[] arr = {1,2,3,4};
		//barGraph(arr);
		String str = "((a+b)+ (c+d))";
		duplicateBrackets(str);
		
		//System.out.println(anyBasetoAnyBase);
	}

}
