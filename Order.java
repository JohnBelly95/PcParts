
import java.util.*;
import java.text.*;

public class Order extends PcParts{
	private String name, expectedDate, state, str;
	private int phone, orderNo=1, price, sale;
	private PcParts thing;
	private Scanner input = new Scanner(System.in);
	private double fp;
	public static boolean status;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	
	
	public Order(){
		
	}
	/*public static void main(String[] args) {											//for testing purposes.
		PcParts i54670k = new CPU(3.4,4,"i5-4670k","Intel",2013,200);
		Order cpu = new Order("GP",123,"12/12/12","12/12/12",i54670k);
		System.out.println(cpu.thing.getManufacturer());
	}*/
	public Order(PcParts thing, String name, int phone, String expectedDate, double fp){
		this.thing = thing;
		this.name = name;
		this.phone = phone;
		this.expectedDate= expectedDate;
		this.fp = fp;
		Date date = new Date();
		status = false;
		orderNo++;
	}
	
	public boolean getstatus(){
		return status;
	}
	public void setstatus(){
		this.status = status;
	}
	
	public PcParts getthing(){
		return thing;
	}	
	public void setthing(PcParts thing){
		this.thing = thing;
	}
	
	public String getname(){
		return name;
	}	
	public void setname(String name){
		this.name = name;
	}
	
	public int getphone(){
		return phone;
	}	
	public void setphone(int phone){
		this.phone = phone;
	}
	
	public double getfp(){
		return fp;
	}	
	public void setfp(double fp){
		this.fp = fp;
	}
	
	public String toString(){
		return ("The customer's name is: "+name+ " and his phone is: " +phone+ " . About the item : " +thing+ ". The final price is "+fp+ " Euros and should be available on : " +expectedDate);
	}
}
