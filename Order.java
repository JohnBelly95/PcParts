import java.io.*;
import java.util.Scanner;

public class Order{
	private int j = 1;
	private String str;
	Scanner input = new Scanner(System.in);

	public Order(String Name){
		System.out.println("What is the customer ordering ?");
		str = input.nextLine();
		while(j!=2)
			switch(str){
				case"Motherboard":
					System.out.println("Please input the specifications for the desired product")
			}
		}
	}
}
