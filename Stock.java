import java.util.*;

public class Stock{
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
}
