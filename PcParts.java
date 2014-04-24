public class PcParts{
	private String modelName;
	private String Manufacturer;
	private int modelYear;
	private int Price;

	public PcParts(){
		modelName = "Shizzle";
		Manufacturer= "Drizzle";
		modelYear = 1995;
		Price = 1000000;
	}
	public PcParts(String modelName, String Manufacturer, int modelYear, int Price){
		this.modelName = modelName;
		this.Manufacturer = Manufacturer;
		this.modelYear = modelYear;
		this.Price = Price;
	}
}
