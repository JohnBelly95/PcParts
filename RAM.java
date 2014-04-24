public class RAM extends Hardware{
	private String Type;
	private int Size;
	private int Speed;
	
	public RAM(){
		super();
		Type = "DDR3";
		Size = 8;
		Speed= 2000;		
	}
	public RAM(String Type, int Size, int Speed,  String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Type = Type;
		this.Size = Size;
		this.Speed=Speed;
	}
	public String toString(){
		return("This is a bundle of " + getmodelName() + " " + RAMSize + " GB " + Type + " " + Speed +" Ghz RAM. It's from " + getManufacturer() + " manufactured in "+ getmodelYear() + " and it costs " + getPrice() + " Euros.");
	}
}
