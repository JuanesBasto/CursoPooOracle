package stringPractice;
import java.util.Scanner;

public class Example {
	public static void main(String [] args) {
		
		Scanner leer= new Scanner(System.in);
		System.out.println("Introduzca su correo electronico");
		String email= leer.nextLine();
		leer.close();
		
		String domain="";
		int position=email.indexOf("@");
		domain=email.substring(position);
		System.out.println(domain);

	}

}
