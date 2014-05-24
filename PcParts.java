public class PcParts{
	public String modelName;
	public String Manufacturer;
	public int modelYear;
	public int Price;
	public boolean isHardware;

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
	public String getManufacturer(){
		return Manufacturer;
	}
	public void setManufacturer(String Manufacturer){
		this.Manufacturer = Manufacturer;
	}
	public String getmodelName(){
		return modelName;
	}
	public void setmodelName(String modelName){
		this.modelName = modelName;
	}
	public int getmodelYear(){
		return modelYear;
	}
	public void setmodelYear(int modelYear){
		this.modelYear = modelYear;
	}
	public int getPrice(){
		return Price;
	}
	public void setPrice(int Price){
		this.Price = Price;
	}
	public String toString(){
		return ("\n\t\tMODEL_NAME: "+getmodelName()+"\n\t\tMANUFACTURER: "+getManufacturer()+"\n\t\tYEAR: "+getmodelYear()+"\n\t\tPRICE: "+getPrice());
	}
}
