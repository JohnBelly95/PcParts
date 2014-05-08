
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
	public Order(PcParts thing){
		System.out.println("You will now be asked to input the customers credentials");
		System.out.println("Please enter the customer's full name.");
		System.out.print(">");
		name = input.nextLine();
		System.out.println("Please enter the customer's phone.");
		System.out.print(">");
		phone = input.nextInt();
		System.out.println("When do we expect the item to be available ?");
		System.out.print(">");
		expectedDate = input.nextLine();
		Date date = new Date();
		this.thing = thing;
		System.out.println("Is the desired item on sale ? (Y/N)");
		System.out.print(">");
		str = input.nextLine();
		status = false; // false means expected order
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
		orderNo++;
	}
	
	public String toString(){
		return ("The customer's name is: "+name+ " and his phone is: " +phone+ " . About the item : " +thing+ ". The final price is "+fp+ " Euros and should be available on : " +expectedDate);
	}
}
