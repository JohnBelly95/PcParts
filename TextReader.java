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
					if (line.trim().equalsIgnoreCase("STOCK_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								while(line != null){
									if (line.trim().equalsIgnoreCase("ITEM")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												if(line != null){
													if(line.trim().equalsIgnoreCase("TYPE:")){
														line = reader.readLine();
														if(line != null){
															if(line.trim().equalsIgnoreCase("RAM")){
																product = new RAM();
																readRAM(1);
															}else if(line.trim().equalsIgnoreCase("CPU")){
																product = new CPU();
																readCPU(1);
															}else if(line.trim().equalsIgnoreCase("GPU")){
																product = new GPU();
																readGPU(1);
															}else if(line.trim().equalsIgnoreCase("HARDDRIVE")){
																product = new HardDrive();
																readHARDDRIVE(1);
															}else if(line.trim().equalsIgnoreCase("MOTHERBOARD")){
																product = new Motherboard();
																readMOTHERBOARD(1);
															}else if(line.trim().equalsIgnoreCase("KEYBOARD")){
																product = new Keyboard();
																readKEYBOARD(1);
															}else if(line.trim().equalsIgnoreCase("MOUSE")){
																product = new Mouse();
																readMOUSE(1);
															}else if(line.trim().equalsIgnoreCase("MONITOR")){
																product = new Screen();
																readMONITOR(1);
															}else if(line.trim().equalsIgnoreCase("PRINTER")){
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
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Error closing stock file.");
		}
	}

	public void OrderTextReader(List<Order> orderList){
		/*try{
			elegxos an oi paraggelies perilamvanontai sta diathesima proionta
		}
		catch(){
			eidopoihsh
		}*/
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
					if (line.trim().equalsIgnoreCase("ORDER_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								while(line != null){
									if (line.trim().equalsIgnoreCase("ORDER")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												if(line != null){
													if(line.trim().equalsIgnoreCase("TYPE: ")){
														line = reader.readLine();
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
					if (line.trim().equalsIgnoreCase("SALES_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								while(line != null){
									if (line.trim().equalsIgnoreCase("SOLD")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												if(line != null){
													if(line.trim().equalsIgnoreCase("TYPE: ")){
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
															}else if(line.trim().equals("}")){
																line = reader.readLine();
																if(line.trim().equals("}")) break;
															}else System.out.println("This product is not in the available product list.");
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
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Error closing sales file.");
		}
	}
	
	public void readRAM(int num){//  RAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA              AAAAAAAAAAAAAAAAAAAAAAAAM
		try{
			while(true){
				line = reader.readLine();
				if(line != null){
					if (line.trim().equalsIgnoreCase("MODEL_NAME: ")) {
						((RAM)product).setmodelName(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("YEAR: ")) {
						((RAM)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("MANUFACTURER: ")){
						((RAM)product).setManufacturer(line.substring(14).trim());
					}else if(line.trim().equalsIgnoreCase("PRICE: ")){
						((RAM)product).setPrice(Integer.parseInt(line.substring(7).trim()));
					}else if(line.trim().equalsIgnoreCase("MODEL_TYPE: ")) {
						((RAM)product).setType(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("SIZE: ")) {
						((RAM)product).setSize(Integer.parseInt(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("SPEED: ")){
						((RAM)product).setSpeed(Integer.parseInt(line.substring(7).trim()));
					}else if(num == 1 && line.trim().equalsIgnoreCase("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("NAME: ")){
						ord.setName(line.substring(6).trim());
					}else if(num == 2 && line.trim().equalsIgnoreCase("PHONE: ")){
						ord.setPhone(Long.parseLong(line.substring(7).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.substring(13).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.substring(14).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("NAME: ")){
						sl.setName(line.substring(6).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("PHONE: ")){
						sl.setPhone(Long.parseLong(line.substring(7).trim()));
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
					if (line.trim().equalsIgnoreCase("MODEL_NAME: ")) {
						((CPU)product).setmodelName(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("YEAR: ")) {
						((CPU)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("MANUFACTURER: ")){
						((CPU)product).setManufacturer(line.substring(14).trim());
					}else if(line.trim().equalsIgnoreCase("PRICE: ")){
						((CPU)product).setPrice(Integer.parseInt(line.substring(7).trim()));
					}else if(line.trim().equalsIgnoreCase("SPEED: ")) {
						((CPU)product).setSpeed(Integer.parseInt(line.substring(7).trim()));
					}else if(line.trim().equalsIgnoreCase("CORES: ")){
						((CPU)product).setCoreCount(Integer.parseInt(line.substring(7).trim()));
					}else if(num == 1 && line.trim().equalsIgnoreCase("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("NAME: ")){
						ord.setName(line.substring(6).trim());
					}else if(num == 2 && line.trim().equalsIgnoreCase("PHONE: ")){
						ord.setPhone(Long.parseLong(line.substring(7).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.substring(13).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.substring(14).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("NAME: ")){
						sl.setName(line.substring(6).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("PHONE: ")){
						sl.setPhone(Long.parseLong(line.substring(7).trim()));
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
					if (line.trim().equalsIgnoreCase("MODEL_NAME: ")) {
						((GPU)product).setmodelName(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("YEAR: ")) {
						((GPU)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("MANUFACTURER: ")){
						((GPU)product).setManufacturer(line.substring(14).trim());
					}else if(line.trim().equalsIgnoreCase("PRICE: ")){
						((GPU)product).setPrice(Integer.parseInt(line.substring(7).trim()));
					}else if(line.trim().equalsIgnoreCase("CHIPSET: ")) {
						((GPU)product).setChipset(line.substring(9).trim());
					}else if(line.trim().equalsIgnoreCase("MEMORY: ")) {
						((GPU)product).setMemory(Integer.parseInt(line.substring(8).trim()));
					}else if(num == 1 && line.trim().equalsIgnoreCase("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("NAME: ")){
						ord.setName(line.substring(6).trim());
					}else if(num == 2 && line.trim().equalsIgnoreCase("PHONE: ")){
						ord.setPhone(Long.parseLong(line.substring(7).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.substring(13).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.substring(14).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("NAME: ")){
						sl.setName(line.substring(6).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("PHONE: ")){
						sl.setPhone(Long.parseLong(line.substring(7).trim()));
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
					if (line.trim().equalsIgnoreCase("MODEL_NAME: ")) {
						((HardDrive)product).setmodelName(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("YEAR: ")) {
						((HardDrive)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("MANUFACTURER: ")){
						((HardDrive)product).setManufacturer(line.substring(14).trim());
					}else if(line.trim().equalsIgnoreCase("PRICE: ")){
						((HardDrive)product).setPrice(Integer.parseInt(line.substring(7).trim()));
					}else if(line.trim().equalsIgnoreCase("TYPE: ")) {
						((HardDrive)product).setType(line.substring(6).trim());
					}else if(line.trim().equalsIgnoreCase("WIDTH: ")) {
						((HardDrive)product).setWidth(Double.parseDouble(line.substring(7).trim()));
					}else if(line.trim().equalsIgnoreCase("SIZE: ")) {
						((HardDrive)product).setSize(Integer.parseInt(line.substring(6).trim()));
					}else if(num == 1 && line.trim().equalsIgnoreCase("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("NAME: ")){
						ord.setName(line.substring(6).trim());
					}else if(num == 2 && line.trim().equalsIgnoreCase("PHONE: ")){
						ord.setPhone(Long.parseLong(line.substring(7).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.substring(13).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.substring(14).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("NAME: ")){
						sl.setName(line.substring(6).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("PHONE: ")){
						sl.setPhone(Long.parseLong(line.substring(7).trim()));
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
					if (line.trim().equalsIgnoreCase("MODEL_NAME: ")) {
						((Motherboard)product).setmodelName(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("YEAR: ")) {
						((Motherboard)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("MANUFACTURER: ")){
						((Motherboard)product).setManufacturer(line.substring(14).trim());
					}else if(line.trim().equalsIgnoreCase("PRICE: ")){
						((Motherboard)product).setPrice(Integer.parseInt(line.substring(7).trim()));
					}else if(line.trim().equalsIgnoreCase("CHIP: ")) {
						((Motherboard)product).setChip(line.substring(6).trim());
					}else if(line.trim().equalsIgnoreCase("SIZE: ")) {
						((Motherboard)product).setRAMSize(Integer.parseInt(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("GATES: ")) {
						((Motherboard)product).setExpansionSlots(Integer.parseInt(line.substring(7).trim()));
					}else if(num == 1 && line.trim().equalsIgnoreCase("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("NAME: ")){
						ord.setName(line.substring(6).trim());
					}else if(num == 2 && line.trim().equalsIgnoreCase("PHONE: ")){
						ord.setPhone(Long.parseLong(line.substring(7).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.substring(13).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.substring(14).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("NAME: ")){
						sl.setName(line.substring(6).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("PHONE: ")){
						sl.setPhone(Long.parseLong(line.substring(7).trim()));
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
					if (line.trim().equalsIgnoreCase("MODEL_NAME: ")) {
						((Screen)product).setmodelName(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("YEAR: ")) {
						((Screen)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("MANUFACTURER: ")){
						((Screen)product).setManufacturer(line.substring(14).trim());
					}else if(line.trim().equalsIgnoreCase("PRICE: ")){
						((Screen)product).setPrice(Integer.parseInt(line.substring(7).trim()));
					}else if(line.trim().equalsIgnoreCase("TYPE: ")) {
						((Screen)product).setType(line.substring(6).trim());
					}else if(line.trim().equalsIgnoreCase("SIZE: ")) {
						((Screen)product).setSize(Double.parseDouble(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("HDMIPORT: ")) {
						((Screen)product).setHDMIport(Integer.parseInt(line.substring(10).trim()));
					}else if(line.trim().equalsIgnoreCase("DVIPORT: ")) {
						((Screen)product).setDVIport(Integer.parseInt(line.substring(9).trim()));
					}else if(line.trim().equalsIgnoreCase("COMPOSITEPORT: ")) {
						((Screen)product).setCOMPOSITEport(Integer.parseInt(line.substring(15).trim()));
					}else if(line.trim().equalsIgnoreCase("RESOLUSION: ")) {
						((Screen)product).setResolution(line.substring(12).trim());
					}else if(num == 1 && line.trim().equalsIgnoreCase("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("NAME: ")){
						ord.setName(line.substring(6).trim());
					}else if(num == 2 && line.trim().equalsIgnoreCase("PHONE: ")){
						ord.setPhone(Long.parseLong(line.substring(7).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.substring(13).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.substring(14).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("NAME: ")){
						sl.setName(line.substring(6).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("PHONE: ")){
						sl.setPhone(Long.parseLong(line.substring(7).trim()));
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
					if (line.trim().equalsIgnoreCase("MODEL_NAME: ")) {
						((Keyboard)product).setmodelName(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("YEAR: ")) {
						((Keyboard)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("MANUFACTURER: ")){
						((Keyboard)product).setManufacturer(line.substring(14).trim());
					}else if(line.trim().equalsIgnoreCase("PRICE: ")){
						((Keyboard)product).setPrice(Integer.parseInt(line.substring(7).trim()));
					}else if(line.trim().equalsIgnoreCase("CONNECTION: ")) {
						((Keyboard)product).setConnection(line.substring(12).trim());
					}else if(num == 1 && line.trim().equalsIgnoreCase("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("NAME: ")){
						ord.setName(line.substring(6).trim());
					}else if(num == 2 && line.trim().equalsIgnoreCase("PHONE: ")){
						ord.setPhone(Long.parseLong(line.substring(7).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.substring(13).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.substring(14).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("NAME: ")){
						sl.setName(line.substring(6).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("PHONE: ")){
						sl.setPhone(Long.parseLong(line.substring(7).trim()));
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
					if (line.trim().equalsIgnoreCase("MODEL_NAME: ")) {
						((Mouse)product).setmodelName(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("YEAR: ")) {
						((Mouse)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("MANUFACTURER: ")){
						((Mouse)product).setManufacturer(line.substring(14).trim());
					}else if(line.trim().equalsIgnoreCase("PRICE: ")){
						((Mouse)product).setPrice(Integer.parseInt(line.substring(7).trim()));
					}else if(line.trim().equalsIgnoreCase("TECHNOLOGY: ")) {
						((Mouse)product).setTechnology(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("CONNECTION: ")) {
						((Mouse)product).setConnection(line.substring(12).trim());
					}else if(num == 1 && line.trim().equalsIgnoreCase("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("NAME: ")){
						ord.setName(line.substring(6).trim());
					}else if(num == 2 && line.trim().equalsIgnoreCase("PHONE: ")){
						ord.setPhone(Long.parseLong(line.substring(7).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.substring(13).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.substring(14).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("NAME: ")){
						sl.setName(line.substring(6).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("PHONE: ")){
						sl.setPhone(Long.parseLong(line.substring(7).trim()));
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
					if (line.trim().equalsIgnoreCase("MODEL_NAME: ")) {
						((Printer)product).setmodelName(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("YEAR: ")) {
						((Printer)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
					}else if(line.trim().equalsIgnoreCase("MANUFACTURER: ")){
						((Printer)product).setManufacturer(line.substring(14).trim());
					}else if(line.trim().equalsIgnoreCase("PRICE: ")){
						((Printer)product).setPrice(Integer.parseInt(line.substring(7).trim()));
					}else if(line.trim().equalsIgnoreCase("TECHNOLOGY: ")) {
						((Printer)product).setTechnology(line.substring(12).trim());
					}else if(line.trim().equalsIgnoreCase("PRINTER_TYPE: ")) {
						((Printer)product).setPrintingType(line.substring(14).trim());
					}else if(num == 1 && line.trim().equalsIgnoreCase("PIECES: ")){
						stk.setAvailableStock(Integer.parseInt(line.substring(8).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("NAME: ")){
						ord.setName(line.substring(6).trim());
					}else if(num == 2 && line.trim().equalsIgnoreCase("PHONE: ")){
						ord.setPhone(Long.parseLong(line.substring(7).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("FINAL_PRICE: ")){
						ord.setFP(Double.parseDouble(line.substring(13).trim()));
					}else if(num == 2 && line.trim().equalsIgnoreCase("ARRIVAL_DATE: ")){
						ord.setExpectedDate(line.substring(14).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("NAME: ")){
						sl.setName(line.substring(6).trim());
					}else if(num == 3 && line.trim().equalsIgnoreCase("PHONE: ")){
						sl.setPhone(Long.parseLong(line.substring(7).trim()));
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
