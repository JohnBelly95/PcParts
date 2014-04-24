public class Motherboard extends Hardware{
	private String Chip;
	private int RAMSize;
	private int ExpansionSlots;
	public Motherboard(){
		super();
		Chip = "Intel";
		RAMSize = 64;
		ExpansionSlots = 6;
	}
	public Motherboard(String Chip, int RAMSize, int ExpansionSlots, String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		this.Chip = Chip;
		this.RAMSize = RAMSize;
		this.ExpansionSlots = ExpansionSlots;
	}
	public
}
