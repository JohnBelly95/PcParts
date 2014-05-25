
import java.util.*;
import java.text.*;

public class Order extends PcParts{
	private String name, expectedDate, orderDate;
	private int orderNo=1;
	private long phone;
	private PcParts thing;
	private Scanner input = new Scanner(System.in);
	private double fp;
	public static boolean status;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	
	public Order(){
		thing = null;
		name = null;
		phone = 2102121236;
		expectedDate = null;
		orderDate = null;
		fp = 20.0;
	}

	public Order(PcParts thing, String name, long phone, String expectedDate, double fp){
		this.thing = thing;
		this.name = name;
		this.phone = phone;
		this.expectedDate = expectedDate;
		this.fp = fp;
		Date today = new Date();
		orderDate = formatter.format(today);
		status = false;
		orderNo++;
	}
	
	public boolean getStatus(){
		return status;
	}
	public void setStatus(boolean status){
		this.status = status;
	}
	
	public PcParts getThing(){
		return thing;
	}	
	public void setThing(PcParts thing){
		this.thing = thing;
	}
	
	public String getName(){
		return name;
	}	
	public void setName(String name){
		this.name = name;
	}
	
	public long getPhone(){
		return phone;
	}	
	public void setPhone(long phone){
		this.phone = phone;
	}
	
	public double getFP(){
		return fp;
	}	
	public void setFP(double fp){
		this.fp = fp;
	}
	
	public String getExpectedDate(){
		return expectedDate;
	}
	public void setExpectedDate(String ExpectedDate){
		this.expectedDate = expectedDate;
	}
	
	public int getOrderNo(){
		return orderNo;
	}
	public void setOrderNo(int orderNo){
		this.orderNo = orderNo;
	}
	
	public String getOrderDate(){
		return orderDate;
	}
	public void setOrderDate(String orderDate){
		this.orderDate = orderDate;
	}
	
	public String toString(){
		return ("\n\t\tNAME: "+name+ "\n\t\tPHONE: " +phone+ "\n\t\tFINAL_PRICE: "+fp+"\n\t\tORDER_DATE: "+orderDate+ "\n\t\tARRIVAL_DATE: " +expectedDate+"\n\t\tNUMBER: "+orderNo+thing);
	}
}
