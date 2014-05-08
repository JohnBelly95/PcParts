public class CPU extends Hardware{
	private double Speed;
	private int CoreCount;
	private static boolean isHardware;
	public CPU(){
		super();
		Speed = 2.9;
		CoreCount = 2;
		isHardware = super.isHardware;
	}
	public CPU(double Speed, int CoreCount, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Speed = Speed;
		this.CoreCount = CoreCount;
		isHardware = super.isHardware;
	}
	public double getSpeed(){
		return Speed;
	}
	public void setSpeed(int Speed){
		this.Speed = Speed;
	}
	public int getCoreCount(){
		return CoreCount;
	}
	public void setCoreCount(int CoreCount){
		this.CoreCount = CoreCount;
	}
	public String toString(){
		System.out.println("===============================================================");
		return("This is an " + getManufacturer() + " " + getmodelName() + " CPU from " + getmodelYear() +", with " + CoreCount + " cores clocked at " + Speed + " Ghz. It's price is " + getPrice() + " Euros.");
	}//This is here for testing purposes feel free to ignore.
}
