import java.util.*;
import java.text.*;

public class Sell extends PcParts{
	private String name, today, str, date, sellDate;
	private int saleNo=1, Price;
	private long phone;
	private double fp;
	private PcParts thing;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	static Scanner input = new Scanner(System.in);

	public Sell(){
		name = "JZ";
		phone = 2109330666;
		today = "12/12/12";
	}
	
	public Sell (PcParts thing, String name, long phone, double fp){
		this.thing = thing;
		this.name = name;
		this.phone = phone;
		this.fp = fp;
		Date today = new Date();
		String sellDate = formatter.format(today);
		saleNo++;
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
	
	public double getFp(){
		return fp;
	}
	public void setFp(double fp){
		this.fp = fp;
	}
	
	public int getSaleNo(){
		return saleNo;
	}
	public void setSaleNo(int saleNo){
		this.saleNo = saleNo;
	}
	
	public String getSellDate(){
		return sellDate;
	}
	public void setSellDate(String sellDate){
		this.sellDate = sellDate;
	}
	
	public String toString(){
		return ("\n\t\tNAME: "+name+ "\n\t\tPHONE: " +phone+thing );
	}
	
}
