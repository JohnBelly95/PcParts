/*
ZACHARIADIS IOANNIS P3130063 2o EKSAMINO
DERVI THEODORA      P3130051 2o EKSAMINO
*/
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class mainApp{
	private static String chip, printingType, type, technology, connection, resolution,str, str1, str2, x1, x2, answer, decision, name, expectedDate, response;
	private static int cores, RAM, ePorts,HDMIport, DVIport, COMPOSITEport, size, RAMSpeed, z1, z2, j=1, reply;
	private static double clock,diameter,fp, width;
	private static long phone;
	private static boolean check, status;
	public static int HWSale, peripheralSale;
	static Scanner input = new Scanner(System.in);
	private static List<Stock> shopStock = new ArrayList<Stock>();
	private static List<Order> ordersList = new ArrayList<Order>();
	private static List<Sell> soldList = new ArrayList<Sell>();
	private static PcParts item, part;
	public static TextReader tr = new TextReader();
	public static TextWriter tw = new TextWriter();
	public static void main(String[] args) {
		Initiate();
		GUI();
	}
	public static void Initiate(){
		createStock();
		System.out.println("What is the sale on Hardware today ?(do not input %)");
		HWSale = input.nextInt();
		System.out.println("What is the sale on the Peripherals today ? (do not input %)");
		peripheralSale = input.nextInt();
	}
	public static void createStock(){	//Edw tha mpoune ta FileReader. Ena gia to kathena.
		
		tr.StockTextReader(shopStock);
		tr.OrderTextReader(ordersList);
		tr.SoldTextReader(soldList);
		//Starting Stock goes here		
		PcParts Z87k = new Motherboard("Intel",32,7,"Z87-K","Asus",2013,112);
		Stock MoBo = new Stock(Z87k);
		shopStock.add(MoBo);
		
		CPU i54670k = new CPU(3.4,4,"i5-4670k","Intel",2013,200);
		Stock CPU1 = new Stock(i54670k);
		shopStock.add(CPU1);
		
		PcParts sf4390 = new GPU("AMD",4,"sf-4390","Radeon",2012,30);
		Stock GPU1 = new Stock(sf4390);
		shopStock.add(GPU1);
		
		PcParts kr4520 = new RAM("DDR",4,1600,"kr-4520","Kingston",2014,10);
		Stock RAM1 = new Stock(kr4520);
		shopStock.add(RAM1);
		
		PcParts Barracuda = new HardDrive("SSD",750,3.5,"Barracuda","Seagate",2014,30);
		Stock HDRV1 = new Stock(Barracuda);
		shopStock.add(HDRV1);
		
		PcParts en33s = new Screen("LED",20,"1600x900",1,2,2,"en-33s","LG",2011,83);
		Stock SCR1 = new Stock(en33s);
		shopStock.add(SCR1);
		
		PcParts hvk806 = new Keyboard("wireless","hv-k806","Havit",2012,5);
		Stock KB1 = new Stock(hvk806);
		shopStock.add(KB1);
		
		PcParts msq50 = new Mouse("wired","optical","msq-50","Roccat",2010,3);
		Stock MS1 = new Stock(msq50);
		shopStock.add(MS1);
		
		PcParts mg2550 = new Printer("inkjet","color","mg2550","Canon",2013,45);
		Stock PR1 = new Stock(mg2550);
		shopStock.add(PR1);
		tw.StockTextWriter(shopStock);
	}
	public static void GUI(){
		while (true){
			System.out.println("1. View products available");
	   	 	System.out.println("2. Overview orders");
	   	 	System.out.println("3. Overview sales");
	   	 	System.out.println("0. Exit");
	   	 	System.out.print("> ");
	   	 	answer = input.next();

			if (answer.equals ("1")){
				System.out.println(shopStock);
				System.out.println("What does the customer want ?");
				System.out.println("1. Hardware");
				System.out.println("2. Peripherals");
				input.nextLine();
				str1 = input.nextLine();
				if(str1.equals("1")){
					System.out.println("What does the customer want ?");
					System.out.println("1. Motherboard");
					System.out.println("2. CPU");
					System.out.println("3. GPU");
					System.out.println("4. RAM memory");
					System.out.println("5. Hard Drive");
					//input.nextLine();
					str2 = input.nextLine();
				}else if(str1.equals("2")){
					System.out.println("What does the customer want ?");
					System.out.println("1. Screen");
					System.out.println("2. Keyboard");
					System.out.println("3. Mouse");
					System.out.println("4. Printer");
					//input.nextLine();
					int help = input.nextInt()+5 ;
					str2 = Integer.toString(help);
				}
				PcParts thing = Questions1(str1,str2);
				//elegxos ston katalogo twn diathesimwn gia to sugkekrimeno proion
				if (Exists(thing, shopStock)){  //TO PROION UPARXEI STO STOCK
					System.out.println("The product exists. Are you interested in buying this product? (Y/N)");
					decision = input.next();
					if ( decision.equals("Y")){
						part = Questions3(x1,x2,z1,z2);
						System.out.println("You will now be asked to input the customers credentials");
						System.out.println("Please enter the customer's full name.");
						System.out.print(">");
						System.out.println(" ");
						input.nextLine();
						name = input.nextLine();
						System.out.println("Please enter the customer's phone.");
						System.out.print(">");
						phone = input.nextLong();
						System.out.println("Is the desired item on sale ? (Y/N)");
						System.out.print(">");
						input.nextLine();
						str = input.nextLine();
						//System.out.println("Sale is "+ HWSale);
						if(str.equals("Y")){
							if (str1.equals("1")){
								fp = thing.getPrice() - thing.getPrice()* HWSale/100;                  //finding the final price
								System.out.println("The final price is : "+ fp +" Euros.");
							}else if(str1.equals("2")){
								fp = thing.getPrice() - thing.getPrice() * peripheralSale/100;                  //finding the final price
								System.out.println("The final price is : "+ fp +" Euros.");
							}
						}else{
							fp = thing.getPrice();
						}
						Sell sl = new Sell(part, name, phone, fp);
						soldList.add(sl);
						tw.SoldTextWriter(soldList);
						tw.StockTextWriter(shopStock);
						//Edw tha mpoune ta TextWriter gia Stock kai Sold.
					}else ;

				}else{ // TO PROION DEN UPARXEI STO STOCK
					System.out.println("We do not have this product in stock. Would you like for us to order it? (Y/N)");
					decision = input.next(); 
					while(true){
						if ( decision.equals("Y")){
							PcParts item = Questions2(str2,x1,x2,z1,z2);
							System.out.println("You will now be asked to input the customers credentials");
							System.out.println("Please enter the customer's full name.");
							System.out.print(">");
							input.nextLine();
							name = input.nextLine();
							System.out.println("Please enter the customer's phone.");
							System.out.print(">");
							phone = input.nextLong();
							System.out.println("When do we expect the item to be available ?");
							System.out.print(">");
							expectedDate = input.next();
							System.out.println("Is the desired item on sale ? (Y/N)");
							System.out.print(">");
							input.nextLine();
							str = input.nextLine();
							if(str.equals("Y")){
								if (str1.equals("1")){
									fp = thing.getPrice() - thing.getPrice()* HWSale/100;                  //finding the final price
									System.out.println("The final price is : "+ fp +" Euros.");
								}else if(str1.equals("2")){
									fp = thing.getPrice() - thing.getPrice() * peripheralSale/100;                  //finding the final price
									System.out.println("The final price is : "+ fp +" Euros.");
								}
							}else{
								fp = thing.getPrice();
							}
							Order odr = new Order(item, name, phone,expectedDate,fp);
							ordersList.add(odr);
							tw.OrderTextWriter(ordersList);
							// Edw tha mpei to TextWriter gia to Order.
							System.out.println("Order set.");
							break;
						}else if(decision.equals("N")){
							System.out.println("Order Canceled");
							break;
						}else System.out.println("You entered an invalid character. Please try again.");
					}
				}
	   	 	}
			else if (answer.equals ("2")){
				showOrders();

			}
			else if (answer.equals ("3")){
				showSales();
	   	 	}
	   	 	else if (answer.equals ("0")) break;
		}
	}	
	public static void showOrders(){
		for (int i=0; i < ordersList.size(); i++){
			//System.out.println((i+1) + ". ");
			System.out.println((i+1) + ". \n" + ordersList.get(i));
		}
		System.out.println("Which order would you like to view? ( Enter 0 for exit. )");
		System.out.print(">");
		input.nextLine();
		reply = input.nextInt();
		while(true){
			if ( reply==0){
				break;
			}else if (reply-1 > ordersList.size()){
				System.out.println("You picked "+reply+" . There are not so many orders to list.");
				System.out.println("Please try again !");
			}else{
				System.out.println(ordersList.get(reply-1));
				System.out.println("Would you like to change the order's status ? (Y/N) ");
				input.nextLine();
				response = input.nextLine();
				if(str.equals("Y")){
					/*System.out.println("The order's status is now 'Available' .");
					Sell sl = new Sell(ordersList.get(reply--).getthing(), ordersList.get(reply--).getname(), ordersList.get(reply--).getphone(), ordersList.get(reply--).getfp());
					*/
					status = true;
					ordersList.get(reply-1).setStatus(status);
					System.out.println("The order's status is now 'Available' .");
					Sell sl = new Sell(ordersList.get(reply-1).getThing(), ordersList.get(reply-1).getName(), ordersList.get(reply-1).getPhone(), ordersList.get(reply-1).getFP());
					soldList.add(sl);	
				}
				break;
			}
		}
	}
	public static void showSales(){
		for (int i=0; i < soldList.size(); i++){
			System.out.println(soldList.get(i));
		}
	}	
	public static boolean Exists ( PcParts thing, List<Stock> shopStock ){	
		check = false;
		item = thing;
		for(int i=0; i < shopStock.size(); i++){
			if ( thing.getManufacturer().equals(shopStock.get(i).getManufacturer()) && thing.getmodelName().equals(shopStock.get(i).getmodelName()) && thing.getmodelYear() == shopStock.get(i).getmodelYear() && shopStock.get(i).getAvailableStock() > 0){
				check = true;
			}
		}
		return check;
	}

	public static PcParts Questions1(String str1, String str2){
		while(true){
			if(str2.equals("1")||str2.equals("2")||str2.equals("4")||str2.equals("5")||str2.equals("3")||str2.equals("7")||str2.equals("8")||str2.equals("9")||str2.equals("6")){
			//if((str1.equals("1")&&(str2.equals("1")||str2.equals("2")||str2.equals("3")||str2.equals("4")||str2.equals("5")))||(str1.equals("2")&&(str2.equals("6")||str2.equals("7")||str2.equals("8")||str2.equals("9")))){
				System.out.println("You will now be asked to input the specifications of the desired product");
				System.out.println("Please enter the model name of the desired part. ");
				input.nextLine();				//?????????????????????????????????????
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
				item = new PcParts(x1,x2,z1,z2);
				break;
				
			}else{
				System.out.println("There was an error during the process. The process will now restart.");
				System.out.println("What does the customer want ?");
				System.out.println("1. Hardware");
				System.out.println("2. Peripherals");
				str1 = input.next();
				if(str1.equals("1")){
					System.out.println("1. Motherboard");
					System.out.println("2. CPU");
					System.out.println("3. GPU");
					System.out.println("4. RAM memory");
					System.out.println("5. Hard Drive");
					str2 = input.next();
				}else if(str1.equals("2")){
					System.out.println("1. Screen");
					System.out.println("2. Keyboard");
					System.out.println("3. Mouse");
					System.out.println("4. Printer");
					int help = input.nextInt()+5 ;
					str2 = Integer.toString(help);
				}
			}
		}
		return item;
	}
	public static PcParts Questions2(String str, String x1, String x2, int z1, int z2){
		while(j<2){
			if(str.equals("1")||str.equals("2")||str.equals("4")||str.equals("5")||str.equals("3")||str.equals("7")||str.equals("8")||str.equals("9")||str.equals("6")){
				switch(str){
					case"1":
						item = MoBo(x1,x2,z1,z2);//motherboard
						j++;
						break;
					case"2":
						item = Prossesor(x1,x2,z1,z2);//CPU
						j++;
						break;
					case"4":
						item = Memory(x1,x2,z1,z2);//RAM
						j++;
						break;
					case"5":
						item = SSHD(x1,x2,z1,z2);//HardDrive
						j++;
						break;
					case"7":
						item = Click(x1,x2,z1,z2);//keyboard
						j++;
						break;
					case"8":
						item = Mice(x1,x2,z1,z2);//mouse
						j++;
						break;
					case"9":
						item = Paper(x1,x2,z1,z2);//printer
						j++;
						break;
					case"6":
						item = View(x1,x2,z1,z2);//screen
						j++;
						break;
					case"3":
						item = Graphics(x1,x2,z1,z2);//GPU
						j++;
						break;
					default:
						break;
				}
			}
		}
		return item;
	}
	public static PcParts Questions3(String x1, String x2, int z1, int z2){
		for(int i=0; i < shopStock.size(); i++){
			if ( x1.equals(shopStock.get(i).getManufacturer()) && x2.equals(shopStock.get(i).getmodelName()) && z1 == shopStock.get(i).getmodelYear()){
				item = shopStock.get(i).getThing();
				shopStock.get(i).setAvailableStock(shopStock.get(i).getAvailableStock() - 1); // <------meiwsh tou stock
			}
		}
		return item;
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
		connection = input.next();
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
		type = input.nextLine();											//????????????????????????????????????????
		System.out.println("What is the width (inches) of the product that the customer ordering ?");
		width = input.nextDouble();
		System.out.println("What size (GB) is the customer ordering ?");
		size = input.nextInt();
		x1 = modelName;
		x2 = manufacturer;
		z1 = modelYear;
		z2 = price;
		HardDrive HDRV = new HardDrive(type, size, width, x1, x2, z1, z2);
		return HDRV;
	}
	/*public void StockTextWriter(ArrayList StockList) throws FileNotFoundException, IOException {
		try {
			in = new BufferedReader(new FileReader("STOCK_LIST.txt"));
			output = new BufferedWriter(new FileWriter("STOCK_LIST.txt"));
			String inputLine = null;
			while((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
		}
		catch(IOException ex) {
			System.err.println("An IOException was caught!");
            ex.printStackTrace();
        }
		for(i=0, i<
		output.write("STOCK_LIST\n{");
		
		output.write("\n}");
		output.close();
	}*/
}
