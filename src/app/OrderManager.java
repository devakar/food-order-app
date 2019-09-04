package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class OrderManager {
	HashMap<String, User> users;
	HashMap<Long, Resturant> resturants;
	
	ArrayList<User> userList;
	ArrayList<Resturant> resturantList;
	
	public OrderManager() {
		users=new HashMap<String, User>();
		resturants=new HashMap<Long, Resturant>();
		userList=new ArrayList<User>();
		resturantList=new ArrayList<Resturant>();
	}
	
	public void addUser(String Id, String name, String mail, String mob) {
		User u=new User(Id,name,mail,mob);
		users.put(Id, u);
		userList.add(u);
	}
	
	public void addResturant(Long Id, String name, int power) {
		Resturant r=new Resturant(Id,name,power);
		resturants.put(Id,r);
		resturantList.add(r);
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public HashMap<Long, Resturant> getResturants() {
		return resturants;
	}
	
	public boolean userExists(String Id) {
		if(users.containsKey(Id))
			return true;
		else
			return false;
	}
	
	public boolean resturantExists(long id) {
		if(resturants.containsKey(id))
			return true;
		else
			return false;
	}
	
	public void addOrder(String userId, String item, int quantity) {
		User u=getUsers().get(userId);
		u.placeOrder(item, quantity);
	}
	
	public void placeOrder(String userId) {
		User u=getUsers().get(userId);
		HashMap<String, Integer> orderDet = u.orderDetails();
		
		if(orderDet.isEmpty()) {
			System.out.println("No items in cart, please add items in cart\n");
			return;
		}
		
		float orderPrice=0;
		Resturant orderResturant = null;
		int powerLost=0;
		
		for(Resturant r: resturantList) {
			HashMap<String, Float> price=r.getPriceList();
			float currentPrice=0;
			boolean absent=false;
			for (Map.Entry<String, Integer> entry : orderDet.entrySet()) {
				String food=entry.getKey();
				int quantity=entry.getValue();
				
				if(price.containsKey(food)) {
					currentPrice+=(quantity*price.get(food));
					powerLost+=quantity;
				}
				else {
					absent=true;
					break;
				}
			}
			
			if(orderPrice==0 && !absent) {
				orderPrice=currentPrice;
				orderResturant=r;
			}
			else if(orderPrice!=0 && !absent && currentPrice<orderPrice) {
				orderPrice=currentPrice;
				orderResturant=r;
			}
		}
		
		if(orderResturant!=null) {
			orderResturant.setPower(orderResturant.getPower()-powerLost);
			u.pay(orderResturant.getName(), orderPrice);
			//System.out.println("orderResturant.getName() : "+orderResturant.getName()+" orderResturant.getPower() : "+orderResturant.getPower()+" orderPrice : "+orderPrice);
			System.out.println("User with userId : "+userId+" has successfully placed an order from resturant : "+orderResturant.getName());
			System.out.println("The cost of order is: "+orderPrice);
		}
	}

	public void history(String userId) {
		User u=getUsers().get(userId);
		ArrayList<OrderDetails> o=u.getHistory();
		System.out.println("The Order Details are :");
		for(OrderDetails od: o) {
			System.out.println("***********************************");
			System.out.println("The order is placed from resturant : "+od.getResturantName());
			System.out.println("The total cost of order is: "+od.getPrice());
			//System.out.println("od.getResturantName() : "+od.getResturantName()+" od.getPrice() : "+od.getPrice());
			//System.out.println(od.getItems().entrySet());
			System.out.println("The food items with their corresponding quantities are as follows:");
			for(Map.Entry<String, Integer> entry: (od.getItems()).entrySet()) {
				System.out.println("Food Item : "+entry.getKey()+", quantity : "+entry.getValue());
			}
			System.out.println("***********************************");
		}
	}


	public void getPowerOfResturant(long resturantId) {
		// TODO Auto-generated method stub
		Resturant r=resturants.get(resturantId);
		System.out.println("The Power of Resturant : "+resturantId+" is : "+r.getPower());
	}

	public void getPriceList(long resturantId) {
		// TODO Auto-generated method stub
		Resturant r=resturants.get(resturantId);
		System.out.println("The Price List of Resturant : "+resturantId+" is as follows: ");
		for(Map.Entry<String, Float> entry: r.getPriceList().entrySet()) {
			System.out.println("Food item : "+entry.getKey()+", Price : "+entry.getValue());
		}
	}
}
