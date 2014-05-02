public class Keyboard extends Peripherals{
	private int sale;
	private String Connection;
	public Keyboard(){
		super();
		Connection = "Wired" ;
	}
	
	public Keyboard(String Connection, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Connection = Connection;
	}
	
	public String getConnection(){
		return Connection;
	}
	
	public void setConnection(String Connection){
		this.Connection = Connection;
	}
	
	public String toString(){
		return("This is an " + getManufacturer() + " " + getmodelName() + " Keyboard from " + getmodelYear() +", with " + Connection + " connection "  + ". It's price is " + getPrice() + " Euros.");
	}
	
}

