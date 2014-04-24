public class CPU extends Hardware{
	private double Speed;
	private int CoreCount;
	public CPU(){
		super();
		Speed = 2.9;
		CoreCount = 2;
	}
	public CPU(double Speed, int CoreCount, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Speed = Speed;
		this.CoreCount = CoreCount;
	}
	public String toString(){
		return("This is an " + getManufacturer() + " " + getmodelName() + " CPU from " + getmodelYear() +", with " + CoreCount + " clocked at " + Speed + " Ghz. It's price is " + getPrice() + " Euros.");
	}//This is here for testing purposes feel free to ignore.
}
