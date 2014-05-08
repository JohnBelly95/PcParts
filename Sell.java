import java.util.*;
import java.text.*;

public class Sell extends PcParts{
	private String name, date, str;
	private int phone, saleNo=1, Price;
	private double fp;
	private PcParts thing;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	static Scanner input = new Scanner(System.in);

	public Sell(){
		name = "JZ";
		phone = 2109330666;
		date="12/12/12";
	}
	
	public Sell (PcParts thing){
		System.out.println("You will now be asked to input the customers credentials");
		System.out.println("Please enter the customer's full name.");
		System.out.print(">");
		name = input.nextLine();
		System.out.println("Please enter the customer's phone.");
		System.out.print(">");
		phone = input.nextInt();
		Date date = new Date();
		System.out.println("Is the desired item on sale ? (Y/N)");
		System.out.print(">");
		str = input.nextLine();
		/*if(str.equals("Y")){
			if (thing.isHardware == true){
				fp = thing.getPrice()* (1 - Main.HWSale/100);                  //finding the final price
				System.out.println("The final price is : "+ fp +" Euros.");
			}else{
				fp = thing.getPrice()* (1 - Main.peripheralSale/100);                  //finding the final price
				System.out.println("The final price is : "+ fp +" Euros.");
			}
		}else{
			fp = thing.getPrice();
		}*/
		fp = thing.getPrice();
		saleNo++;
	}
	
	public String toString(){
		return ("The customer's name is: "+name+ " and his phone is: " +phone+ " . About the item : " +thing+ ". The final price is "+fp+ " Euros" );
	}
	
}
