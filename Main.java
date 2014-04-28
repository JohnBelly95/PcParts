import java.io.*;
import java.util.Scanner;
public class Main{
	private static int j = 1;
	private static String str;
	private static String x1;
	private static String x2;
	private static String Chip, PrintingType, Type, Technology, Connection, Resolution;
	private static int z1;
	private static int z2;
	private static int Cores, RAM, EPorts,HDMIport, DVIport, COMPOSITEport, Width;
	private static double Clock,Size,Speed;
	private static double y2;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(j<2){
			System.out.println("What does the customer want ?");
			str = input.nextLine();
			
			switch(str){
				case"Motherboard":
					x1 = modelName();
					x2 = Manufacturer();
					z1 = modelYear();
					z2 = Price();
					Motherboard Part = Motherboard(x1,x2,z1,z2);
					j++;
					//System.out.println(mobo);
					break;
				case"CPU":
					x1 = modelName();
					x2 = Manufacturer();
					z1 = modelYear();
					z2 = Price();
					CPU Part = CPU(x1,x2,z1,z2);
					j++;
					//System.out.println(cpu);
					break;
				case"RAM":
					x1 = modelName();
					x2 = Manufacturer();
					z1 = modelYear();
					z2 = Price();
					RAM Part = RAM(x1,x2,z1,z2);
					j++;
					break;
				case"Hard Drive":
					x1 = modelName();
					x2 = Manufacturer();
					z1 = modelYear();
					z2 = Price();
					HardDrive Part = HardDrive(x1,x2,z1,z2);
					j++;
					break;
				case"Keyboard":
					x1 = modelName();
					x2 = Manufacturer();
					z1 = modelYear();
					z2 = Price();
					Keyboard Part = Keyboard(x1,x2,z1,z2);
					j++;
					break;
				case"Mouse":
					x1 = modelName();
					x2 = Manufacturer();
					z1 = modelYear();
					z2 = Price();
					Mouse Part = Mouse(x1,x2,z1,z2);
					j++;
					break;
				case"Printer":
					x1 = modelName();
					x2 = Manufacturer();
					z1 = modelYear();
					z2 = Price();
					Printer Part = Printer(x1,x2,z1,z2);
					j++;
					break;
				case"Screen":
					x1 = modelName();
					x2 = Manufacturer();
					z1 = modelYear();
					z2 = Price();
					Screen Part = Screen(x1,x2,z1,z2);
					j++;
					break;
				case"GPU":
					x1 = modelName();
					x2 = Manufacturer();
					z1 = modelYear();
					z2 = Price();
					GPU Part = GPU(x1,x2,z1,z2);
					j++;
					break;
				default:
					System.out.println("There was an error during the process. The process will now restart.");
					break;
			}
		}
	}
	public static String modelName(){
		System.out.println("You will now be asked to input the specifications of the desired product");
		System.out.println("Please enter the model name of the desired part. ");
		x1 = input.nextLine();
		System.out.println("Model name is set to: " + x1);
		return x1;
	}
	public static String Manufacturer(){
		System.out.println("Please enter the manufacturer of the desired part. ");
		x2 = input.nextLine();
		System.out.println("Manufacturer is set to: " + x2);
		return x2;
	}
	public static int modelYear(){
		System.out.println("Please enter the year the desired product was released. ");
		z1 = input.nextInt();
		System.out.println("Year of release was set to: " + z1);
		return z1;
	}
	public static int Price(){
		System.out.println("Please enter the price of the desired product. ");
		z2 = input.nextInt();
		System.out.println("Price entered was: " + z2);
		return z2;
	}
	public static Motherboard Motherboard(String modelName,String Manufacturer,int modelYear,int Price){
		System.out.println("Please enter the chip supported by the motherboard.");
		Chip = input.nextLine();
		System.out.println("Given chip is: " + Chip);
		System.out.println("Please enter the size of RAM supported.");
		RAM = input.nextInt();
		System.out.println("Supported RAM is set at: " + RAM);
		System.out.println("Please enter the number of expansion ports. ");
		EPorts = input.nextInt();
		System.out.println("Expansion ports are set to: " + z2);
		x1 = modelName;
		x2 = Manufacturer;
		z1 = modelYear;
		z2 = Price;
		Motherboard MoBo = new Motherboard(Chip,RAM,EPorts, x1, x2, z1, z2);
		return MoBo;
	}
	public static CPU CPU(String modelName,String Manufacturer,int modelYear,int Price){
		System.out.println("Please enter the number of cores in the desired CPU");
		Cores = input.nextInt();
		System.out.println("Cores were set to " + Cores);
		System.out.println("Please enter the core clock speed of the desired CPU");
		Clock = input.nextDouble();
		System.out.println("Core clock speed was set to " + Clock);
		x1 = modelName;
		x2 = Manufacturer;
		z1 = modelYear;
		z2 = Price;
		CPU cpu = new CPU(Clock,Cores,x1,x2,z1,z2);
		return cpu;
	}
	public static GPU GPU(String modelName,String Manufacturer,int modelYear,int Price){
		System.out.println("Please enter the chipset of the GPU the costumer wants to buy.");
		Chip = input.nextLine();
		System.out.println("Please enter the amount of RAM the desired GPU has.");
		RAM = input.nextInt();
		x1 = modelName;
		x2 = Manufacturer;
		z1 = modelYear;
		z2 = Price;
		GPU gpu = new GPU(Chip, RAM,x1,x2,z1,z2);
		return gpu;
	}
	public static Keyboard Keyboard(String modelName, String Manufacturer, int modelYear, int Price){
		System.out.println("What connection type is the customer ordering ?");
		Connection = input.nextLine();
		x1 = modelName;
		x2 = Manufacturer;
		z1 = modelYear;
		z2 = Price;
		Keyboard KB = new Keyboard (Connection, x1, x2, z1, z2);
		return KB;
	}

	public static Mouse Mouse(String modelName, String Manufacturer, int modelYear, int Price){
		System.out.println("What connection type does the desired product have ?");
		Connection = input.nextLine();
		System.out.println("What technology does the desired mouse use ?");
		Technology = input.nextLine();
		x1 = modelName;
		x2 = Manufacturer;
		z1 = modelYear;
		z2 = Price;
		Mouse MS = new Mouse (Connection, Technology, x1, x2, z1, z2);
		return MS;
	}

	public static Printer Printer(String modelName, String Manufacturer, int modelYear, int Price){
		System.out.println("What printing type is the customer ordering ?");
		PrintingType = input.nextLine();
		System.out.println("What technology is the customer ordering ?");
		Technology = input.nextLine();
		x1 = modelName;
		x2 = Manufacturer;
		z1 = modelYear;
		z2 = Price;
		Printer PR = new Printer (PrintingType, Technology, x1, x2, z1, z2);
		return PR;
	}

	public static Screen Screen(String modelName, String Manufacturer, int modelYear, int Price){
		System.out.println("What screen type is the customer ordering ?");
		Type = input.nextLine();
		System.out.println("What size is the customer ordering ?");
		Size = input.nextDouble();
		System.out.println("What resolution is the customer ordering ?");
		Resolution = input.nextLine();
		System.out.println("How many HDMI ports is the customer ordering ?");
		HDMIport = input.nextInt();
		System.out.println("How many DVI ports is the customer ordering ?");
		DVIport = input.nextInt();
		System.out.println("How many Composite ports is the customer ordering ?");
		COMPOSITEport = input.nextInt();	
		x1 = modelName;
		x2 = Manufacturer;
		z1 = modelYear;
		z2 = Price;
		Screen SCR = new Screen (Type, Size, Resolution, HDMIport, DVIport, COMPOSITEport, x1, x2, z1, z2);
		return SCR;
	}
	public static RAM RAM(String modelName, String Manufacturer, int modelYear, int Price){
		System.out.println("What RAM type is the customer ordering ?");
		Type = input.nextLine();
		System.out.println("What size is the customer ordering ?");
		Size = input.nextInt();
		System.out.println("What speed type is the customer ordering ?");
		Speed = input.nextInt();
		x1 = modelName;
		x2 = Manufacturer;
		z1 = modelYear;
		z2 = Price;
		RAM RM = new RAM (Type, Size, Speed, x1, x2, z1, z2);
		return RM;
	}

	public static HardDrive HardDrive(String modelName, String Manufacturer, int modelYear, int Price){
		System.out.println("What Hard drive type is the customer ordering ?");
		Type = input.nextLine();
		System.out.println("What is the width (inches) of the product that the customer ordering ?");
		Width = input.nextInt();
		System.out.println("What size (GB) is the customer ordering ?");
		Size = input.nextInt();
		x1 = modelName;
		x2 = Manufacturer;
		z1 = modelYear;
		z2 = Price;
		HardDrive HDRV = new HardDrive (Type, Size, Width, x1, x2, z1, z2);
		return HRDV;
	}
}
