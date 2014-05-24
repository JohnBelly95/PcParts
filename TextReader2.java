import java.io.*;
import java.util.*;

public class TextReader2{
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
	Map<String,String> map = new Map<String,String>;
	
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
			if(line == null) continue;
			System.out.println("The file has opened.");
			if (!line.trim().equals(" ")) {
				if (line.trim().startsWith("STOCK_LIST")) {
					line = reader.readLine();
					if (line == null) continue;
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
										String split[] = line.trim().split(":").trim();
										split[0] = split[0].toUpperCase();
										map.put(split[0],split[1]);
									}
									if(map.containsKey("TYPE")){
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
									}else System.out.println("There is no item defined in this product");
									line = readLine();
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
	public void readCPU(int i){
		product.setmodelName(map.get("MODEL_NAME"));
		product.setManufacturer(map.get("MANUFACTURER"));
		product.setPrice(Integer.parseInt(map.get("PRICE")));
		product.setYear(Integer.parseInt(map.get("YEAR")));
		((CPU)product).setSpeed(Double.parseDouble(map.get("SPEED")));
		((CPU)product).setCores(Integer.parseInt(map.get("CORES")));
		if(i=1){
			stk.setAvailableStock(Integer.parseInt(map.get("PIECES")));
		}else if(i=2){
			ord.setName(map.get("NAME"));
			ord.setPhone(map.get("PHONE"));
			ord.setFP(Double.parseDouble(map.get("FINAL_PRICE")));
			ord.setExpectedDate(map.get("ARRIVAL_DATE"));
		}else if(i=3){
			sl.setName(map.get("NAME"));
			sl.setPhone(map.get("PHONE"));
			sl.setFP(Double.parseDouble(map.get("FINAL_PRICE")));
		}
	}
}