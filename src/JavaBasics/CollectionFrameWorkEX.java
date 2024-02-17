package JavaBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionFrameWorkEX {
	
	public static class MyComparatot implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			
			String s1 = (String)o1;
			String s2 = (String)o2;
			return s2.compareTo(s1);
		}
		
	}
	public static void main(String[] args) {
		List<String> str = new ArrayList<String>();
		str.add("Hello");
		str.add("Bye");
		str.add("AAAA");
		str.add("BBBBB");
		str.add("CCCCC");
		Collections.sort(str, new MyComparatot());
		System.out.println(str);
	}

}
