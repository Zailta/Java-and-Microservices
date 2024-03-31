package JavaBasics;

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
	public static void main(String[] args) {
		int anybasetoDecimal = BaseConversion(172, 8, 10);
		int anyBasetoAnyBase = BaseConversion(anybasetoDecimal, 10, 2);
		
		
		System.out.println(anyBasetoAnyBase);
	}

}
