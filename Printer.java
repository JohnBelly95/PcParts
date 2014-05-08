public class Printer extends Peripherals{
	private String PrintingType;
	private String Technology;
	private static boolean isHardware;
	
	public Printer(){
		super();
		PrintingType = "Colored" ;
		Technology = "Laser" ;
		isHardware = super.isHardware;
	}
	
	public Printer(String PrintingType, String Technology, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.PrintingType = PrintingType;
		this.Technology = Technology;
		isHardware = super.isHardware;
	}
	
	public String getPrintingType(){
		return PrintingType;
	}
	
	public void setPrintingType(String PrintingTYpe){
		this.PrintingType = PrintingType;
	}
	public String getTechnology(){
		return Technology;
	}
	
	public void setTechnology(String Technology){
		this.Technology = Technology;
	}
	
	public String toString(){
		return("This is an " + getManufacturer() + " " + getmodelName() + " Printer from " + getmodelYear() +", with " + PrintingType + " printing type and " + Technology + " technology " + ". It's price is " + getPrice() + " Euros.");
	}

}
