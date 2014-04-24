public class Printer extends Peripherals{

	private String PrintingType;
	private String Technology;
	public Printer(){
		super();
		PrintingType = "Wired" ;
		Technology = "Laser" ;
	}
	public Printer(String PrintingType, String Technology, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.PrintingType = PrintingType;
		this.Technology = Technology;
	}
	public String toString(){
		return("This is an " + getManufacturer() + " " + getmodelName() + " Printer from " + getmodelYear() +", with " + PrintingType + " printing type and " + Technology + " technology " + ". It's price is " + getPrice() + " Euros.");
	}

}
