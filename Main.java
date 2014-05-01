import java.io.*;
import java.util.Scanner;
public class Main{private static String chip, printingType, type, technology, connection, resolution, str, x1, x2;
	private static int cores, RAM, ePorts,HDMIport, DVIport, COMPOSITEport, width, size, RAMSpeed, z1, z2, j=1;
	private static double clock,diameter;
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		createStock();
		Questions();
	}
	
	public static void createStock(){
		Stock shopStock = new Stock();
	}
	public static void Questions(){
		while(j<2){
			System.out.println("What does the customer want ?");
			str = input.nextLine();
			if(str.equals("Motherboard")||str.equals("CPU")||str.equals("RAM")||str.equals("Hard Drive")||str.equals("GPU")||str.equals("Keyboard")||str.equals("Mouse")||str.equals("Printer")||str.equals("Screen")){
				System.out.println("You will now be asked to input the specifications of the desired product");
				System.out.println("Please enter the model name of the desired part. ");
				x1 = input.nextLine();
				System.out.println("Model name is set to: " + x1);
				System.out.println("Please enter the manufacturer of the desired part. ");
				x2 = input.nextLine();
				System.out.println("Manufacturer is set to: " + x2);
				System.out.println("Please enter the year the desired product was released. ");
				z1 = input.nextInt();
				System.out.println("Year of release was set to: " + z1);
				System.out.println("Please enter the price of the desired product. ");
				z2 = input.nextInt();
				System.out.println("Price entered was: " + z2);
				switch(str){
					case"Motherboard":
						Motherboard mobo = Motherboard(x1,x2,z1,z2);
						j++;
						break;
					case"CPU":
						CPU cpu = CPU(x1,x2,z1,z2);
						j++;
						break;
					case"RAM":
						RAM ram = RAM(x1,x2,z1,z2);
						j++;
						break;
					case"Hard Drive":
						HardDrive hd = HardDrive(x1,x2,z1,z2);
						j++;
						break;
					case"Keyboard":
						Keyboard kb = Keyboard(x1,x2,z1,z2);
						j++;
						break;
					case"Mouse":
						Mouse mouse = Mouse(x1,x2,z1,z2);
						j++;
						break;
					case"Printer":
						Printer printer = Printer(x1,x2,z1,z2);
						j++;
						break;
					case"Screen":
						Screen screen = Screen(x1,x2,z1,z2);
						j++;
						break;
					case"GPU":
						GPU gpu = GPU(x1,x2,z1,z2);
						j++;
						break;
					default:
						break;
				}
			}else{
				System.out.println("There was an error during the process. The process will now restart.");
			}
		}
	}
	public static Motherboard Motherboard(String modelName,String manufacturer,int modelYear,int price){
		System.out.println("Please enter the chip supported by the motherboard.");
		chip = input.next();
		System.out.println("Given chip is: " + chip);
		System.out.println("Please enter the size of RAM supported.");
		RAM = input.nextInt();
		System.out.println("Supported RAM is set at: " + RAM);
		System.out.println("Please enter the number of expansion ports. ");
		ePorts = input.nextInt();
		System.out.println("Expansion ports are set to: " + ePorts);
		x1 = modelName;
		x2 = manufacturer;
		z1 = modelYear;
		z2 = price;
		Motherboard MoBo = new Motherboard(chip,RAM,ePorts, x1, x2, z1, z2);
		return MoBo;
	}
	public static CPU CPU(String modelName,String manufacturer,int modelYear,int price){
		System.out.println("Please enter the number of cores in the desired CPU");
		cores = input.nextInt();
		System.out.println("Cores were set to " + cores);
		System.out.println("Please enter the core clock speed of the desired CPU");
		clock = input.nextDouble();
		System.out.println("Core clock speed was set to " + clock);
		x1 = modelName;
		x2 = manufacturer;
		z1 = modelYear;
		z2 = price;
		CPU cpu = new CPU(clock,cores,x1,x2,z1,z2);
		return cpu;
	}
	public static GPU GPU(String modelName,String manufacturer,int modelYear,int price){
		System.out.println("Please enter the chipset of the GPU the costumer wants to buy.");
		chip = input.next();
		System.out.println("Please enter the amount of RAM the desired GPU has.");
		RAM = input.nextInt();
		x1 = modelName;
		x2 = manufacturer;
		z1 = modelYear;
		z2 = price;
		GPU gpu = new GPU(chip, RAM,x1,x2,z1,z2);
		return gpu;
	}
	public static Keyboard Keyboard(String modelName, String manufacturer, int modelYear, int price){
		System.out.println("What connection type is the customer ordering ?");
		connection = input.nextLine();
		x1 = modelName;
		x2 = manufacturer;
		z1 = modelYear;
		z2 = price;
		Keyboard KB = new Keyboard (connection, x1, x2, z1, z2);
		return KB;
	}

	public static Mouse Mouse(String modelName, String manufacturer, int modelYear, int price){
		System.out.println("What connection type does the desired product have ?");
		connection = input.next();
		System.out.println("What technology does the desired mouse use ?");
		technology = input.next();
		x1 = modelName;
		x2 = manufacturer;
		z1 = modelYear;
		z2 = price;
		Mouse MS = new Mouse (connection, technology, x1, x2, z1, z2);
		return MS;
	}

	public static Printer Printer(String modelName, String manufacturer, int modelYear, int price){
		System.out.println("What printing type is the customer ordering ?");
		printingType = input.next();
		System.out.println("What technology is the customer ordering ?");
		technology = input.next();
		x1 = modelName;
		x2 = manufacturer;
		z1 = modelYear;
		z2 = price;
		Printer PR = new Printer (printingType, technology, x1, x2, z1, z2);
		return PR;
	}

	public static Screen Screen(String modelName, String manufacturer, int modelYear, int price){
		System.out.println("What screen type is the customer ordering ?");
		type = input.next();
		System.out.println("What size is the screen the customer ordering ?");
		diameter = input.nextDouble();
		System.out.println("What resolution does the screen the customer ordering have ?");
		resolution = input.next();
		System.out.println("How many HDMI ports does the screen the customer ordering have ?");
		HDMIport = input.nextInt();
		System.out.println("How many DVI ports is the customer ordering ?");
		DVIport = input.nextInt();
		System.out.println("How many Composite ports is the customer ordering ?");
		COMPOSITEport = input.nextInt();	
		x1 = modelName;
		x2 = manufacturer;
		z1 = modelYear;
		z2 = price;
		Screen SCR = new Screen (type, diameter, resolution, HDMIport, DVIport, COMPOSITEport, x1, x2, z1, z2);
		return SCR;
	}
	public static RAM RAM(String modelName, String manufacturer, int modelYear, int price){
		System.out.println("What RAM type is the customer ordering ?");
		type = input.next();
		System.out.println("What size is the customer ordering ?");
		size = input.nextInt();
		System.out.println("What speed type is the customer ordering ?");
		RAMSpeed = input.nextInt();
		x1 = modelName;
		x2 = manufacturer;
		z1 = modelYear;
		z2 = price;
		RAM RM = new RAM (type, size, RAMSpeed, x1, x2, z1, z2);
		return RM;
	}

	public static HardDrive HardDrive(String modelName, String manufacturer, int modelYear, int price){
		System.out.println("What Hard drive type is the customer ordering ?");
		type = input.next();
		System.out.println("What is the width (inches) of the product that the customer ordering ?");
		width = input.nextInt();
		System.out.println("What size (GB) is the customer ordering ?");
		size = input.nextInt();
		x1 = modelName;
		x2 = manufacturer;
		z1 = modelYear;
		z2 = price;
		HardDrive HDRV = new HardDrive(type, size, width, x1, x2, z1, z2);
		return HDRV;
	}
}
