public class Mouse extends Peripherals{
	
	private String Connection;
	private String Technology;
	public Mouse(){
		super();
		Connection = "Wired" ;
		Technology = "Laser" ;
	}
	public Mouse(String Connection, String Technology, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Connection = Connection;
		this.Technology = Technology ;
	}
	public String toString(){
		return("This is an " + getManufacturer() + " " + getmodelName() + " Mouse from " + getmodelYear() +", with " + Connection + " connection and " + Technology + " technology " + ". It's price is " + getPrice() + " Euros.");
	}
	
}
