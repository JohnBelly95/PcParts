import java.util.*;
import java.text.*;

public class Sell extends PcParts{
	private String name, date, str;
	private int saleNo=1, Price;
	private long phone;
	private double fp;
	private PcParts thing;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	static Scanner input = new Scanner(System.in);

	public Sell(){
		name = "JZ";
		phone = 2109330666;
		date="12/12/12";
	}
	
	public Sell (PcParts thing, String name, long phone, double fp){
		this.thing = thing;
		this.name = name;
		this.phone = phone;
		this.fp = fp;
		Date date = new Date();
		saleNo++;
	}
	
	public String toString(){
		return ("The customer's name is: "+name+ " and his phone is: " +phone+ " . About the item : " +thing+ ". The final price is "+fp+ " Euros" );
	}
	
}
