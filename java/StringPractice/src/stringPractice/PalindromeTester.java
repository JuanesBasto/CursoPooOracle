package stringPractice;
import java.util.Scanner;
public class PalindromeTester {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a word");
		String word= in.next();
		int firstPosition = 0;
		int lastPosition = word.length() -1;
		boolean isAPalindrome = true;
		
		while (firstPosition < lastPosition) {
			if (word.charAt(firstPosition) !=word.charAt(lastPosition))
				isAPalindrome =false;
			firstPosition++;
			lastPosition--;
		}
		if (isAPalindrome) {
			System.out.println("La palabra es palindorma");
		}else {
			System.out.println("La palabra no es palindroma");
		}
		
	}

}
