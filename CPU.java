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
}
