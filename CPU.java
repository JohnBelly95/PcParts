public class CPU extends Hardware{
	private String modelName;
	private String Manufacturer;
	private int modelYear;
	private int Price;
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
	}
}
