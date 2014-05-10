public class Keyboard extends Peripherals{
	private String Connection;
	private static boolean isHardware;
	public Keyboard(){
		super();
		Connection = "Wired" ;
		isHardware = super.isHardware;
	}
	
	public Keyboard(String Connection, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Connection = Connection;
		isHardware = super.isHardware;
	}
	
	public String getConnection(){
		return Connection;
	}
	
	public void setConnection(String Connection){
		this.Connection = Connection;
	}
	
	public String toString(){
		System.out.println("===============================================================");
		return("This is an " + getManufacturer() + " " + getmodelName() + " Keyboard from " + getmodelYear() +", with " + Connection + " connection "  + ". It's price is " + getPrice() + " Euros.");
	}
	
}

