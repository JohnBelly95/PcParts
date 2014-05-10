public class Motherboard extends Hardware{
	private String Chip;
	private int RAMSize, ExpansionSlots;
	private static boolean isHardware;
	public Motherboard(){
		super();
		Chip = "Intel";
		RAMSize = 64;
		ExpansionSlots = 6;
		isHardware = super.isHardware;
	}
	public Motherboard(String Chip, int RAMSize, int ExpansionSlots, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Chip = Chip;
		this.RAMSize = RAMSize;
		this.ExpansionSlots = ExpansionSlots;
		isHardware = super.isHardware;
	}
	public String getChip(){
		return Chip;
	}
	public void setChip(String Chip){
		this.Chip = Chip;
	}
	public int getRAMSize(){
		return RAMSize;
	}
	public void setRAMSize(int RAMSize){
		this.RAMSize = RAMSize;
	}
	public int getExpansionSlots(){
		return ExpansionSlots;
	}
	public void setExpansionSlots(int ExpansionSlots){
		this.ExpansionSlots = ExpansionSlots;
	}
	public String toString(){
		System.out.println("===============================================================");
		return("This is a Motherboard from " + getManufacturer() + " from " + getmodelYear() + ". It supports up to " + RAMSize + " GB of RAM and has " + ExpansionSlots + " Expansion Slots. It's a "+ getmodelName() + " model for the " + Chip + " Chipset. Its price is " + getPrice() + " Euros.");
	}//This is here for testing purposes feel free to ignore.
}
