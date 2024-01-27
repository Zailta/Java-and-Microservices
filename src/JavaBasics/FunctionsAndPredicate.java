package JavaBasics;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import bean.StudentBean;

public class FunctionsAndPredicate {
	

	public static void main(String[] args) {
		
		Predicate<Integer> failFlag = f->(f<65);
		
		Function<Integer, String> gradeFunction = marks->{
			String gradeObtained = "";
			;
			switch (marks/10) {
			case 10: 
			case 9:
				gradeObtained = "A";
				break;
			
			case 8:
				gradeObtained = "B";
				break;
			case 7:
				gradeObtained = "C";
				break;
			case 6:
				gradeObtained = "D";
				break;
				
				
				
			default:
				gradeObtained = "F";
				break;
			}
			
			return gradeObtained;
		};
		
		Function<String, String> gradeValueFunction = grade->{
			String gradeValue  =null;
			switch (grade) {
			case "A": 
				gradeValue = "Distinction";
				break;
			
			case "B":
				gradeValue = "Excellent";
				break;
			case "C":
			gradeValue = "Good";
				break;
			case "D":
			gradeValue = "Average";
				break;
				
				
				
			default:
				gradeValue = "Fail";
				break;
			}
			
			return gradeValue;
		};
		
		Supplier<StudentBean[]> studentBeanSupplier = () -> new StudentBean[]{
			new StudentBean(1, "Mohammad", "Azam", 95, "", ""),
			new StudentBean(2, "Mohammad", "Azam", 95, "", ""), new StudentBean(3, "Mohammad", "Manaan", 85, "", ""),
			new StudentBean(4, "Zailta", "Casper", 75, "", ""), new StudentBean(5, "Jane", "Doe", 65, "", ""),
			new StudentBean(6, "Sebastian", "Mars", 55, "", "") 
		};

		
		Consumer<StudentBean[]> studentBeanConsumer = students->{
			for(StudentBean s  : students) { 
				s.setGradeObtained(gradeFunction.apply(s.getMarksObtained()));
				s.setGradeValue(gradeValueFunction.apply(s.getGradeObtained()));
				if(failFlag.test(s.getMarksObtained()))
					System.out.printf("Dear %s , You need to work Hard!!\n",s.getFirstName());
				System.out.println("Student ID: "+s.getStudentId());
				System.out.println("First Name: "+s.getFirstName());
				System.out.println("Last Name: "+s.getLastName());
				System.out.println("Marks Obtained: "+s.getMarksObtained());
				System.out.println("Grade: "+s.getGradeObtained());
				System.out.println("Grade Value: "+s.getGradeValue());
				System.out.println();
			}
		};
		
		
		studentBeanConsumer.accept(studentBeanSupplier.get());
		

	}
	
	
	public static void predicateConditional(List <String>input, Predicate p, Function f){
		for(String s: input) {
		if(p.test(s.length())) {
			System.out.println(String.format("Fruit Name is: %s and the ", s.toUpperCase())+ " with Length: "+f.apply(s));
		}}
		
	}

}
