public class Hardware extends PcParts{
	public int sale;
	public Hardware(){
		super();
		sale = 0;
	}
	public Hardware(String modelName, String Manufacturer, int modelYear, int Price){
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
