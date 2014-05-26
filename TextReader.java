import java.io.*;
import java.util.*;

public class TextReader{
	private List<Stock> stockList = new ArrayList<Stock>();
	private List<Order> orderList = new ArrayList<Order>();
	private List<Sell> soldList = new ArrayList<Sell>();
	static PcParts product = null;
	String line;
	BufferedReader reader = null;
	Stock stk = new Stock() ;
	Order ord = new Order();
	Sell sl = new Sell();
	File f = null;
	Map<String,String> map = new HashMap<String,String>();
	
	public List<Stock> StockTextReader(){
		try {
			f = new File("STOCK_LIST.txt");
		} catch (NullPointerException e) {
			System.err.println("Stock file not found.");
		}
		try {
			reader = new BufferedReader(new FileReader(f));
			System.out.println("The file has opened.");
		} catch (FileNotFoundException e) {
			System.err.println("Error opening stock file!");
		}
		try{
			line = reader.readLine();
			if(line != null){
				if (!line.trim().equals(" ")) {
					if (line.trim().startsWith("STOCK_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								while(line != null){
									line = reader.readLine();
									if(line == null) continue;
									if (line.trim().startsWith("ITEM")) {
										line = reader.readLine();
										if (line == null) continue;
										if (line.trim().equals("{")) {
											line = reader.readLine();
											while(!line.trim().equals("}")){
												System.out.println(line.trim());
												String split[] = line.trim().split(":");
												split[0] = split[0].toUpperCase();
												map.put(split[0],split[1]);
												line = reader.readLine();
											}
											if(map.containsKey("TYPE")  && map.containsKey("MODEL_NAME") && map.containsKey("PRICE")){
												if(map.get("TYPE").equalsIgnoreCase("CPU")){
													product = new CPU();
													readCPU(1);
												}else if(map.get("TYPE").equalsIgnoreCase("GPU")){
													product = new GPU();
													readGPU(1);
												}else if(map.get("TYPE").equalsIgnoreCase("MOTHERBOARD")){
													product = new Motherboard();
													readMOBO(1);
												}else if(map.get("TYPE").equalsIgnoreCase("RAM")){
													product = new RAM();
													readRAM(1);
												}else if(map.get("TYPE").equalsIgnoreCase("HARDDRIVE")){
													product = new HardDrive();
													readHD(1);
												}else if(map.get("TYPE").equalsIgnoreCase("KEYBOARD")){
													product = new Keyboard();
													readKeyboard(1);
												}else if(map.get("TYPE").equalsIgnoreCase("MOUSE")){
													product = new Mouse();
													readMouse(1);
												}else if(map.get("TYPE").equalsIgnoreCase("MONITOR")){
													product = new Screen();
													readMonitor(1);
												}else if(map.get("TYPE").equalsIgnoreCase("PRINTER")){
													product = new Printer();
													readPrinter(1);
												}
												stockList.add(stk);
											}else System.out.println("There is no item defined in this product");
											line = reader.readLine();
											map.clear();
											if(line.trim().equals("}")) break;
											
										}
									}
								}
							}
						}
					}
				}
			}
		} catch(IOException e){
			System.err.println("An IOException was caught");
			e.printStackTrace(System.out);
		}
		return stockList;
	}
	
	public List<Order> OrderTextReader(){
		try {
			f = new File("ORDER_LIST.txt");
		} catch (NullPointerException e) {
			System.err.println("Order file not found.");
		}
		try {
			reader = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening order file!");
		}
		try{
			line = reader.readLine();
			if(line == null) {
				System.out.println("The file has opened.");
				if (!line.trim().equals(" ")) {
					if (line.trim().startsWith("ORDER_LIST")) {
						line = reader.readLine();
						if (line == null){
							if (line.trim().equals("{")) {
								while(line != null){
									line = reader.readLine();
									if(line == null) continue;
									if (line.trim().startsWith("ITEM")) {
										line = reader.readLine();
										if (line == null) continue;
										if (line.trim().equals("{")) {
											while(line != "}"){
												line = reader.readLine();
												String split[] = line.trim().split(":");
												split[0] = split[0].toUpperCase();
												map.put(split[0],split[1]);
											}
											if(map.containsKey("TYPE") && map.containsKey("MODEL_NAME") && map.containsKey("PRICE")){
												if(map.get("TYPE").equalsIgnoreCase("CPU")){
													product = new CPU();
													readCPU(2);
												}else if(map.get("TYPE").equalsIgnoreCase("GPU")){
													product = new GPU();
													readGPU(2);
												}else if(map.get("TYPE").equalsIgnoreCase("MOTHERBOARD")){
													product = new Motherboard();
													readMOBO(2);
												}else if(map.get("TYPE").equalsIgnoreCase("RAM")){
													product = new RAM();
													readRAM(2);
												}else if(map.get("TYPE").equalsIgnoreCase("HARDDRIVE")){
													product = new HardDrive();
													readHD(2);
												}else if(map.get("TYPE").equalsIgnoreCase("KEYBOARD")){
													product = new Keyboard();
													readKeyboard(2);
												}else if(map.get("TYPE").equalsIgnoreCase("MOUSE")){
													product = new Mouse();
													readMouse(2);
												}else if(map.get("TYPE").equalsIgnoreCase("MONITOR")){
													product = new Screen();
													readMonitor(2);
												}else if(map.get("TYPE").equalsIgnoreCase("PRINTER")){
													product = new Printer();
													readPrinter(2);
												}
												orderList.add(ord);
											}else System.out.println("There is no item defined in this product");
											line = reader.readLine();
											map.clear();
											if(line.trim().equals("}")) break;
											
										}
									}
								}
							}
						}
					}
				}
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
			e.printStackTrace(System.out);
		}
		return orderList;
	}
	
	public List<Sell> SoldTextReader(){
		try {
			f = new File("SOLD_LIST.txt");
		} catch (NullPointerException e) {
			System.err.println("Sales file not found.");
		}
		try {
			reader = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening sales file!");
		}
		try{
			line = reader.readLine();
			if(line == null) {
				System.out.println("The file has opened.");
				if (!line.trim().equals(" ")) {
					if (line.trim().startsWith("SOLD_LIST")) {
						line = reader.readLine();
						if (line == null) {
							if (line.trim().equals("{")) {
								while(line != null){
									line = reader.readLine();
									if(line == null) continue;
									if (line.trim().startsWith("ITEM")) {
										line = reader.readLine();
										if (line == null) continue;
										if (line.trim().equals("{")) {
											while(line != "}"){
												line = reader.readLine();
												String split[] = line.trim().split(":");
												split[0] = split[0].toUpperCase();
												map.put(split[0],split[1]);
											}
											if(map.containsKey("TYPE") && map.containsKey("MODEL_NAME") && map.containsKey("PRICE")){
												if(map.get("TYPE").equalsIgnoreCase("CPU")){
													product = new CPU();
													readCPU(3);
												}else if(map.get("TYPE").equalsIgnoreCase("GPU")){
													product = new GPU();
													readGPU(3);
												}else if(map.get("TYPE").equalsIgnoreCase("MOTHERBOARD")){
													product = new Motherboard();
													readMOBO(3);
												}else if(map.get("TYPE").equalsIgnoreCase("RAM")){
													product = new RAM();
													readRAM(3);
												}else if(map.get("TYPE").equalsIgnoreCase("HARDDRIVE")){
													product = new HardDrive();
													readHD(3);
												}else if(map.get("TYPE").equalsIgnoreCase("KEYBOARD")){
													product = new Keyboard();
													readKeyboard(3);
												}else if(map.get("TYPE").equalsIgnoreCase("MOUSE")){
													product = new Mouse();
													readMouse(3);
												}else if(map.get("TYPE").equalsIgnoreCase("MONITOR")){
													product = new Screen();
													readMonitor(3);
												}else if(map.get("TYPE").equalsIgnoreCase("PRINTER")){
													product = new Printer();
													readPrinter(3);
												}
												soldList.add(sl);
											}else System.out.println("There is no item defined in this product");
											line = reader.readLine();
											map.clear();
											if(line.trim().equals("}")) break;
											
										}
									}else System.out.println("There is no item defined in this product");
									line = reader.readLine();
									map.clear();
									if(line.trim().equals("}")) break;
								}
							}
						}
					}
				}
			}
		}catch(IOException e){
			System.err.println("An IOException was caught");
			e.printStackTrace(System.out);
		}
		return soldList;
	}
	
	public void readCPU(int i){
		product.setmodelName(map.get("MODEL_NAME"));
		product.setManufacturer(map.get("MANUFACTURER"));
		product.setPrice(Integer.parseInt(map.get("PRICE")));
		product.setmodelYear(Integer.parseInt(map.get("YEAR")));
		((CPU)product).setSpeed(Double.parseDouble(map.get("SPEED")));
		((CPU)product).setCoreCount(Integer.parseInt(map.get("CORES")));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES")));
			stk.setThing(product);
		}else if(i==2){
			ord.setName(map.get("NAME"));
			ord.setPhone(Long.parseLong(map.get("PHONE")));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE")));
			ord.setExpectedDate(map.get("ARRIVAL_DATE"));
			ord.setThing(product);
		}else if(i==3){
			sl.setName(map.get("NAME"));
			sl.setPhone(Long.parseLong(map.get("PHONE")));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE")));
			sl.setThing(product);
		}
	}
	public void readRAM(int i){
		product.setmodelName(map.get("MODEL_NAME"));
		product.setManufacturer(map.get("MANUFACTURER"));
		product.setPrice(Integer.parseInt(map.get("PRICE")));
		product.setmodelYear(Integer.parseInt(map.get("YEAR")));
		((RAM)product).setType(map.get("MODEL_TYPE"));
		((RAM)product).setSize(Integer.parseInt(map.get("SIZE")));
		((RAM)product).setSpeed(Integer.parseInt(map.get("SPEED")));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES")));
		}else if(i==2){
			ord.setName(map.get("NAME"));
			ord.setPhone(Long.parseLong(map.get("PHONE")));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE")));
			ord.setExpectedDate(map.get("ARRIVAL_DATE"));
		}else if(i==3){
			sl.setName(map.get("NAME"));
			sl.setPhone(Long.parseLong(map.get("PHONE")));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE")));
		}
	}
	public void readGPU(int i){
		product.setmodelName(map.get("MODEL_NAME"));
		product.setManufacturer(map.get("MANUFACTURER"));
		product.setPrice(Integer.parseInt(map.get("PRICE")));
		product.setmodelYear(Integer.parseInt(map.get("YEAR")));
		((GPU)product).setChipset(map.get("CHIPSET"));
		((GPU)product).setMemory(Integer.parseInt(map.get("MEMORY: ")));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES")));
		}else if(i==2){
			ord.setName(map.get("NAME"));
			ord.setPhone(Long.parseLong(map.get("PHONE")));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE")));
			ord.setExpectedDate(map.get("ARRIVAL_DATE"));
		}else if(i==3){
			sl.setName(map.get("NAME"));
			sl.setPhone(Long.parseLong(map.get("PHONE")));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE")));
		}
	}
	public void readHD(int i){
		product.setmodelName(map.get("MODEL_NAME"));
		product.setManufacturer(map.get("MANUFACTURER"));
		product.setPrice(Integer.parseInt(map.get("PRICE")));
		product.setmodelYear(Integer.parseInt(map.get("YEAR")));
		((HardDrive)product).setType(map.get("TYPE"));
		((HardDrive)product).setWidth(Double.parseDouble(map.get("WIDTH")));
		((HardDrive)product).setSize(Integer.parseInt(map.get("SIZE")));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES")));
		}else if(i==2){
			ord.setName(map.get("NAME"));
			ord.setPhone(Long.parseLong(map.get("PHONE")));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE")));
			ord.setExpectedDate(map.get("ARRIVAL_DATE"));
		}else if(i==3){
			sl.setName(map.get("NAME"));
			sl.setPhone(Long.parseLong(map.get("PHONE")));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE")));
		}
	}
	public void readMOBO(int i){
		product.setmodelName(map.get("MODEL_NAME"));
		product.setManufacturer(map.get("MANUFACTURER"));
		product.setPrice(Integer.parseInt(map.get("PRICE")));
		product.setmodelYear(Integer.parseInt(map.get("YEAR")));
		((Motherboard)product).setChip(map.get("CHIP"));
		((Motherboard)product).setRAMSize(Integer.parseInt(map.get("SIZE")));
		((Motherboard)product).setExpansionSlots(Integer.parseInt(map.get("GATES")));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES")));
		}else if(i==2){
			ord.setName(map.get("NAME"));
			ord.setPhone(Long.parseLong(map.get("PHONE")));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE")));
			ord.setExpectedDate(map.get("ARRIVAL_DATE"));
		}else if(i==3){
			sl.setName(map.get("NAME"));
			sl.setPhone(Long.parseLong(map.get("PHONE")));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE")));
		}
	}
	public void readMonitor(int i){
		product.setmodelName(map.get("MODEL_NAME"));
		product.setManufacturer(map.get("MANUFACTURER"));
		product.setPrice(Integer.parseInt(map.get("PRICE")));
		product.setmodelYear(Integer.parseInt(map.get("YEAR")));
		((Screen)product).setType(map.get("TYPE"));
		((Screen)product).setSize(Double.parseDouble(map.get("SIZE")));
		((Screen)product).setHDMIport(Integer.parseInt(map.get("HDMIPORT")));
		((Screen)product).setDVIport(Integer.parseInt(map.get("DVIPORT")));
		((Screen)product).setCOMPOSITEport(Integer.parseInt(map.get("COMPOSITEPORT")));
		((Screen)product).setResolution(map.get("RESOLUSION"));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES")));
		}else if(i==2){
			ord.setName(map.get("NAME"));
			ord.setPhone(Long.parseLong(map.get("PHONE")));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE")));
			ord.setExpectedDate(map.get("ARRIVAL_DATE"));
		}else if(i==3){
			sl.setName(map.get("NAME"));
			sl.setPhone(Long.parseLong(map.get("PHONE")));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE")));
		}
	}
	public void readKeyboard(int i){
		product.setmodelName(map.get("MODEL_NAME"));
		product.setManufacturer(map.get("MANUFACTURER"));
		product.setPrice(Integer.parseInt(map.get("PRICE")));
		product.setmodelYear(Integer.parseInt(map.get("YEAR")));
		((Keyboard)product).setConnection(map.get("CONNECTION"));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES")));
		}else if(i==2){
			ord.setName(map.get("NAME"));
			ord.setPhone(Long.parseLong(map.get("PHONE")));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE")));
			ord.setExpectedDate(map.get("ARRIVAL_DATE"));
		}else if(i==3){
			sl.setName(map.get("NAME"));
			sl.setPhone(Long.parseLong(map.get("PHONE")));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE")));
		}
	}
	public void readMouse(int i){
		product.setmodelName(map.get("MODEL_NAME"));
		product.setManufacturer(map.get("MANUFACTURER"));
		product.setPrice(Integer.parseInt(map.get("PRICE")));
		product.setmodelYear(Integer.parseInt(map.get("YEAR")));
		((Mouse)product).setTechnology(map.get("TECHNOLOGY"));
		((Mouse)product).setConnection(map.get("CONNECTION"));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES")));
		}else if(i==2){
			ord.setName(map.get("NAME"));
			ord.setPhone(Long.parseLong(map.get("PHONE")));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE")));
			ord.setExpectedDate(map.get("ARRIVAL_DATE"));
		}else if(i==3){
			sl.setName(map.get("NAME"));
			sl.setPhone(Long.parseLong(map.get("PHONE")));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE")));
		}
	}
	public void readPrinter(int i){
		product.setmodelName(map.get("MODEL_NAME"));
		product.setManufacturer(map.get("MANUFACTURER"));
		product.setPrice(Integer.parseInt(map.get("PRICE")));
		product.setmodelYear(Integer.parseInt(map.get("YEAR")));
		((Printer)product).setTechnology(map.get("TECHNOLOGY"));
		((Printer)product).setPrintingType(map.get("PRINTER_TYPE"));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES")));
		}else if(i==2){
			ord.setName(map.get("NAME"));
			ord.setPhone(Long.parseLong(map.get("PHONE")));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE")));
			ord.setExpectedDate(map.get("ARRIVAL_DATE"));
		}else if(i==3){
			sl.setName(map.get("NAME"));
			sl.setPhone(Long.parseLong(map.get("PHONE")));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE")));
		}
	}
}