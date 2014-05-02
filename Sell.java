import java.util.*;
import java.util.Scanner;

public class Sell{
	private String name, saleDate;
	private int phone, saleNo=1, Price;
	private double fp;
	private PcParts thing;
	
	static Scanner input = new Scanner(System.in);

	public Sell(){
		name = "JZ";
		phone = 2109330666;
		saleDate="12/12/12";
	}
	
	public Sell (PcParts thing){
		System.out.println("Customer's name : ");
		name = input.nextLine();
		System.out.println("Customer's phone : ");
		phone = input.nextInt();
		System.out.println("Sale date : ");
		saleDate = input.nextLine();
		fp = thing.getPrice()* (1 - thing.sale/100);                  //finding the final price
		System.out.println("The final price is : "+ fp +" Euros.");
		saleNo++;
	}
	
}
