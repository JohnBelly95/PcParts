import java.io.*;
import java.util.*;

public class TextReader{

	private List<Stock> stockList;
	private List<Order> orderList;
	private List<Sell> soldList;
	static BufferedReader input;
	
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
	
	}

}
