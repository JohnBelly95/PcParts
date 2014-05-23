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
		
	}
	
	public void OrderTextReader(List<Order> orderList){
		/*try{
			elegxos an oi paraggelies perilamvanontai sta diathesima proionta
		}
		catch(){
			eidopoihsh
		}*/
		
		try{
			reader = input.readLine();
			while (reader !=null){
				if (!reader.trim().equals(" ")) {
					if (reader.trim().equals("ORDER_LIST")) {
						reader = input.readLine();
						if (reader != null){
							if (reader.trim().equals("{")) {
								reader = input.readLine();
								if (reader != null){
									if (reader.trim().equals("ORDER")) {
										reader = input.readLine();
										if (reader != null){
											if (reader.trim().equals("{")) {
												reader = input.readLine();
												if (reader != null){
													if (reader.trim().startsWith("TYPE: ")) { 
														if (reader.trim().substring(6).trim().equals("CPU")) {
															product = new CPU();
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
	}
	
	public List<Sell> SoldTextReader(List<Sell> soldList){
		try { 
			f = new File("SOLD_LIST.txt"); 
		} catch (NullPointerException e) { 
			System.err.println("File not found."); 
		}
		try { 
			input = new BufferedReader(new InputStreamReader(new FileInputStream(f))); 
		} catch (FileNotFoundException e) { 
			System.err.println("Error opening file!"); 
		}
		try {
			reader = input.readLine(); 
			
			while (reader != null) {
				if (!reader.trim().equals(" ")) {
					if (reader.trim().equals("SOLD_LIST")) {
						reader = input.readLine();
						
						if (reader != null) {
							if (reader.trim().equals("{")) {
								reader = input.readLine(); 
							
								if (reader != null) {
									if (reader.trim().equals("SOLD")) {
										reader = input.readLine(); 
											
										if (reader != null) {
											if (reader.trim().equals("{")) {
												reader = input.readLine(); 
							
												if (reader != null){
													if (reader.trim().startsWith("TYPE: ")) { 
														if (reader.trim().substring(6).trim().equals("CPU")) {
															product = new CPU();
															int j = 0;
															while(j !=6){
																reader = input.readLine();
																if(reader != null){
																	if (reader.trim().startsWith("MODEL_NAME: ")) { 
																		product.setmodelName(reader.substring(12).trim());
																		j++;
																	}
																	if (reader.trim().startsWith("MANUFACTURER: ")){ 
																		product.setManufacturer(reader.trim().substring(14).trim()); 
																		j++;
																	}
																	if (reader.trim().startsWith("YEAR: ")){
																		product.setmodelYear(Integer.parseInt(reader.substring(6).trim()));
																		j++;
																	}
																	if (reader.trim().startsWith("PRICE: ")){
																		product.setPrice(Integer.parseInt(reader.substring(7).trim()));
																		j++;
																	}
																	if(reader.trim().startsWith("SPEED: ")){
																		((CPU)product).setSpeed(Double.ParseDouble(reader.substring(7)));
																		j++;
																	}
																	if (reader.trim().startsWith("CORES: ")){
																		product.setCoreCount(Integer.parseInt(reader.substring(7).trim()));
																		j++;
																	}
																}
															}
															if (line.trim().equals("}")){
																
																
																
																soldList.add(s1); 
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

					}//while 
				}
			}
		} catch (IOException e) { 
			System.out.println("Line " + counter + ": Sudden end."); 
		} 
		try { 
			reader.close(); 
		} catch (IOException e) { 
			System.err.println("Error closing file."); 
		} 

	} 

	public Item get(int i){ 
		return StoreProducts.get(i); 
	} 

	public int size() { 
		return StoreProducts.size(); 
	}
}
