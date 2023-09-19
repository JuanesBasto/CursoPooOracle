package clases;

public class Vehicle {
	//tiene dos variables
	private String make;
	private int milesPerGallon;
	//constructor
	public Vehicle() {		
	}//fin
	//getters-setters methods
	public void setMake(String m) {
		make=m;
	}
	public void SetmilesPerGallon(int mpg) {
		milesPerGallon=mpg;
	}
	public String getMake() {
		return make;
	}
	public int GetmilesPerGallon() {
		return milesPerGallon;
	}
	
	public Vehicle(String m, int mpg) {
		make=m;
		milesPerGallon=mpg;
	}
	
}//end class


