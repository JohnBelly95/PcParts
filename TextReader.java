//skeutomai na ftiaksoume 9 antikeimena kai meta me tis set na tous dinoume tis times tous mia mia alla dn kserw pws h klassh 8a gurnaei to antikeimeno molis fiaxtei
import java.io.*;
import java.util.*;

public class TextReader{

	private List<Stock> stockList;
	private List<Order> orderList;
	private List<Sell> soldList;
	static BufferedReader input;
	static PcParts product = null;
	String line;
	BufferReader reader = null;

	public void StockTextReader(List<Stock> stockList){
		try{
			line = reader.readLine();
			while (line !=null){
				if (!line.trim().equals(" ")) {
					if (line.trim().equals("STOCK_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								if (line != null){
									if (line.trim().equals("ITEM")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												if(line != null){
													if(line.trim().equals("TYPE:"){
														line = reader.readLine();
														if(line != null){
															if(line.trim().equals("RAM"){
																product = new RAM();
																readRAM(1);
															}else if(line.trim().equals("CPU"){
																product = new CPU();
																readCPU(1);
															}else if(line.trim().equals("GPU"){
																product = new GPU();
																readGPU(1);
															}else if(line.trim().equals("HARDDRIVE"){
																product = new Harddrive();
																readHARDDRIVE(1);
															}else if(line.trim().equals("MOTHERBOARD"){
																product = new Motherboard();
																readMOTHERBOARD(1);
															}else if(line.trim().equals("KEYBOARD"){
																product = new Keyboard();
																readRKEYBOARD(1);
															}else if(line.trim().equals("MOUSE"){
																product = new Mouse();
																readMOUSE(1);
															}else if(line.trim(1).equals("MONITOR"){
																product = new Screen();
																readMONITOR();
															}else if(line.trim(1).equals("PRINTER"){
																product = new Printer();
																readPRINTER();
															}else break;
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
			while (line !=null){
				if (!line.trim().equals(" ")) {
					if (line.trim().equals("ORDER_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								if (line != null){
									if (line.trim().equals("ORDER")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												//anagnorisi metavlitwn
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void SoldTextReader(List<Sell> soldList){
		this.soldList = soldList;
		try{
			line = reader.readLine();
			while (line !=null){
				if (!line.trim().equals(" ")) {
					if (line.trim().equals("SOLD_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								line = reader.readLine();
								if (line != null){
									if (line.trim().equals("SOLD")) {
										line = reader.readLine();
										if (line != null){
											if (line.trim().equals("{")) {
												line = reader.readLine();
												if(line != null){
													if(line.trim().equals("TYPE: "){
														line = reader.readLine();
														if(line != null){
															if(line.trim().substring(6).trim().equals("RAM"){
																product = new RAM();
																readRAM(3);
															}else if(line.trim().substring(6).trim().equals("CPU"){
																product = new CPU();
																readCPU(3);
															}else if(line.trim().substring(6).trim().equals("GPU"){
																product = new GPU();
																readGPU(3);
															}else if(line.trim().substring(6).trim().equals("HARDDRIVE"){
																product = new HardDrive();
																readHARDDRIVE(3);
															}else if(line.trim().substring(6).trim().equals("MOTHERBOARD"){
																product = new Motherboard();
																readMOTHERBOARD(3);
															}else if(line.trim().substring(6).trim().equals("KEYBOARD"){
																product = new Keyboard();
																readKEYBOARD(3);
															}else if(line.trim().substring(6).trim().equals("MOUSE"){
																product = new Mouse();
																readMOUSE(3);
															}else if(line.trim().substring(6).trim().equals("MONITOR"){
																product = new Screen();
																readMONITOR(3);
															}else if(line.trim().substring(6).trim().equals("PRINTER"){
																product =  new Printer();
																readPRINTER(3);
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
					if(line.trim().equals("}"){
						line = reader.readLine();
					}
				}
			}
		}
		catch(IOException e){
			System.err.println("An IOException was caught);
		}
		return
	}
	
	public void readRAM(int num){//  RAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA              AAAAAAAAAAAAAAAAAAAAAAAAM
		stk = new Stock(product);
		ord = new Order(product);
		sl = new Sell(product);
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((RAM)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((RAM)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((RAM)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: "){
					((RAM)product).setPrice(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("MODEL_TYPE: ")) {
					((RAM)product).setmodelType(line.substring(12).trim());
				}else if(line.trim().equals("SIZE: ")) {
					((RAM)product).setSize(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("SPEED: ")){
					((RAM)product).setSpeed(Integer.parseInt(line.substring(7).trim()));
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setsavailableStock(line.substring(8).trim());
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: "){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: "){
					sl.setPhone(line.substring(7).trim());
				}else break;
			}
		}
	}
	public void readCPU(int num){  //           C     P     U
		stk = new Stock(product);
		ord = new Order(product);
		sl = new Sell(product);
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((CPU)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((CPU)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((CPU)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: "){
					((CPU)product).setPrice(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("SPEED: ")) {
					((CPU)product).setSpeed(Integer.parseInt(line.substring(7).trim()));
				}else if(line.trim().equals("CORES: ")){
					((CPU)product).setCoreCount(line.substring(7).trim());
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setsavailableStock(line.substring(8).trim());
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: "){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: "){
					sl.setPhone(line.substring(7).trim());
				}else break;
				
			}
		}
	}
	public void readGPU(int num){ //                         G         P         U
		stk = new Stock(product);
		ord = new Order(product);
		sl = new Sell(product);
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((GPU)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((GPU)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((GPU)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: "){
					((GPU)product).setPrice(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("CHIPSET: ")) {
					((GPU)product).setChipset(line.substring(9).trim());
				}else if(line.trim().equals("MEMORY: ")) {
					((GPU)product).setSpeed(Integer.parseInt(line.substring(8).trim()));
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setsavailableStock(line.substring(8).trim());
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: "){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: "){
					sl.setPhone(line.substring(7).trim());
				}else break;
				
			}
		}
	}
	public void readHARDDRIVE(int num){ //               H   A   R   D   D   R   I   V   E
		stk = new Stock(product);
		ord = new Order(product);
		sl = new Sell(product);
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((Harddrive)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((Harddrive)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((Harddrive)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: "){
					((Harddrive)product).setPrice(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("TYPE: ")) {
					((Harddrive)product).setType(line.substring(6).trim());
				}else if(line.trim().equals("WIDTH: ")) {
					((Harddrive)product).setWidth(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("SIZE: ")) {
					((Harddrive)product).setSize(Integer.parseInt(line.substring(6).trim())));
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setsavailableStock(line.substring(8).trim());
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: "){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: "){
					sl.setPhone(line.substring(7).trim());
				}else break;
				
			}
		}
	}
	public void readMOTHERBOARD(int num){  //           M   O   T   H   E   R   B   O   A   R   D
		stk = new Stock(product);
		ord = new Order(product);
		sl = new Sell(product);
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((Motherboard)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((Motherboard)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((Motherboard)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: "){
					((Motherboard)product).setPrice(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("CHIP: ")) {
					((Motherboard)product).setChip(line.substring(6).trim());
				}else if(line.trim().equals("SIZE: ")) {
					((Motherboard)product).setRAMSize(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("GATES: ")) {
					((Motherboard)product).setExpansionSlots(Integer.parseInt(line.substring(7).trim())));
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setsavailableStock(line.substring(8).trim());
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: "){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: "){
					sl.setPhone(line.substring(7).trim());
				}else break;
				
			}
		}
	}
	public void readMONITOR(int num){  //                           S   C   R   E   E   N
		stk = new Stock(product);
		ord = new Order(product);
		sl = new Sell(product);
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((Screen)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((Screen)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((Screen)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: "){
					((Screen)product).setPrice(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("TYPE: ")) {
					((Screen)product).setType(line.substring(6).trim());
				}else if(line.trim().equals("SIZE: ")) {
					((Screen)product).setSize(Double.parseDouble(line.substring(6).trim()));
				}else if(line.trim().equals("PORTS: ")) {
					((Screen)product).setPorts(Integer.parseInt(line.substring(7).trim())));
				}else if(line.trim().equals("RESOLUSION: ")) {
					((Screen)product).setResolution(line.substring(12).trim());
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setsavailableStock(line.substring(8).trim());
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: "){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: "){
					sl.setPhone(line.substring(7).trim());
				}else break;
				
			}
		}
	}
	public void readKEYBOARD(int num){         //                       K   E   Y   B   O   A   R   D
		stk = new Stock(product);
		ord = new Order(product);
		sl = new Sell(product);
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((Keyboard)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((Keyboard)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((Keyboard)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: "){
					((Keyboard)product).setPrice(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("CONNECTION: ")) {
					((Keyboard)product).setConnection(line.substring(12).trim());
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setsavailableStock(line.substring(8).trim());
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: "){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: "){
					sl.setPhone(line.substring(7).trim());
				}else break;
				
			}
		}
	}
	public void readMOUSE(int num){ //                  M  O  U  S  E
		stk = new Stock(product);
		ord = new Order(product);
		sl = new Sell(product);
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((Mouse)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((Mouse)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((Mouse)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: "){
					((Mouse)product).setPrice(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("TECHNOLOGY: ")) {
					((Mouse)product).setTechnology(line.substring(12).trim());
				}else if(line.trim().equals("CONNECTION: ")) {
					((Mouse)product).setConnection(line.substring(12).trim());
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setsavailableStock(line.substring(8).trim());
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: "){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: "){
					sl.setPhone(line.substring(7).trim());
				}else break;
				
			}
		}
	}
	public void readPRINTER(int num){ //                         P   R   I   N   T   E   R
		stk = new Stock(product);
		ord = new Order(product);
		sl = new Sell(product);
		while(true){
			line = reader.readLine();
			if(line != null){
				if (line.trim().equals("MODEL_NAME: ")) {
					((Printer)product).setmodelName(line.substring(12).trim());
				}else if(line.trim().equals("YEAR: ")) {
					((Printer)product).setmodelYear(Integer.parseInt(line.substring(6).trim()));
				}else if(line.trim().equals("MANUFACTURER: ")){
					((Printer)product).setManufacturer(line.substring(14).trim());
				}else if(line.trim().equals("PRICE: "){
					((Printer)product).setPrice(Double.parseDouble(line.substring(7).trim()));
				}else if(line.trim().equals("TECHNOLOGY: ")) {
					((Printer)product).setTechnology(line.substring(12).trim());
				}else if(line.trim().equals("PRINTER_TYPE: ")) {
					((Printer)product).setPrintingType(line.substring(14).trim());
				}else if(num == 1 && line.trim().equals("PIECES: ")){
					stk.setsavailableStock(line.substring(8).trim());
				}else if(num == 2 && line.trim().equals("NAME: ")){
					ord.setName(line.substring(6).trim());
				}else if(num == 2 && line.trim().equals("PHONE: ")){
					ord.setPhone(Long.parseLong(line.substring(7).trim()));
				}else if(num == 2 && line.trim().equals("FINAL_PRICE: ")){
					ord.setFP(Double.parseDouble(line.substring(13).trim()));
				}else if(num == 2 && line.trim().equals("ARRIVAL_DATE: ")){
					ord.setExpectedDate(line.substring(14).trim());
				}else if(num == 3 && line.trim().equals("NAME: "){
					sl.setName(line.substring(6).trim());
				}else if(num == 3 && line.trim().equals("PHONE: "){
					sl.setPhone(line.substring(7).trim());
				}else break;
				
			}
		}
	}
}
