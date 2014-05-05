public class Peripherals extends PcParts{
	private int sale;
	public Peripherals (){
		super();
		sale = 0;
	}
	public Peripherals(String modelName, String Manufacturer, int modelYear, int Price){
		super(modelName, Manufacturer, modelYear, Price);
		sale = 0;
	}
	public int getSale(){
		return sale;
	}
	public void setSale(int Sale){
		this.sale = sale;
	}
}
