public class Hardware extends PcParts{
	public boolean isHardware;
	public Hardware(){
		super();
		isHardware = true;
	}
	public Hardware(String modelName, String Manufacturer, int modelYear, int Price, boolean isHardware){
		super(modelName, Manufacturer, modelYear, Price);
		isHardware = true;
	}
}
