public class HardDrive extends Hardware{
	private String Type;
	private int Size;
	private double Width;
	private static boolean isHardware;
	
	public HardDrive(){
		super();
		Type = "HDD";
		Size = 1000;    //choritikotita (GB)
		Width= 3.5;	//megethos (inches)
		isHardware = super.isHardware;
	}
	public HardDrive(String Type, int Size, double Width,  String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		/*switch(Type){
			case"DDR":
				this.Type = "DDR";
				break;
			case"DDR2": 
				this.Type = "DDR2";
				break;
			case"DDR3": 
				this.Type = "DDR3";
				break;
			default: 
				this.Type = "Invalid Memory Type";
				break;
		}*/
		this.Size = Size;
		this.Width=Width;
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
	public double getWidth(){
		return Width;
	}
	public void setWidth(double Width){
		this.Width = Width;
	}
	public String toString(){
		System.out.println("===============================================================");
		return("This is a " + getmodelName()+" "+ Width + " inch " + Type +" with " + Size + " GB of space. It was manufactured in " + getmodelYear() +" from " + getManufacturer()+ " and it costs " + getPrice() + " Euros");
	}
}
