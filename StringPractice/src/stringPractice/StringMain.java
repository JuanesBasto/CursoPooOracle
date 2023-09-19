package stringPractice;
 
import java.util.Scanner;

public class StringMain {
	public static void main(String[] args) {
		String s1="This is a string";
		String s2="This is a string";
		String s3="This is ";
		String s4="a string";
		String s5= s3+s4;
		System.out.println(s1==s2);
		System.out.println(s1==s5);
		int n = s1.length();
		System.out.println(n);
		
		String s6 =" I eat apples";
		String s7 ="Bananas are my favorite fruit";
		System.out.println(s6.substring(6));
		System.out.println(s6.substring(6)+" "+s7.substring(8,23));
	}//end method main
	
}//end class stringmain