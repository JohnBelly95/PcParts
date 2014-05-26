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
	private File f = null;
	private int i;
	Map<String,String> map = new HashMap<String,String>();
	
	public List<Stock> StockTextReader(){
		try {
			f = new File("STOCK_LIST.txt");
		} catch (NullPointerException e) {
			System.err.println("Stock file not found.");
		}
		try {
			reader = new BufferedReader(new FileReader(f));
			System.out.println("The Stock file has opened.");
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
												String split[] = line.trim().split(":");
												split[0] = split[0].toUpperCase();
												map.put(split[0],split[1]);
												line = reader.readLine();
											}
											i = 1;
											if(map.containsKey("TYPE") && map.containsKey("MODEL_NAME") && map.containsKey("PRICE")){
												String str = map.get("TYPE");
												if(str.trim().equalsIgnoreCase("CPU")){
													product = new CPU();
													readCPU(i);
												}else if(str.trim().equalsIgnoreCase("GPU")){
													product = new GPU();
													readGPU(i);
												}else if(str.trim().equalsIgnoreCase("MOTHERBOARD")){
													product = new Motherboard();
													readMOBO(i);
												}else if(str.trim().equalsIgnoreCase("RAM")){
													product = new RAM();
													readRAM(i);
												}else if(str.trim().equalsIgnoreCase("HARDDRIVE")){
													product = new HardDrive();
													readHD(i);
												}else if(str.trim().equalsIgnoreCase("KEYBOARD")){
													product = new Keyboard();
													readKeyboard(i);
												}else if(str.trim().equalsIgnoreCase("MOUSE")){
													product = new Mouse();
													readMouse(i);
												}else if(str.trim().equalsIgnoreCase("MONITOR")){
													product = new Screen();
													readMonitor(i);
												}else if(str.trim().equalsIgnoreCase("PRINTER")){
													product = new Printer();
													readPrinter(i);
												}else System.out.println("There was an error.");
												stk.setThing(product);
												stockList.add(stk);
											}else System.out.println("There is no item defined in this product");
											line = reader.readLine();
											map.clear();
											if(line.trim().equals("}")){
												System.out.println("Everything seems to be in order here.");
												break;
											}
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
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Error closing file.");
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
			System.out.println("The Orders file has opened.");
		} catch (FileNotFoundException e) {
			System.err.println("Error opening order file!");
		}
		try{
			line = reader.readLine();
			if(line != null){
				if (!line.trim().equals(" ")) {
					if (line.trim().startsWith("ORDER_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								while(line != null){
									line = reader.readLine();
									if(line == null) continue;
									if (line.trim().startsWith("ORDER")) {
										line = reader.readLine();
										if (line == null) continue;
										if (line.trim().equals("{")) {
											line = reader.readLine();
											while(!line.trim().equals("}")){
												String split[] = line.trim().split(":");
												split[0] = split[0].toUpperCase();
												map.put(split[0],split[1]);
												line = reader.readLine();
											}
											i = 2;
											if(map.containsKey("TYPE") && map.containsKey("MODEL_NAME") && map.containsKey("PRICE")){
												String str = map.get("TYPE");
												if(str.trim().equalsIgnoreCase("CPU")){
													product = new CPU();
													readCPU(i);
												}else if(str.trim().equalsIgnoreCase("GPU")){
													product = new GPU();
													readGPU(i);
												}else if(str.trim().equalsIgnoreCase("MOTHERBOARD")){
													product = new Motherboard();
													readMOBO(i);
												}else if(str.trim().equalsIgnoreCase("RAM")){
													product = new RAM();
													readRAM(i);
												}else if(str.trim().equalsIgnoreCase("HARDDRIVE")){
													product = new HardDrive();
													readHD(i);
												}else if(str.trim().equalsIgnoreCase("KEYBOARD")){
													product = new Keyboard();
													readKeyboard(i);
												}else if(str.trim().equalsIgnoreCase("MOUSE")){
													product = new Mouse();
													readMouse(i);
												}else if(str.trim().equalsIgnoreCase("MONITOR")){
													product = new Screen();
													readMonitor(i);
												}else if(str.trim().equalsIgnoreCase("PRINTER")){
													product = new Printer();
													readPrinter(i);
												}else System.out.println("There was an error");
												stk.setThing(product);
												orderList.add(ord);
											}else System.out.println("There is no item defined in this product");
											line = reader.readLine();
											map.clear();
											if(line.trim().equals("}")){
												System.out.println("Everything seems to be in order here.");
												break;
											}
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
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Error closing file.");
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
			System.out.println("The Sales file has opened.");
		} catch (FileNotFoundException e) {
			System.err.println("Error opening sales file!");
		}
		try{
			line = reader.readLine();
			if(line != null){
				if (!line.trim().equals(" ")) {
					if (line.trim().startsWith("SOLD_LIST")) {
						line = reader.readLine();
						if (line != null){
							if (line.trim().equals("{")) {
								while(line != null){
									line = reader.readLine();
									if(line == null) continue;
									if (line.trim().startsWith("SOLD")) {
										line = reader.readLine();
										if (line == null) continue;
										if (line.trim().equals("{")) {
											line = reader.readLine();
											while(!line.trim().equals("}")){
												String split[] = line.trim().split(":");
												split[0] = split[0].toUpperCase();
												map.put(split[0],split[1]);
												line = reader.readLine();
											}
											i = 3;
											if(map.containsKey("TYPE") && map.containsKey("MODEL_NAME") && map.containsKey("PRICE")){
												String str = map.get("TYPE");
												if(str.trim().equalsIgnoreCase("CPU")){
													product = new CPU();
													readCPU(i);
												}else if(str.trim().equalsIgnoreCase("GPU")){
													product = new GPU();
													readGPU(i);
												}else if(str.trim().equalsIgnoreCase("MOTHERBOARD")){
													product = new Motherboard();
													readMOBO(i);
												}else if(str.trim().equalsIgnoreCase("RAM")){
													product = new RAM();
													readRAM(i);
												}else if(str.trim().equalsIgnoreCase("HARDDRIVE")){
													product = new HardDrive();
													readHD(i);
												}else if(str.trim().equalsIgnoreCase("KEYBOARD")){
													product = new Keyboard();
													readKeyboard(i);
												}else if(str.trim().equalsIgnoreCase("MOUSE")){
													product = new Mouse();
													readMouse(i);
												}else if(str.trim().equalsIgnoreCase("MONITOR")){
													product = new Screen();
													readMonitor(i);
												}else if(str.trim().equalsIgnoreCase("PRINTER")){
													product = new Printer();
													readPrinter(i);
												}else System.out.println("There was an error");
												stk.setThing(product);
												soldList.add(sl);
											}else System.out.println("There is no item defined in this product");
											line = reader.readLine();
											map.clear();
											if(line.trim().equals("}")){
												System.out.println("Everything seems to be in order here.");
												break;
											}
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
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Error closing file.");
		}

		return soldList;
	}
	
	public void readCPU(int i){
		product.setmodelName(map.get("MODEL_NAME").trim());
		product.setManufacturer(map.get("MANUFACTURER").trim());
		product.setPrice(Integer.parseInt(map.get("PRICE").trim()));
		product.setmodelYear(Integer.parseInt(map.get("YEAR").trim()));
		((CPU)product).setSpeed(Double.parseDouble(map.get("SPEED").trim()));
		((CPU)product).setCoreCount(Integer.parseInt(map.get("CORES").trim()));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES").trim()));
			stk.setThing(product);
		}else if(i==2){
			ord.setName(map.get("NAME"));
			ord.setPhone(Long.parseLong(map.get("PHONE").trim()));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			ord.setExpectedDate(map.get("ARRIVAL_DATE").trim());
			ord.setThing(product);
		}else if(i==3){
			sl.setName(map.get("NAME").trim());
			sl.setPhone(Long.parseLong(map.get("PHONE").trim()));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			sl.setThing(product);
		}
	}
	public void readRAM(int i){
		product.setmodelName(map.get("MODEL_NAME").trim());
		product.setManufacturer(map.get("MANUFACTURER").trim());
		product.setPrice(Integer.parseInt(map.get("PRICE").trim()));
		product.setmodelYear(Integer.parseInt(map.get("YEAR").trim()));
		((RAM)product).setType(map.get("MODEL_TYPE").trim());
		((RAM)product).setSize(Integer.parseInt(map.get("SIZE").trim()));
		((RAM)product).setSpeed(Integer.parseInt(map.get("SPEED").trim()));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES").trim()));
			stk.setThing(product);
		}else if(i==2){
			ord.setName(map.get("NAME").trim());
			ord.setPhone(Long.parseLong(map.get("PHONE").trim()));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			ord.setExpectedDate(map.get("ARRIVAL_DATE").trim());
			ord.setThing(product);
		}else if(i==3){
			sl.setName(map.get("NAME").trim());
			sl.setPhone(Long.parseLong(map.get("PHONE").trim()));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			sl.setThing(product);
		}
	}
	public void readGPU(int i){
		product.setmodelName(map.get("MODEL_NAME").trim());
		product.setManufacturer(map.get("MANUFACTURER").trim());
		product.setPrice(Integer.parseInt(map.get("PRICE").trim()));
		product.setmodelYear(Integer.parseInt(map.get("YEAR").trim()));
		((GPU)product).setChipset(map.get("CHIPSET").trim());
		((GPU)product).setMemory(Integer.parseInt(map.get("MEMORY").trim()));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES").trim()));
			stk.setThing(product);
		}else if(i==2){
			ord.setName(map.get("NAME").trim());
			ord.setPhone(Long.parseLong(map.get("PHONE").trim()));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			ord.setExpectedDate(map.get("ARRIVAL_DATE").trim());
			ord.setThing(product);
		}else if(i==3){
			sl.setName(map.get("NAME").trim());
			sl.setPhone(Long.parseLong(map.get("PHONE").trim()));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			sl.setThing(product);
		}
	}
	public void readHD(int i){
		product.setmodelName(map.get("MODEL_NAME").trim());
		product.setManufacturer(map.get("MANUFACTURER").trim());
		product.setPrice(Integer.parseInt(map.get("PRICE").trim()));
		product.setmodelYear(Integer.parseInt(map.get("YEAR").trim()));
		((HardDrive)product).setType(map.get("MODEL_TYPE").trim());
		((HardDrive)product).setWidth(Double.parseDouble(map.get("WIDTH").trim()));
		((HardDrive)product).setSize(Integer.parseInt(map.get("SIZE").trim()));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES").trim()));
			stk.setThing(product);
		}else if(i==2){
			ord.setName(map.get("NAME").trim());
			ord.setPhone(Long.parseLong(map.get("PHONE").trim()));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			ord.setExpectedDate(map.get("ARRIVAL_DATE").trim());
			ord.setThing(product);
		}else if(i==3){
			sl.setName(map.get("NAME").trim());
			sl.setPhone(Long.parseLong(map.get("PHONE").trim()));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			sl.setThing(product);
		}
	}
	public void readMOBO(int i){
		product.setmodelName(map.get("MODEL_NAME").trim());
		product.setManufacturer(map.get("MANUFACTURER").trim());
		product.setPrice(Integer.parseInt(map.get("PRICE").trim()));
		product.setmodelYear(Integer.parseInt(map.get("YEAR").trim()));
		((Motherboard)product).setChip(map.get("CHIP").trim());
		((Motherboard)product).setRAMSize(Integer.parseInt(map.get("SIZE").trim()));
		((Motherboard)product).setExpansionSlots(Integer.parseInt(map.get("GATES").trim()));
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES").trim()));
			stk.setThing(product);
		}else if(i==2){
			ord.setName(map.get("NAME"));
			ord.setPhone(Long.parseLong(map.get("PHONE").trim()));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			ord.setExpectedDate(map.get("ARRIVAL_DATE").trim());
			ord.setThing(product);
		}else if(i==3){
			sl.setName(map.get("NAME").trim());
			sl.setPhone(Long.parseLong(map.get("PHONE").trim()));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			sl.setThing(product);
		}
	}
	public void readMonitor(int i){
		product.setmodelName(map.get("MODEL_NAME").trim());
		product.setManufacturer(map.get("MANUFACTURER").trim());
		product.setPrice(Integer.parseInt(map.get("PRICE").trim()));
		product.setmodelYear(Integer.parseInt(map.get("YEAR").trim()));
		((Screen)product).setType(map.get("TYPE"));
		((Screen)product).setSize(Double.parseDouble(map.get("SIZE").trim()));
		((Screen)product).setHDMIport(Integer.parseInt(map.get("HDMIPORT").trim()));
		((Screen)product).setDVIport(Integer.parseInt(map.get("DVIPORT").trim()));
		((Screen)product).setCOMPOSITEport(Integer.parseInt(map.get("COMPOSITEPORT".trim())));
		((Screen)product).setResolution(map.get("RESOLUSION").trim());
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES").trim()));
			stk.setThing(product);
		}else if(i==2){
			ord.setName(map.get("NAME").trim());
			ord.setPhone(Long.parseLong(map.get("PHONE").trim()));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			ord.setExpectedDate(map.get("ARRIVAL_DATE").trim());
			ord.setThing(product);
		}else if(i==3){
			sl.setName(map.get("NAME").trim());
			sl.setPhone(Long.parseLong(map.get("PHONE").trim()));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			sl.setThing(product);
		}
	}
	public void readKeyboard(int i){
		product.setmodelName(map.get("MODEL_NAME").trim());
		product.setManufacturer(map.get("MANUFACTURER").trim());
		product.setPrice(Integer.parseInt(map.get("PRICE").trim()));
		product.setmodelYear(Integer.parseInt(map.get("YEAR").trim()));
		((Keyboard)product).setConnection(map.get("CONNECTION").trim());
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES").trim()));
			stk.setThing(product);
		}else if(i==2){
			ord.setName(map.get("NAME").trim());
			ord.setPhone(Long.parseLong(map.get("PHONE").trim()));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			ord.setExpectedDate(map.get("ARRIVAL_DATE").trim());
			ord.setThing(product);
		}else if(i==3){
			sl.setName(map.get("NAME"));
			sl.setPhone(Long.parseLong(map.get("PHONE").trim()));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			sl.setThing(product);
		}
	}
	public void readMouse(int i){
		product.setmodelName(map.get("MODEL_NAME").trim());
		product.setManufacturer(map.get("MANUFACTURER").trim());
		product.setPrice(Integer.parseInt(map.get("PRICE").trim()));
		product.setmodelYear(Integer.parseInt(map.get("YEAR").trim()));
		((Mouse)product).setTechnology(map.get("TECHNOLOGY").trim());
		((Mouse)product).setConnection(map.get("CONNECTION").trim());
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES").trim()));
			stk.setThing(product);
		}else if(i==2){
			ord.setName(map.get("NAME").trim());
			ord.setPhone(Long.parseLong(map.get("PHONE").trim()));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			ord.setExpectedDate(map.get("ARRIVAL_DATE").trim());
			ord.setThing(product);
		}else if(i==3){
			sl.setName(map.get("NAME").trim());
			sl.setPhone(Long.parseLong(map.get("PHONE").trim()));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			sl.setThing(product);
		}
	}
	public void readPrinter(int i){
		product.setmodelName(map.get("MODEL_NAME").trim());
		product.setManufacturer(map.get("MANUFACTURER").trim());
		product.setPrice(Integer.parseInt(map.get("PRICE").trim()));
		product.setmodelYear(Integer.parseInt(map.get("YEAR").trim()));
		((Printer)product).setTechnology(map.get("TECHNOLOGY").trim());
		((Printer)product).setPrintingType(map.get("PRINTER_TYPE").trim());
		if(i==1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES").trim()));
			stk.setThing(product);
		}else if(i==2){
			ord.setName(map.get("NAME").trim());
			ord.setPhone(Long.parseLong(map.get("PHONE").trim()));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			ord.setExpectedDate(map.get("ARRIVAL_DATE").trim());
			ord.setThing(product);
		}else if(i==3){
			sl.setName(map.get("NAME").trim());
			sl.setPhone(Long.parseLong(map.get("PHONE").trim()));
			sl.setFp(Double.parseDouble(map.get("FINAL_PRICE").trim()));
			sl.setThing(product);
		}
	}
}