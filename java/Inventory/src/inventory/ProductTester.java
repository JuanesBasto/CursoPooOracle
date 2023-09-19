package inventory;

import java.util.Scanner;

public class ProductTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tempNumber;
		String tempName;
		int tempQty;
		float tempPrice;
		int maxSize=-1;
		
		System.out.println("Ingrese el numero de productos que le gustaría agregar");
		System.out.println("Ingrese 0(cero) si no desea agregar ninguno");
		
		
		do {
			try {
				System.out.println(" ");
				System.out.println("Ingrese un numero valido");
				maxSize =in.nextInt();
			}catch(Exception e){
				in.nextLine();	
				System.out.println("Tipo de datos incorrecto introducido");
				maxSize=-1;
			}
		}while(maxSize<0);
		
		
		if (maxSize==0) {
			System.out.println("No se requieren productos");
		}else {
			Product [] productos;
			productos = new Product[maxSize];
			
			for (int i=0;i<maxSize;i++) {
				in.nextLine();
				
				System.out.println("Introduzca el nombre del producto");
				tempName =in.next();
				System.out.println("Digite la cantidad");
				tempQty =in.nextInt();
				System.out.println("Digite el precio");
				tempPrice =in.nextFloat();
				System.out.println("Digite el numero del elemento");
				tempNumber =in.nextInt();
				
				productos[i]= new Product(tempNumber, tempName, tempQty, tempPrice);
			}
			for(Product producto : productos){
				System.out.println(producto);
				System.out.println("");
				System.out.println("");

			}
		}
		
		in.close();
	}
}
		
	

		