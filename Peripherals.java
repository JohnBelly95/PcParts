public class Peripherals extends PcParts{
	public boolean isHardware;
	public Peripherals (){
		super();
		isHardware = false;
	}
	public Peripherals(String modelName, String Manufacturer, int modelYear, int Price, boolean isHardware){
		super(modelName, Manufacturer, modelYear, Price);
		isHardware = false;
	}
}
