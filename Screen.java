public class Screen extends Peripherals{

	private String Type, Resolution;
	private double Size;
	private int HDMIport, DVIport, COMPOSITEport;
	private static boolean isHardware;
	
	public Screen(){
		super();
		Type = " ";
		Size = 0;
		Resolution = " ";
		HDMIport = 0;
		DVIport = 0;
		COMPOSITEport = 0;
		isHardware = super.isHardware;
	}
	public Screen(String Type, double Size, String Resolution, int HDMIport, int DVIport, int COMPOSITEport, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Type = Type;
		this.Size = Size;
		this.Resolution = Resolution;
		this.HDMIport = HDMIport;
		this.DVIport = DVIport;
		this.COMPOSITEport = COMPOSITEport;
		isHardware = super.isHardware;
	}
	
	public String getType(){
		return Type;
	}
	public void setType(String Type){
		this.Type = Type;
	}
	
	public double getSize(){
		return Size;
	}
	public void setSize(double Size){
		this.Size = Size;
	}
	
	public String getResolution(){
		return Resolution;
	}
	public void setResolution(String Resolution){
		this.Resolution = Resolution;
	}
	
	public int getHDMIport(){
		return HDMIport;
	}
	public void setHDMIport(int HDMIport){
		this.HDMIport = HDMIport;
	}
	
	public int getDVIport(){
		return DVIport;
	}
	public void setDVIport(int DVIport){
		this.DVIport = DVIport;
	}
	
	public int getCOMPOSITEport(){
		return COMPOSITEport;
	}
	public void setCOMPOSITEport(int COMPOSITEport){
		this.COMPOSITEport = COMPOSITEport;
	}
	
	
	public String toString(){
		System.out.println("===============================================================");
		return("This is an " + getManufacturer() + " " + getmodelName() + " Screen from " + getmodelYear() +" , with " + Type + " type , " + Size + " inches , " +Resolution+ " pixels resolution , " +HDMIport+ " HDMI ports , " +DVIport+ " DVI ports and " +COMPOSITEport+ " Compose ports "  +". It's price is " + getPrice() + " Euros.");
	}
	
}
