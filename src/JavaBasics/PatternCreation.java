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

public static void printTriangle(int rows, int coloumns) {
	
	for(int i = 0; i<rows;i++) {
		for(int j = 0; j<=i;j++) {
			System.out.print("*");
		}
		System.out.println("");
	}
	
}

public static void printTriangleNumbers(int rows, int coloumns) {
	
	for(int i = 0; i<rows;i++) {
		for(int j = 0; j<=i;j++) {
			System.out.print(j+"");
		}
		System.out.println("");
	}
	
}


	public static void main(String[] args) {
		printTriangleNumbers(4, 5);
	}

}
