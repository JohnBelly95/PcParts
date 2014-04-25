public class Screen extends Peripherals{

	private String Type;
	private double Size;
	private String Resolution;
	private int HDMIport;
	private int DVIport;
	private int COMPOSITEport;
	
	public Screen(){
		super();
		Type = " ";
		Size = 0;
		Resolution = " ";
		HDMIport = 0;
		DVIport = 0;
		COMPOSITEport = 0;
	}
	public Screen(String Type, double Size, String Resolution, int HDMIport, int DVIport, int COMPOSITEport, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Type = Type;
		this.Size = Size;
		this.Resolution = Resolution;
		this.HDMIport = HDMIport;
		this.DVIport = DVIport;
		this.COMPOSITEport = COMPOSITEport;
	}
	public String toString(){
		return("This is an " + getManufacturer() + " " + getmodelName() + " Screen from " + getmodelYear() +" , with " + Type + " type , " + Size + " inches , " +Resolution+ " pixels resolution , " +HDMIport+ " HDMI ports , " +DVIport+ " DVI ports and " +COMPOSITEport+ " Compose ports "  +". It's price is " + getPrice() + " Euros.");
	}
	
}
