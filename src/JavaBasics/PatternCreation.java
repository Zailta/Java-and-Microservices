package JavaBasics;

public class PatternCreation {
	
	public static void printrectangle(int rows, int coloumns) {
		
		for(int i = 0; i<rows;i++) {
			for(int j = 0; j<coloumns;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}
	
public static void printNumber(int rows, int coloumns) {
		
		for(int i = 0; i<rows;i++) {
			for(int j = 0; j<coloumns;j++) {
				System.out.print(j+"");
			}
			System.out.println("");
		}
		
	}

public static void printTriangle(int rows) {
	
	for(int i = 0; i<rows;i++) {
		for(int j = 0; j<=i;j++) {
			System.out.print("*");
		}
		System.out.println("");
	}
	
}

public static void printTriangleNumbers(int rows) {
	
	for(int i = 0; i<rows;i++) {
		for(int j = 0; j<=i;j++) {
			System.out.print(j+"");
		}
		System.out.println("");
	}
	
}

public static void printTriangleOdd(int rows) {
	
	for(int i = 1; i<=rows;i++) {
		for(int j = 1; j<=i;j++) {
			System.out.print(2*j-1);
		}
		System.out.println("");
	}
	
}

public static void printTriangleEven(int rows) {
	
	for(int i = 0; i<=rows;i++) {
		for(int j = 0; j<=i;j++) {
			System.out.print(2*j);
		}
		System.out.println("");
	}
	
}



	public static void main(String[] args) {
		printTriangleEven(4);
	}

}
