public class Hardware extends PcParts{
	public boolean isHardware;
	public boolean isPeripherals;
	public Hardware(){
		super();
	}
	public Hardware(String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		isHardware = true;
		isPeripherals = false;
	}
}
