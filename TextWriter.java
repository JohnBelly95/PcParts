import java.io.*;
import java.util.*;

public class TextWriter{
	//Variables
	private List<Stock> stockList;
	private List<Order> orderList;
	private List<Sell> soldList;
	static BufferedReader input;
	static BufferedWriter output;
	
	public void StockTextWriter(List<Stock> stockList) throws FileNotFoundException, IOException {
		this.stockList = stockList;
		try {
			input = new BufferedReader(new FileReader("STOCK_LIST.txt"));
			output = new BufferedWriter(new FileWriter("STOCK_LIST.txt"));
			String inputLine = null;
			while((inputLine = input.readLine()) != null)
				System.out.println(inputLine);
		}
		catch(IOException ex) {
			System.err.println("An IOException was caught!");
            ex.printStackTrace();
        }
		output.write("STOCK_LIST\n{");
		for(int i=0; i<stockList.size(); i++){
			output.write("\n\tITEM\n\t{" + stockList.get(i).toString() + "\n\t}",0,(stockList.get(i).toString().length() + 12));
		}
		output.write("\n}");
		output.close();
	}
	
	public void OrderTextWriter(List<Order> orderList) throws FileNotFoundException, IOException {
		this.orderList = orderList;
		try {
			input = new BufferedReader(new FileReader("STOCK_LIST.txt"));
			output = new BufferedWriter(new FileWriter("STOCK_LIST.txt"));
			String inputLine = null;
			while((inputLine = input.readLine()) != null)
				System.out.println(inputLine);
		}
		catch(IOException ex) {
			System.err.println("An IOException was caught!");
            ex.printStackTrace();
        }
		output.write("ORDER_LIST\n{");
		for(int i=0; i<orderList.size(); i++){
			output.write("\n\tORDER\n\t{" + orderList.get(i).toString() + "\n\t}",0,(orderList.get(i).toString().length() + 12));
		}
		output.write("\n}");
		output.close();
	}
	
	public void SoldTextWriter(List<Sell> soldList) throws FileNotFoundException, IOException{
		this.soldList = soldList;
		try {
			input = new BufferedReader(new FileReader("STOCK_LIST.txt"));
			output = new BufferedWriter(new FileWriter("STOCK_LIST.txt"));
			String inputLine = null;
			while((inputLine = input.readLine()) != null)
				System.out.println(inputLine);
		}
		catch(IOException ex) {
			System.err.println("An IOException was caught!");
            ex.printStackTrace();
        }
		output.write("SOLD_LIST\n{");
		for(int i=0; i<soldList.size(); i++){
			output.write("\n\tSOLD\n\t{" + soldList.get(i).toString() + "\n\t}",0,(soldList.get(i).toString().length() + 12));
		}
		output.write("\n}");
		output.close();
	}
}