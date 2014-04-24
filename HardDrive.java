public class HardDrive extends Hardware{
	private String Type;
	private int Size;
	private double Width;
	
	public RAM(){
		super();
		Type = "HDD";
		Size = 1000;
		Width= 3.5;		
	}
	public RAM(String Type, int Size, int Width,  String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Type = Type;
		this.Size = Size;
		this.Width=Width;
	}
	public String toString(){
		return("This is a " + getmodelName()+" "+ Width + " inch " + Type +" with " + Size + " GB of space. It was manufactured in " + getmodelYear() +" from " + getManufacturer+ " and it costs " + getPrice() + " Euros");
	}
}
