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
	
	//dhlwsh k dhmiourgia twn txt
	File f_stock = null;
	File f_order = null;
	File f_sales = null;
	
	//finding files
	try {
		f_stock = new File(ITEM_LIST.txt);
	} catch (NullPointerException e) {
		System.err.println("Item file not found.");
	}
	try {
		f_order = new File(ORDER_LIST.txt);
	} catch (NullPointerException e) {
		System.err.println("Order file not found.");
	}
	try {
		f_sales = new File(SALES_LIST.txt);
	} catch (NullPointerException e) {
		System.err.println("Sales file not found.");
	}
	
	//opening files
	try {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(f_stock)));
	} catch (FileNotFoundException e) {
		System.err.println("Error opening stock file!");
	}
	try {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(f_order)));
	} catch (FileNotFoundException e) {
		System.err.println("Error opening order file!");
	}
	try {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(f_sales)));
	} catch (FileNotFoundException e) {
		System.err.println("Error opening sales file!");
	}

	public void StockTextReader(List<Stock> stockList){
		try{
			line = reader.readLine();
			if(line !=null){
				System.out.println("The file has opened");
				if (!line.trim().equals(" ")) {
					if (line.trim().equals("STOCK_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								while(line != null){
									if (line.trim().equals("ITEM")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												if(line != null){
													if(line.trim().equals("TYPE:")){
														line = reader.readLine();
														if(line != null){
															if(line.trim().equals("RAM")){
																product = new RAM();
																readRAM(1);
															}else if(line.trim().equals("CPU")){
																product = new CPU();
																readCPU(1);
															}else if(line.trim().equals("GPU")){
																product = new GPU();
																readGPU(1);
															}else if(line.trim().equals("HARDDRIVE")){
																product = new HardDrive();
																readHARDDRIVE(1);
															}else if(line.trim().equals("MOTHERBOARD")){
																product = new Motherboard();
																readMOTHERBOARD(1);
															}else if(line.trim().equals("KEYBOARD")){
																product = new Keyboard();
																readKEYBOARD(1);
															}else if(line.trim().equals("MOUSE")){
																product = new Mouse();
																readMOUSE(1);
															}else if(line.trim().equals("MONITOR")){
																product = new Screen();
																readMONITOR(1);
															}else if(line.trim().equals("PRINTER")){
																product = new Printer();
																readPRINTER(1);
															}else if(line.trim().equals("}")){
																line = reader.readLine();
																if(line.trim().equals("}")) break;
															}
														}
													}//TYPE KLEINEI
												}
											}//{ KLEINEI
										}
									}//ITEM KLEINEI
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
	}

	public void OrderTextReader(List<Order> orderList){
		/*try{
			elegxos an oi paraggelies perilamvanontai sta diathesima proionta
		}
		catch(){
			eidopoihsh
		}*/

		try{
			line = reader.readLine();
			if(line !=null){
				System.out.println("The file has opened");
				if (!line.trim().equals(" ")) {
					if (line.trim().equals("ORDER_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								while(line != null){
									if (line.trim().equals("ORDER")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												if(line != null){
													if(line.trim().equals("TYPE: ")){
														line = reader.readLine();
														if(line != null){
															if(line.trim().substring(6).trim().equals("RAM")){
																product = new RAM();
																readRAM(2);
															}else if(line.trim().substring(6).trim().equals("CPU")){
																product = new CPU();
																readCPU(2);
															}else if(line.trim().substring(6).trim().equals("GPU")){
																product = new GPU();
																readGPU(2);
															}else if(line.trim().substring(6).trim().equals("HARDDRIVE")){
																product = new HardDrive();
																readHARDDRIVE(2);
															}else if(line.trim().substring(6).trim().equals("MOTHERBOARD")){
																product = new Motherboard();
																readMOTHERBOARD(2);
															}else if(line.trim().substring(6).trim().equals("KEYBOARD")){
																product = new Keyboard();
																readKEYBOARD(2);
															}else if(line.trim().substring(6).trim().equals("MOUSE")){
																product = new Mouse();
																readMOUSE(2);
															}else if(line.trim().substring(6).trim().equals("MONITOR")){
																product = new Screen();
																readMONITOR(2);
															}else if(line.trim().substring(6).trim().equals("PRINTER")){
																product =  new Printer();
																readPRINTER(2);
																readPRINTER(3);
															}else if(line.trim().equals("}")){
																line = reader.readLine();
																if(line.trim().equals("}")) break;
															}
														}
													}//TYPE KLEINEI
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
	}

	public void SoldTextReader(List<Sell> soldList){
		this.soldList = soldList;
		try{
			line = reader.readLine();
			if (line !=null){
				System.out.println("File was opened correctly");
				if (!line.trim().equals(" ")) {
					if (line.trim().equals("SALES_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								while(line != null){
									if (line.trim().equals("SOLD")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												if(line != null){
													if(line.trim().equals("TYPE: ")){
														line = reader.readLine();
														if(line != null){
															if(line.trim().substring(6).trim().equals("RAM")){
																product = new RAM();
																readRAM(3);
															}else if(line.trim().substring(6).trim().equals("CPU")){
																product = new CPU();
																readCPU(3);
															}else if(line.trim().substring(6).trim().equals("GPU")){
																product = new GPU();
																readGPU(3);
															}else if(line.trim().substring(6).trim().equals("HARDDRIVE")){
																product = new HardDrive();
																readHARDDRIVE(3);
															}else if(line.trim().substring(6).trim().equals("MOTHERBOARD")){
																product = new Motherboard();
																readMOTHERBOARD(3);
															}else if(line.trim().substring(6).trim().equals("KEYBOARD")){
																product = new Keyboard();
																readKEYBOARD(3);
															}else if(line.trim().substring(6).trim().equals("MOUSE")){
																product = new Mouse();
																readMOUSE(3);
															}else if(line.trim().substring(6).trim().equals("MONITOR")){
																product = new Screen();
																readMONITOR(3);
															}else if(line.trim().substring(6).trim().equals("PRINTER")){
																product =  new Printer();
																readPRINTER(3);
															}else if(line.trim().equals("}")){
																line = reader.readLine();
																if(line.trim().equals("}")) break;
															}
														}
													}//TYPE KLEINEI
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
	}
	
	public void readRAM(int num){//  RAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA              AAAAAAAAAAAAAAAAAAAAAAAAM
		
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((RAM)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((RAM)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((RAM)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: ")){
					((RAM)product).setPrice(Integer.parseInt(line.substring(7).trim()));
				}else if(line.trim().equals("MODEL_TYPE: ")) {
					((RAM)product).setType(line.substring(12).trim());
				}else if(line.trim().equals("SIZE: ")) {
					((RAM)product).setSize(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("SPEED: ")){
					((RAM)product).setSpeed(Integer.parseInt(line.substring(7).trim()));
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: ")){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: ")){
					sl.setPhone(Long.parseLong(line.substring(7).trim()));
				}else break;
			}
			stk.setThing(product);
			ord.setThing(product);
			sl.setThing(product);
		}
	}
	public void readCPU(int num){  //           C     P     U
		
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((CPU)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((CPU)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((CPU)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: ")){
					((CPU)product).setPrice(Integer.parseInt(line.substring(7).trim()));
				}else if(line.trim().equals("SPEED: ")) {
					((CPU)product).setSpeed(Integer.parseInt(line.substring(7).trim()));
				}else if(line.trim().equals("CORES: ")){
					((CPU)product).setCoreCount(Integer.parseInt(line.substring(7).trim()));
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: ")){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: ")){
					sl.setPhone(Long.parseLong(line.substring(7).trim()));
				}else break;
				
			}
			stk.setThing(product);
			ord.setThing(product);
			sl.setThing(product);
		}
	}
	public void readGPU(int num){ //                         G         P         U
		
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((GPU)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((GPU)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((GPU)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: ")){
					((GPU)product).setPrice(Integer.parseInt(line.substring(7).trim()));
				}else if(line.trim().equals("CHIPSET: ")) {
					((GPU)product).setChipset(line.substring(9).trim());
				}else if(line.trim().equals("MEMORY: ")) {
					((GPU)product).setMemory(Integer.parseInt(line.substring(8).trim()));
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: ")){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: ")){
					sl.setPhone(Long.parseLong(line.substring(7).trim()));
				}else break;
				
			}
			stk.setThing(product);
			ord.setThing(product);
			sl.setThing(product);
		}
	}
	public void readHARDDRIVE(int num){ //               H   A   R   D   D   R   I   V   E
		
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((HardDrive)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((HardDrive)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((HardDrive)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: ")){
					((HardDrive)product).setPrice(Integer.parseInt(line.substring(7).trim()));
				}else if(line.trim().equals("TYPE: ")) {
					((HardDrive)product).setType(line.substring(6).trim());
				}else if(line.trim().equals("WIDTH: ")) {
					((HardDrive)product).setWidth(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("SIZE: ")) {
					((HardDrive)product).setSize(Integer.parseInt(line.substring(6).trim()));
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: ")){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: ")){
					sl.setPhone(Long.parseLong(line.substring(7).trim()));
				}else break;
				
			}
			stk.setThing(product);
			ord.setThing(product);
			sl.setThing(product);
		}
	}
	public void readMOTHERBOARD(int num){  //           M   O   T   H   E   R   B   O   A   R   D
		
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((Motherboard)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((Motherboard)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((Motherboard)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: ")){
					((Motherboard)product).setPrice(Integer.parseInt(line.substring(7).trim()));
				}else if(line.trim().equals("CHIP: ")) {
					((Motherboard)product).setChip(line.substring(6).trim());
				}else if(line.trim().equals("SIZE: ")) {
					((Motherboard)product).setRAMSize(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("GATES: ")) {
					((Motherboard)product).setExpansionSlots(Integer.parseInt(line.substring(7).trim()));
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: ")){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: ")){
					sl.setPhone(Long.parseLong(line.substring(7).trim()));
				}else break;
				
			}
			stk.setThing(product);
			ord.setThing(product);
			sl.setThing(product);
		}
	}
	public void readMONITOR(int num){  //                           S   C   R   E   E   N
		
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((Screen)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((Screen)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((Screen)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: ")){
					((Screen)product).setPrice(Integer.parseInt(line.substring(7).trim()));
				}else if(line.trim().equals("TYPE: ")) {
					((Screen)product).setType(line.substring(6).trim());
				}else if(line.trim().equals("SIZE: ")) {
					((Screen)product).setSize(Double.parseDouble(line.substring(6).trim()));
				}else if(line.trim().equals("HDMIPORT: ")) {
					((Screen)product).setHDMIport(Integer.parseInt(line.substring(10).trim()));
				}else if(line.trim().equals("DVIPORT: ")) {
					((Screen)product).setDVIport(Integer.parseInt(line.substring(9).trim()));
				}else if(line.trim().equals("COMPOSITEPORT: ")) {
					((Screen)product).setCOMPOSITEport(Integer.parseInt(line.substring(15).trim()));
				}else if(line.trim().equals("RESOLUSION: ")) {
					((Screen)product).setResolution(line.substring(12).trim());
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: ")){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: ")){
					sl.setPhone(Long.parseLong(line.substring(7).trim()));
				}else break;
				
			}
			stk.setThing(product);
			ord.setThing(product);
			sl.setThing(product);
		}
	}
	public void readKEYBOARD(int num){         //                       K   E   Y   B   O   A   R   D
		
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((Keyboard)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((Keyboard)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((Keyboard)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: ")){
					((Keyboard)product).setPrice(Integer.parseInt(line.substring(7).trim()));
				}else if(line.trim().equals("CONNECTION: ")) {
					((Keyboard)product).setConnection(line.substring(12).trim());
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: ")){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: ")){
					sl.setPhone(Long.parseLong(line.substring(7).trim()));
				}else break;
				
			}
			stk.setThing(product);
			ord.setThing(product);
			sl.setThing(product);
		}
	}
	public void readMOUSE(int num){ //                  M  O  U  S  E
		
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((Mouse)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((Mouse)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((Mouse)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: ")){
					((Mouse)product).setPrice(Integer.parseInt(line.substring(7).trim()));
				}else if(line.trim().equals("TECHNOLOGY: ")) {
					((Mouse)product).setTechnology(line.substring(12).trim());
				}else if(line.trim().equals("CONNECTION: ")) {
					((Mouse)product).setConnection(line.substring(12).trim());
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: ")){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: ")){
					sl.setPhone(Long.parseLong(line.substring(7).trim()));
				}else break;
				
			}
			stk.setThing(product);
			ord.setThing(product);
			sl.setThing(product);
		}
	}
	public void readPRINTER(int num){ //                         P   R   I   N   T   E   R
		
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((Printer)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((Printer)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((Printer)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: ")){
					((Printer)product).setPrice(Integer.parseInt(line.substring(7).trim()));
				}else if(line.trim().equals("TECHNOLOGY: ")) {
					((Printer)product).setTechnology(line.substring(12).trim());
				}else if(line.trim().equals("PRINTER_TYPE: ")) {
					((Printer)product).setPrintingType(line.substring(14).trim());
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: ")){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: ")){
					sl.setPhone(Long.parseLong(line.substring(7).trim()));
				}else break;
				
			}
			stk.setThing(product);
			ord.setThing(product);
			sl.setThing(product);
		}
	}
	try {
		reader.close();
	} catch (IOException e) {
		System.err.println("Error closing file.");
	}
}
