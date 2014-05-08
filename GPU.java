public class GPU extends Hardware{
	private String Chipset;
	private int Memory;
	private static boolean isHardware;

	public GPU(){
		super();
		Chipset = " ";
		Memory = 0;
	}

	public GPU(String Chipset, int Memory, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price, isHardware);
		this.Chipset = Chipset;
		this.Memory = Memory;
	}

	public String getChipset(){
		return Chipset;
	}
	public void setChipset(String Chipset){
		this.Chipset = Chipset;
	}

	public int getMemory(){
		return Memory;
	}
	public void setMemory(int Memory){
		this.Memory = Memory;
	}

	public String toString(){
		return ("This is a GPU from " + getManufacturer() + " from " + getmodelYear() + ". It has " + Memory + " GB of memory and it's a "+ getmodelName() + " model for the " + Chipset + " Chipset. Its price is " + getPrice() + " Euros.");
	}
}
