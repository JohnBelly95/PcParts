public class RAM extends Hardware{
	private String Type;
	private int Size, Speed;
	private static boolean isHardware;
	
	public RAM(){
		super();
		Type = "DDR3";
		Size = 8;
		Speed= 2000;
		isHardware = super.isHardware;	
	}
	public RAM(String Type, int Size, int Speed,  String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Type = Type;
		this.Size = Size;
		this.Speed=Speed;
		isHardware = super.isHardware;
	}
	public String getType(){
		return Type;
	}
	public void setType(String Type){
		this.Type = Type;
	}
	public int getSize(){
		return Size;
	}
	public void setSize(int Size){
		this.Size = Size;
	}
	public int getSpeed(){
		return Speed;
	}
	public void setSpeed(int Speed){
		this.Speed = Speed;
	}
	public String toString(){
		return("This is a bundle of " + getmodelName() + " " + Size + " GB " + Type + " " + Speed +" Ghz RAM. It's from " + getManufacturer() + " manufactured in "+ getmodelYear() + " and it costs " + getPrice() + " Euros.");
	}
}
