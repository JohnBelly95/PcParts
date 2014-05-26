import java.io.*;
import java.util.*;

public class TextWriter{
	//Variables
	private List<Stock> stockList;
	private List<Order> orderList;
	private List<Sell> soldList;
	static BufferedReader input;
	static BufferedWriter output;
	
	public void StockTextWriter(List<Stock> stockList){
		this.stockList = stockList;
		try {
			output = new BufferedWriter(new FileWriter("STOCK_LIST.txt"));
			output.write("STOCK_LIST\n{");
			for(int i=0; i<stockList.size(); i++){
				output.write("\n\tITEM\n\t{" + stockList.get(i)+ "\n\t}");
			}
			output.write("\n}");
		}
		catch(IOException ex) {
			System.err.println("An IOException was caught!");
            ex.printStackTrace();
        }
		try{
			output.close();
		}
		catch(IOException e) {
			System.err.println("There was an error closing the file.");
		}
	}
	
	public void OrderTextWriter(List<Order> orderList){
		this.orderList = orderList;
		try {
			output = new BufferedWriter(new FileWriter("ORDER_LIST.txt"));
			output.write("ORDER_LIST\n{");
			for(int i=0; i<orderList.size(); i++){
				output.write("\n\tORDER\n\t{" + orderList.get(i) + "\n\t}");
			}
			output.write("\n}");
		}
		catch(IOException ex) {
			System.err.println("An Error was caught!");
            ex.printStackTrace();
        }
		try{
			output.close();
		}
		catch(IOException e) {
			System.err.println("There was an error closing the file.");
		}
	}
	
	public void SoldTextWriter(List<Sell> soldList){
		this.soldList = soldList;
		try {
			output = new BufferedWriter(new FileWriter("SOLD_LIST.txt"));
			output.write("SOLD_LIST\n{");
			for(int i=0; i<soldList.size(); i++){
				output.write("\n\tSOLD\n\t{" + soldList.get(i) + "\n\t}");
			}
			output.write("\n}");
		}
		catch(IOException ex) {
			System.err.println("An IOException was caught!");
            ex.printStackTrace();
        }
		try{
			output.close();
		}
		catch(IOException e) {
			System.err.println("There was an error closing the file.");
		}
	}
}
