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

public static void printTrianglAP(int rows) {
	
	for(int i = 1; i<=rows;i++) {
		int a = 1;
		for(int j = 0; j<i;j++) {
			System.out.print(a+"");
			a+=1;
		}
		System.out.println("");
	}
	
}

public static void printTrianglConsecutiveNumbers(int rows) {
	int a = 1;
	for(int i = 1; i<=rows;i++) {
		
		for(int j = 0; j<i;j++) {
			System.out.print(a+"");
			a+=1;
		}
		System.out.println("");
	}
	
}

public static void printTrianglInverse(int rows) {
	
	
	for(int i = 1; i<=rows;i++) {
		
	
		for(int j = 1; j<=rows;j++) {
			if(j<=rows-i)
			System.out.print(" ");	
			else 
				System.out.print("* ");
		}
		System.out.println();
	}
	
}

public static void printpalindromeTraingle(int rows) {
	
	
	for(int i = 1; i<=rows;i++) {
		int pal = 0;
		for(int j = 1; j<=rows;j++) {
			if(j<=rows-i)
			System.out.print(" ");	
		}
		for(int j = 1; j<=i;j++) {
			System.out.print(j);
			pal = j;
			}
		for(int k = 1; k<pal;k++)
		{
			System.out.print(pal-k);
		}
		System.out.println();
	}
	
}

public static void starBridgePattern(int rows) {
	
	for(int i = 1;i<2*rows;i++) {
		System.out.print("* ");
	}
	System.out.println();
	for(int k=1;k<rows;k++) {
	for(int j = 1; j<=rows-k;j++) {
		System.out.print("* ");
	}
	for(int i =0;i<2*k-1;i++) {
		System.out.print("  ");
	}
	for(int j = 1; j<=rows-k;j++) {
		System.out.print("* ");
	}
	System.out.println();
	}
	
	
	
}





	public static void main(String[] args) {
		starBridgePattern(4);
	}

}
