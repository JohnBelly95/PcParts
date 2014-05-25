import java.io.*;
import java.util.*;

public class TextReader{

	private List<Stock> stockList;
	private List<Order> orderList;
	private List<Sell> soldList;
	static BufferedReader input;
	static PcParts product = null;
	String line;
	BufferedReader reader = null;
	Stock stk = new Stock() ;
	Order ord = new Order();
	Sell sl = new Sell();
	File f = null;

	public void StockTextReader(List<Stock> stockList){
		try {
			f = new File("STOCK_LIST.txt");
		} catch (NullPointerException e) {
			System.err.println("Stock file not found.");
		}
		try {
			reader = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening stock file!");
		}
		try{
			line = reader.readLine();
			if(line !=null){
				System.out.println("The file has opened.");
				if (!line.trim().equals(" ")) {
					if (line.trim().startsWith("STOCK_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								while(line != null){
									line = reader.readLine();
									if(line != null){
										if (line.trim().startsWith("ITEM")) {
											line = reader.readLine();
											if (line != null){
												if (line.trim().equals("{")) {
													line = reader.readLine();
													if(line != null){
														if(line.trim().startsWith("TYPE:")){
															if(line != null){
																if(line.trim().substring(6).trim().equalsIgnoreCase("RAM")){
																	product = new RAM();
																	readRAM(1);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("CPU")){
																	product = new CPU();
																	readCPU(1);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("GPU")){
																	product = new GPU();
																	readGPU(1);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("HARDDRIVE")){
																	product = new HardDrive();
																	readHARDDRIVE(1);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("MOTHERBOARD")){
																	product = new Motherboard();
																	readMOTHERBOARD(1);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("KEYBOARD")){
																	product = new Keyboard();
																	readKEYBOARD(1);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("MOUSE")){
																	product = new Mouse();
																	readMOUSE(1);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("MONITOR")){
																	product = new Screen();
																	readMONITOR(1);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("PRINTER")){
																	product = new Printer();
																	readPRINTER(1);
																}else if(line.trim().equals("}")){
																	line = reader.readLine();
																	if(line.trim().equals("}")) break;
																}else System.out.println("This product is not in the available product list.");
															}
														}else System.out.println("There is no product type.");//TYPE KLEINEI
													}
												}//{ KLEINEI
											}
										}//ITEM KLEINEI
									}
								}
							}//{ KLEINEI
						}
					}//STOCK_LIST KLEINEI
				}
			}
		}
		catch(IOException e){
			System.err.println("An IOException was caught");
		}
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Error closing stock file.");
		}
	}

	public void OrderTextReader(List<Order> orderList){
		try {
			f = new File("ORDER_LIST.txt");
		} catch (NullPointerException e) {
			System.err.println("Order file not found.");
		}
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening order file!");
		}
		try{
			line = reader.readLine();
			if(line !=null){
				System.out.println("The file has opened.");
				if (!line.trim().equals(" ")) {
					System.out.println("1");
					if (line.trim().startsWith("ORDER_LIST")) {
						line = reader.readLine();
						System.out.println("2");
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								System.out.println("3");
								while(line != null){
									if (line.trim().startsWith("ORDER")) {
										line = reader.readLine();
										System.out.println("4");
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												System.out.println("5");
												if(line != null){
													System.out.println("6");
													while(line.trim().startsWith("}")){
														if(line.trim().startsWith("TYPE: ")){
															System.out.println("7");
															if(line != null){
																if(line.trim().substring(6).trim().equalsIgnoreCase("RAM")){
																	product = new RAM();
																	readRAM(2);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("CPU")){
																	product = new CPU();
																	readCPU(2);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("GPU")){
																	product = new GPU();
																	readGPU(2);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("HARDDRIVE")){
																	product = new HardDrive();
																	readHARDDRIVE(2);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("MOTHERBOARD")){
																	product = new Motherboard();
																	readMOTHERBOARD(2);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("KEYBOARD")){
																	product = new Keyboard();
																	readKEYBOARD(2);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("MOUSE")){
																	product = new Mouse();
																	readMOUSE(2);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("MONITOR")){
																	product = new Screen();
																	readMONITOR(2);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("PRINTER")){
																	product =  new Printer();
																	readPRINTER(2);
																	//readPRINTER(3);
																}else System.out.println("This product is not in the available product list.");
															}
														}//TYPE KLEINEI
													}
													line = reader.readLine();
													if(line.trim().equals("}")) break;
												}
											}// { KLEINEI 
										}
									}// ORDER KLEINEI 
								}
							}// { KLEINEI
						}
					}// ORDER_LIST KLEINEI 
				}
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
		}
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Error closing order file.");
		}
	}

	public void SoldTextReader(List<Sell> soldList){
		this.soldList = soldList;
		try {
			f = new File("SOLD_LIST.txt");
		} catch (NullPointerException e) {
			System.err.println("Sales file not found.");
		}
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening sales file!");
		}
		try{
			line = reader.readLine();
			if (line !=null){
				System.out.println("The file has opened.");
				if (!line.trim().equals(" ")) {
					if (line.trim().startsWith("SALES_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								while(line != null){
									if (line.trim().startsWith("SOLD")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												if(line != null){
													while(line != "}"){
														if(line.trim().startsWith("TYPE: ")){
															line = reader.readLine();
															if(line != null){
																if(line.trim().substring(6).trim().equalsIgnoreCase("RAM")){
																	product = new RAM();
																	readRAM(3);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("CPU")){
																	product = new CPU();
																	readCPU(3);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("GPU")){
																	product = new GPU();
																	readGPU(3);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("HARDDRIVE")){
																	product = new HardDrive();
																	readHARDDRIVE(3);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("MOTHERBOARD")){
																	product = new Motherboard();
																	readMOTHERBOARD(3);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("KEYBOARD")){
																	product = new Keyboard();
																	readKEYBOARD(3);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("MOUSE")){
																	product = new Mouse();
																	readMOUSE(3);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("MONITOR")){
																	product = new Screen();
																	readMONITOR(3);
																}else if(line.trim().substring(6).trim().equalsIgnoreCase("PRINTER")){
																	product =  new Printer();
																	readPRINTER(3);
																}else System.out.println("This product is not in the available product list.");
															}
														}//TYPE KLEINEI
													}
													line = reader.readLine();
													if(line.trim().equals("}")) break;
												}
											}//{ KLEINEI
										}
									}//ITEM KLEINEI
								}
							}//{ KLEINEI
						}
					}//STOCK_LIST KLEINEI
					/*if(line.trim().equals("}"){
						line = reader.readLine();
					}*/
				}
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
		}
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Error closing sales file.");
		}
	}
	
	public void readRAM(int num){      //      R  A  M
		try{
			while(true){
				line = reader.readLine();
				if(line != null){
					if (line.trim().startsWith("MODEL_NAME: ")) {
						((RAM)product).setmodelName(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("YEAR: ")) {
						((RAM)product).setmodelYear(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("MANUFACTURER: ")){
						((RAM)product).setManufacturer(line.trim().substring(14).trim());
					}else if(line.trim().startsWith("PRICE: ")){
						((RAM)product).setPrice(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(line.trim().startsWith("MODEL_TYPE: ")) {
						((RAM)product).setType(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("SIZE: ")) {
						((RAM)product).setSize(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("SPEED: ")){
						((RAM)product).setSpeed(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(num == 1 && line.trim().startsWith("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.trim().substring(8).trim()));
					}else if(num == 2 && line.trim().startsWith("NAME: ")){
						ord.setName(line.trim().substring(6).trim());
					}else if(num == 2 && line.trim().startsWith("PHONE: ")){
						ord.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if(num == 2 && line.trim().startsWith("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.trim().substring(13).trim()));
					}else if(num == 2 && line.trim().startsWith("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.trim().substring(14).trim());
					}else if(num == 3 && line.trim().startsWith("NAME: ")){
						sl.setName(line.trim().substring(6).trim());
					}else if(num == 3 && line.trim().startsWith("PHONE: ")){
						sl.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if (line.trim().startsWith("TYPE: ")){
						line = reader.readLine();
					}else break;
				}
				stk.setThing(product);
				ord.setThing(product);
				sl.setThing(product);
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
		}
	}
	public void readCPU(int num){  //           C     P     U
		try{
			while(true){
				line = reader.readLine();
				if(line != null){
					if (line.trim().startsWith("MODEL_NAME: ")) {
						((CPU)product).setmodelName(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("YEAR: ")) {
						((CPU)product).setmodelYear(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("MANUFACTURER: ")){
						((CPU)product).setManufacturer(line.trim().substring(14).trim());
					}else if(line.trim().startsWith("PRICE: ")){
						((CPU)product).setPrice(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(line.trim().startsWith("SPEED: ")) {
						((CPU)product).setSpeed(Double.parseDouble(line.trim().substring(7).trim()));
					}else if(line.trim().startsWith("CORES: ")){
						((CPU)product).setCoreCount(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(num == 1 && line.trim().startsWith("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.trim().substring(8).trim()));
					}else if(num == 2 && line.trim().startsWith("NAME: ")){
						ord.setName(line.trim().substring(6).trim());
					}else if(num == 2 && line.trim().startsWith("PHONE: ")){
						ord.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if(num == 2 && line.trim().startsWith("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.trim().substring(13).trim()));
					}else if(num == 2 && line.trim().startsWith("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.trim().substring(14).trim());
					}else if(num == 3 && line.trim().startsWith("NAME: ")){
						sl.setName(line.trim().substring(6).trim());
					}else if(num == 3 && line.trim().startsWith("PHONE: ")){
						sl.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if (line.trim().startsWith("TYPE: ")){
						line = reader.readLine();
					}else break;
					
				}
				stk.setThing(product);
				ord.setThing(product);
				sl.setThing(product);
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
		}
	}
	public void readGPU(int num){ //                         G         P         U
		try{
			while(true){
				line = reader.readLine();
				if(line != null){
					if (line.trim().startsWith("MODEL_NAME: ")) {
						((GPU)product).setmodelName(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("YEAR: ")) {
						((GPU)product).setmodelYear(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("MANUFACTURER: ")){
						((GPU)product).setManufacturer(line.trim().substring(14).trim());
					}else if(line.trim().startsWith("PRICE: ")){
						((GPU)product).setPrice(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(line.trim().startsWith("CHIPSET: ")) {
						((GPU)product).setChipset(line.trim().substring(9).trim());
					}else if(line.trim().startsWith("MEMORY: ")) {
						((GPU)product).setMemory(Integer.parseInt(line.trim().substring(8).trim()));
					}else if(num == 1 && line.trim().startsWith("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.trim().substring(8).trim()));
					}else if(num == 2 && line.trim().startsWith("NAME: ")){
						ord.setName(line.trim().substring(6).trim());
					}else if(num == 2 && line.trim().startsWith("PHONE: ")){
						ord.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if(num == 2 && line.trim().startsWith("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.trim().substring(13).trim()));
					}else if(num == 2 && line.trim().startsWith("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.trim().substring(14).trim());
					}else if(num == 3 && line.trim().startsWith("NAME: ")){
						sl.setName(line.trim().substring(6).trim());
					}else if(num == 3 && line.trim().startsWith("PHONE: ")){
						sl.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if (line.trim().startsWith("TYPE: ")){
						line = reader.readLine();
					}else break;
					
				}
				stk.setThing(product);
				ord.setThing(product);
				sl.setThing(product);
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
		}
	}
	public void readHARDDRIVE(int num){ //               H   A   R   D   D   R   I   V   E
		try{
			while(true){
				line = reader.readLine();
				if(line != null){
					if (line.trim().startsWith("MODEL_NAME: ")) {
						((HardDrive)product).setmodelName(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("YEAR: ")) {
						((HardDrive)product).setmodelYear(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("MANUFACTURER: ")){
						((HardDrive)product).setManufacturer(line.trim().substring(14).trim());
					}else if(line.trim().startsWith("PRICE: ")){
						((HardDrive)product).setPrice(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(line.trim().startsWith("TYPE: ")) {
						((HardDrive)product).setType(line.trim().substring(6).trim());
					}else if(line.trim().startsWith("WIDTH: ")) {
						((HardDrive)product).setWidth(Double.parseDouble(line.trim().substring(7).trim()));
					}else if(line.trim().startsWith("SIZE: ")) {
						((HardDrive)product).setSize(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(num == 1 && line.trim().startsWith("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.trim().substring(8).trim()));
					}else if(num == 2 && line.trim().startsWith("NAME: ")){
						ord.setName(line.trim().substring(6).trim());
					}else if(num == 2 && line.trim().startsWith("PHONE: ")){
						ord.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if(num == 2 && line.trim().startsWith("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.trim().substring(13).trim()));
					}else if(num == 2 && line.trim().startsWith("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.trim().substring(14).trim());
					}else if(num == 3 && line.trim().startsWith("NAME: ")){
						sl.setName(line.trim().substring(6).trim());
					}else if(num == 3 && line.trim().startsWith("PHONE: ")){
						sl.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if (line.trim().startsWith("TYPE: ")){
						line = reader.readLine();
					}else break;
					
				}
				stk.setThing(product);
				ord.setThing(product);
				sl.setThing(product);
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
		}
	}
	public void readMOTHERBOARD(int num){  //           M   O   T   H   E   R   B   O   A   R   D
		try{
			while(true){
				line = reader.readLine();
				if(line != null){
					if (line.trim().startsWith("MODEL_NAME: ")) {
						((Motherboard)product).setmodelName(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("YEAR: ")) {
						((Motherboard)product).setmodelYear(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("MANUFACTURER: ")){
						((Motherboard)product).setManufacturer(line.trim().substring(14).trim());
					}else if(line.trim().startsWith("PRICE: ")){
						((Motherboard)product).setPrice(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(line.trim().startsWith("CHIP: ")) {
						((Motherboard)product).setChip(line.substring(6).trim());
					}else if(line.trim().startsWith("SIZE: ")) {
						((Motherboard)product).setRAMSize(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("GATES: ")) {
						((Motherboard)product).setExpansionSlots(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(num == 1 && line.trim().startsWith("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.trim().substring(8).trim()));
					}else if(num == 2 && line.trim().startsWith("NAME: ")){
						ord.setName(line.trim().substring(6).trim());
					}else if(num == 2 && line.trim().trim().startsWith("PHONE: ")){
						ord.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if(num == 2 && line.trim().startsWith("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.trim().substring(13).trim()));
					}else if(num == 2 && line.trim().startsWith("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.trim().substring(14).trim());
					}else if(num == 3 && line.trim().startsWith("NAME: ")){
						sl.setName(line.trim().substring(6).trim());
					}else if(num == 3 && line.trim().startsWith("PHONE: ")){
						sl.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if (line.trim().startsWith("TYPE: ")){
						line = reader.readLine();
					}else break;
					
				}
				stk.setThing(product);
				ord.setThing(product);
				sl.setThing(product);
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
		}
	}
	public void readMONITOR(int num){  //                           S   C   R   E   E   N
		try{
			while(true){
				line = reader.readLine();
				if(line != null){
					if (line.trim().startsWith("MODEL_NAME: ")) {
						((Screen)product).setmodelName(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("YEAR: ")) {
						((Screen)product).setmodelYear(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("MANUFACTURER: ")){
						((Screen)product).setManufacturer(line.trim().substring(14).trim());
					}else if(line.trim().startsWith("PRICE: ")){
						((Screen)product).setPrice(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(line.trim().startsWith("TYPE: ")) {
						((Screen)product).setType(line.trim().substring(6).trim());
					}else if(line.trim().startsWith("SIZE: ")) {
						((Screen)product).setSize(Double.parseDouble(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("HDMIPORT: ")) {
						((Screen)product).setHDMIport(Integer.parseInt(line.trim().substring(10).trim()));
					}else if(line.trim().startsWith("DVIPORT: ")) {
						((Screen)product).setDVIport(Integer.parseInt(line.trim().substring(9).trim()));
					}else if(line.trim().startsWith("COMPOSITEPORT: ")) {
						((Screen)product).setCOMPOSITEport(Integer.parseInt(line.trim().substring(15).trim()));
					}else if(line.trim().startsWith("RESOLUSION: ")) {
						((Screen)product).setResolution(line.trim().substring(12).trim());
					}else if(num == 1 && line.trim().startsWith("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.trim().substring(8).trim()));
					}else if(num == 2 && line.trim().startsWith("NAME: ")){
						ord.setName(line.trim().substring(6).trim());
					}else if(num == 2 && line.trim().startsWith("PHONE: ")){
						ord.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if(num == 2 && line.trim().startsWith("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.trim().substring(13).trim()));
					}else if(num == 2 && line.trim().startsWith("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.trim().substring(14).trim());
					}else if(num == 3 && line.trim().startsWith("NAME: ")){
						sl.setName(line.trim().substring(6).trim());
					}else if(num == 3 && line.trim().startsWith("PHONE: ")){
						sl.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if (line.trim().startsWith("TYPE: ")){
						line = reader.readLine();
					}else break;
					
				}
				stk.setThing(product);
				ord.setThing(product);
				sl.setThing(product);
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
		}
	}
	public void readKEYBOARD(int num){         //                       K   E   Y   B   O   A   R   D
		try{
			while(true){
				line = reader.readLine();
				if(line != null){
					if (line.trim().startsWith("MODEL_NAME: ")) {
						((Keyboard)product).setmodelName(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("YEAR: ")) {
						((Keyboard)product).setmodelYear(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("MANUFACTURER: ")){
						((Keyboard)product).setManufacturer(line.trim().substring(14).trim());
					}else if(line.trim().startsWith("PRICE: ")){
						((Keyboard)product).setPrice(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(line.trim().startsWith("CONNECTION: ")) {
						((Keyboard)product).setConnection(line.trim().substring(12).trim());
					}else if(num == 1 && line.trim().startsWith("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.trim().substring(8).trim()));
					}else if(num == 2 && line.trim().startsWith("NAME: ")){
						ord.setName(line.trim().substring(6).trim());
					}else if(num == 2 && line.trim().startsWith("PHONE: ")){
						ord.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if(num == 2 && line.trim().startsWith("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.trim().substring(13).trim()));
					}else if(num == 2 && line.trim().startsWith("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.trim().substring(14).trim());
					}else if(num == 3 && line.trim().startsWith("NAME: ")){
						sl.setName(line.trim().substring(6).trim());
					}else if(num == 3 && line.trim().startsWith("PHONE: ")){
						sl.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if (line.trim().startsWith("TYPE: ")){
						line = reader.readLine();
					}else break;
					
				}
				stk.setThing(product);
				ord.setThing(product);
				sl.setThing(product);
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
		}
	}
	public void readMOUSE(int num){ //                  M  O  U  S  E
		try{
			while(true){
				line = reader.readLine();
				if(line != null){
					if (line.trim().startsWith("MODEL_NAME: ")) {
						((Mouse)product).setmodelName(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("YEAR: ")) {
						((Mouse)product).setmodelYear(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("MANUFACTURER: ")){
						((Mouse)product).setManufacturer(line.trim().substring(14).trim());
					}else if(line.trim().startsWith("PRICE: ")){
						((Mouse)product).setPrice(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(line.trim().startsWith("TECHNOLOGY: ")) {
						((Mouse)product).setTechnology(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("CONNECTION: ")) {
						((Mouse)product).setConnection(line.trim().substring(12).trim());
					}else if(num == 1 && line.trim().startsWith("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.trim().substring(8).trim()));
					}else if(num == 2 && line.trim().startsWith("NAME: ")){
						ord.setName(line.trim().substring(6).trim());
					}else if(num == 2 && line.trim().startsWith("PHONE: ")){
						ord.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if(num == 2 && line.trim().startsWith("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.trim().substring(13).trim()));
					}else if(num == 2 && line.trim().startsWith("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.trim().substring(14).trim());
					}else if(num == 3 && line.trim().startsWith("NAME: ")){
						sl.setName(line.trim().substring(6).trim());
					}else if(num == 3 && line.trim().startsWith("PHONE: ")){
						sl.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if (line.trim().startsWith("TYPE: ")){
						line = reader.readLine();
					}else break;
					
				}
				stk.setThing(product);
				ord.setThing(product);
				sl.setThing(product);
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
		}
	}
	public void readPRINTER(int num){ //                         P   R   I   N   T   E   R
		try{
			while(true){
				line = reader.readLine();
				if(line != null){
					if (line.trim().startsWith("MODEL_NAME: ")) {
						((Printer)product).setmodelName(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("YEAR: ")) {
						((Printer)product).setmodelYear(Integer.parseInt(line.trim().substring(6).trim()));
					}else if(line.trim().startsWith("MANUFACTURER: ")){
						((Printer)product).setManufacturer(line.trim().substring(14).trim());
					}else if(line.trim().startsWith("PRICE: ")){
						((Printer)product).setPrice(Integer.parseInt(line.trim().substring(7).trim()));
					}else if(line.trim().startsWith("TECHNOLOGY: ")) {
						((Printer)product).setTechnology(line.trim().substring(12).trim());
					}else if(line.trim().startsWith("PRINTER_TYPE: ")) {
						((Printer)product).setPrintingType(line.trim().substring(14).trim());
					}else if(num == 1 && line.trim().startsWith("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.trim().substring(8).trim()));
					}else if(num == 2 && line.trim().startsWith("NAME: ")){
						ord.setName(line.trim().substring(6).trim());
					}else if(num == 2 && line.trim().startsWith("PHONE: ")){
						ord.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if(num == 2 && line.trim().startsWith("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.trim().substring(13).trim()));
					}else if(num == 2 && line.trim().startsWith("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.trim().substring(14).trim());
					}else if(num == 3 && line.trim().startsWith("NAME: ")){
						sl.setName(line.trim().substring(6).trim());
					}else if(num == 3 && line.trim().startsWith("PHONE: ")){
						sl.setPhone(Long.parseLong(line.trim().substring(7).trim()));
					}else if (line.trim().startsWith("TYPE: ")){
						line = reader.readLine();
					}else break;
					
				}
				stk.setThing(product);
				ord.setThing(product);
				sl.setThing(product);
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
		}
	}
}
