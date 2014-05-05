public class Peripherals extends PcParts{
	public boolean isHardware = false;
	public Peripherals (){
		super();
	}
	public Peripherals(String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		isHardware = false;
	}
}
