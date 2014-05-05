import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Main{
	private static String chip, printingType, type, technology, connection, resolution, str, x1, x2, answer, decision;
	private static int cores, RAM, ePorts,HDMIport, DVIport, COMPOSITEport, width, size, RAMSpeed, z1, z2, j=1, HWSale, peripheralSale;
	private static double clock,diameter;
	static Scanner input = new Scanner(System.in);
	static StockList shopStock;
	static OrderList ordersList;
	static SoldList soldList;

	public static void main(String[] args) {
		Initiate();
		GUI();
	}
	public static void Initiate(){
		createStock();
		ordersList = new OrderList();
		soldList = new SoldList();
		System.out.println("What is the sale on Hardware today ?(do not input %)");
		HWSale = input.nextInt();
		System.out.println("What is the sale on the Peripherals today ? (do not input %)");
		peripheralSale = input.nextInt();
	}
	public static void createStock(){
		shopStock = new StockList();
		//Starting Stock goes here
	}
	public static void GUI(){
		while (true){
			System.out.println("1. View products available");
	   	 	System.out.println("2. Orders overview");
	   	 	System.out.println("3. Viewing sales");
	   	 	System.out.println("0. Exit");
	   	 	System.out.print("> ");
	   	 	answer = input.nextLine();

			if (answer.equals ("1")){
				PcParts thing = Questions();
				System.out.println(thing);

				//elegxos ston katalogo twn diathesimwn gia to sugkekrimeno proion.epistrofi true/false
				if (Exists(thing)){

					System.out.println("The product exists. Are you interesting in buying this product? (Y/N)");
					decision = input.nextLine(); //(den exw dhlwsei thn metavliti buy)

					if ( decision == "Y"){
						Sell sl = new Sell(thing);
						soldList.add(sl);
					}else break;

				}else{
					System.out.println("We do not have this product in stock. Would you like for us to order it? (Y/N)");
					decision = input.nextLine(); 
					if ( decision == "Y"){
						Order odr = new Order(thing);
						ordersList.add(odr);
					}//else //break;
					
				}
				//break;
	   	 	}
			else if (answer.equals ("2")){
				System.out.println("test");

			}
			else if (answer.equals ("3")){
				System.out.println("test");
	   	 	}
	   	 	else if (answer.equals ("0")) break;
		}
	}	
	public static boolean Exists ( PcParts thing ){	
		int i=0;
		while ( i < shopStock.size()){
			if ( thing.getManufacturer() == shopStock.get(i).getManufacturer() ){
				if (thing.getmodelName() == shopStock.get(i).getmodelName() ){
					if (thing.getmodelYear() == shopStock.get(i).getmodelYear() ){
						if (thing.getPrice() == shopStock.get(i).getPrice() ){
							return true;
						}
					}
				}
			}		
			i++;
		}
		if ( i == shopStock.size() ) return false;
	}

	public static PcParts Questions(){
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
						PcParts mobo = MoBo(x1,x2,z1,z2);
						j++;
						break;
					case"CPU":
						PcParts cpu = Prossesor(x1,x2,z1,z2);
						j++;
						break;
					case"RAM":
						PcParts ram = Memory(x1,x2,z1,z2);
						j++;
						break;
					case"Hard Drive":
						PcParts hd = SSHD(x1,x2,z1,z2);
						j++;
						break;
					case"Keyboard":
						PcParts kb = Click(x1,x2,z1,z2);
						j++;
						break;
					case"Mouse":
						PcParts mouse = Mice(x1,x2,z1,z2);
						j++;
						break;
					case"Printer":
						PcParts printer = Paper(x1,x2,z1,z2);
						j++;
						break;
					case"Screen":
						PcParts screen = View(x1,x2,z1,z2);
						j++;
						break;
					case"GPU":
						PcParts gpu = Graphics(x1,x2,z1,z2);
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
	public static PcParts MoBo(String modelName,String manufacturer,int modelYear,int price){
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
	
	public static PcParts Prossesor(String modelName,String manufacturer,int modelYear,int price){
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
	
	public static PcParts Graphics(String modelName,String manufacturer,int modelYear,int price){
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
	
	public static PcParts Click(String modelName, String manufacturer, int modelYear, int price){
		System.out.println("What connection type is the customer ordering ?");
		connection = input.nextLine();
		x1 = modelName;
		x2 = manufacturer;
		z1 = modelYear;
		z2 = price;
		Keyboard KB = new Keyboard (connection, x1, x2, z1, z2);
		return KB;
	}

	public static PcParts Mice(String modelName, String manufacturer, int modelYear, int price){
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

	public static PcParts Paper(String modelName, String manufacturer, int modelYear, int price){
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

	public static PcParts View(String modelName, String manufacturer, int modelYear, int price){
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
	public static PcParts Memory(String modelName, String manufacturer, int modelYear, int price){
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

	public static PcParts SSHD(String modelName, String manufacturer, int modelYear, int price){
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
