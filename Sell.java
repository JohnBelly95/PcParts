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
		fp = thing.getPrice()* (1 - thing.getSale()/100);                  //finding the final price
		System.out.println("The final price is : "+ fp +" Euros.");
		saleNo++;
	}
	
	public String toString(){
		return ("The customer's name is: "+name+ " and his phone is: " +phone+ " . About the item : " +thing+ ". The final price is "+fp+ " Euros" );
	}
	
}
