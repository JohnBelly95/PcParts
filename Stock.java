import java.util.*;

public class Stock extends PcParts{
	private PcParts thing;
	private int availableStock;
	
	public Stock(PcParts thing){
		this.thing = thing;
		availableStock = 2;
	}
	public int getAvailableStock(){
		return availableStock;
	}
	public void setAvailableStock(int availableStock){
		this.availableStock = availableStock;
	}
	public String toString(){
		System.out.println(thing);
		return ("===");
	}
	public String getManufacturer(){
		return thing.Manufacturer;
	}
	public String getmodelName(){
		return thing.modelName;
	}
	public int getmodelYear(){
		return thing.modelYear;
	}
	public int getPrice(){
		return thing.Price;
	}
}
