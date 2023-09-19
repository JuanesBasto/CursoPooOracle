package inventory;

public class Product {
	//Instance field declaration
	int Number;
	String Name;
	int Qty;
	float Price;
	boolean Activo=true;
	int inventoryPrice;

	//contructor predeterminado que inicialice los campos
	public Product() {	
	}
	
	//sobrecargamos el constructor predeterminado
	public Product(int Number, String Name, int Qty, float Price) {
		//Asignamos nombre a los parametros
		this.Number=Number;
		this.Name=Name;
		this.Qty=Qty;
		this.Price=Price;
		
	}
	//Getters and setters
	
	 /*descriptores de acceso
	 * getters: captan el valor de cada variable de la clase
	 * descriptores de mutación
	 * setters:establecen el valor de cada variable de la clase
	 */
	//Number
	public int getNumber() {
		return Number;		
	}
	public void setNumber(int Number) {
		this.Number = Number;
	}
	//Name
	public String getName() {
		return Name;		
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	//Qty
	public int getQty() {
		return Qty;		
	}
	public void setQty(int Qty) {
		this.Qty = Qty;
	}
	//Price
	public float getPrice() {
		return Price;		
	}
	public void setPrice(float Price) {
		this.Price = Price;
	}
	//Activo
	public boolean getActivo() {
		return Activo;		
	}
	public void setActivo(boolean Activo) {
		this.Activo = Activo;
	}
	//inventoryPrice
	public int getinventoryPrice() {
		return inventoryPrice;		
	}
	public void setinventoryPrice(int inventoryPrice) {
		this.inventoryPrice = inventoryPrice;
	}
	
	
	public String toString() {
		String p1="";
		boolean Activo=( Qty>0) ?true:false;
		setInventoryValue( Qty, (int) Price);
		p1="Numero de item: " + Number +"\nNombre: "+ Name +"\nCantidad en stock: "+ Qty +"\nPrecio: "+ Price+"\nStock value: "+inventoryPrice+ "\nProduct status: "+Activo;
		return p1;
	}
	
	public int setInventoryValue(int Qty, int Price) {
		inventoryPrice= (int) (Qty*Price);
		return inventoryPrice;
	}
}
