public class Order{
	private String name, orderDate, arrivalDate, state;
	private int phone, orderNo, Price;
	private PcParts thing;
	
	public Order(){
		name = "JZ";
		phone = 2109330666;
		orderDate="12/12/12";
		arrivalDate="1/1/13";
	}
	public static void main(String[] args) {											//for testing purposes.
		PcParts i54670k = new CPU(3.4,4,"i5-4670k","Intel",2013,200);
		Order cpu = new Order("GP",123,"12/12/12","12/12/12",i54670k);
		System.out.println(cpu.thing.getManufacturer());
	}
	public Order(String name, int phone, String orderDate, String arrivalDate, PcParts thing){
		this.name = name;
		this.phone = phone;
		this.orderDate = orderDate;
		this.arrivalDate = arrivalDate;
		this.thing = thing;
	}
}
