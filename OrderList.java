
import java.util.*;

public class OrderList{
	private List<Order> orderList = new ArrayList<Order>();
	
	public void showOrders(){
		for (int i=0; i < orderList.size(); i++){
			System.out.println(orderList.get(i));
		}
	}	
}
