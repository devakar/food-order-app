package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.OrderDetails;
import app.OrderManager;
import app.Resturant;
import app.User;


public class Order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Resturant r1=new Resturant(1, "R1", 10);
		r1.setPrice("roti", 5);
		r1.setPrice("rice", 10);
		r1.setPrice("daal", 10);
		r1.setPrice("vegetable", 20);
		
		Resturant r2=new Resturant(2, "R2", 10);
		r2.setPrice("roti", 5);
		r2.setPrice("rice", 10);
		r2.setPrice("daal", 10);
		r2.setPrice("vegetable", 10);
	
		
		User u1=new User("1", "dev", "a@gmail.com", "12345");
		
		u1.placeOrder("roti", 4);
		u1.placeOrder("vegetable", 1);
		
		*/
		
		OrderManager manager=new OrderManager();
		//int userId=1;
		//1long ResturantId= 1;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.print("Choose an operation (Enter number) : \n"
						+ "1. Add User\n"
						+ "2. Add Resturant\n"
						+ "3. Add Item with Price for a resturant\n"
						+ "4. Add Order to cart\n"
						+ "5. Place Order from cart\n"
						+ "6. History of order for user\n"
						+ "7. Power of a resturant\n"
						+ "8. Price List of Items for a Resturant\n"
						+ "9. Exit\n");
				System.out.println();
				
				int op = Integer.parseInt(br.readLine());
				
				switch (op) {
				case 1: {
					System.out.print("Enter User Id :");
					String userId =  br.readLine();
					
					while(manager.userExists(userId)) {
						System.out.println("user id exists, please enter different userID");
						userId =  br.readLine();
					}
					
					System.out.print("Enter User Name :");
					String name =  br.readLine();
				
					System.out.print("Enter User mail :");
					String mail =  br.readLine();
					
					System.out.print("Enter User contact :");
					String mob =  br.readLine();
					
					manager.addUser(userId, name, mail, mob);
					break;
				}
				case 2:{
					System.out.print("Enter Resturant Id :");
					long resturantId =  Long.parseLong(br.readLine());
					
					while(manager.resturantExists(resturantId)) {
						System.out.println("resturant id exists, please enter different resturantId");
						resturantId =  Long.parseLong(br.readLine());
					}
					
					System.out.print("Enter Resturant Name :");
					String name =  br.readLine();
				
					System.out.print("Enter Resturant capacity :");
					int power =  Integer.parseInt(br.readLine());
					
					manager.addResturant(resturantId, name, power);
					
					break;
				}
				case 3:{
					System.out.print("Enter Resturant Id :");
					long resturantId =  Long.parseLong(br.readLine());
					
					while(!manager.resturantExists(resturantId)) {
						System.out.println("resturantId id doesn't exists, please enter correct resturantId");
						resturantId =  Long.parseLong(br.readLine());
					}
					System.out.print("Enter Food(item) Name :");
					String item =  br.readLine();
					System.out.print("Enter Price of the provided Food(item) :");
					float price =  Float.parseFloat(br.readLine());
					
					Resturant r=manager.getResturants().get(resturantId);
					r.setPrice(item, price);
					break;
				}
				case 4:{
					System.out.print("Enter User Id :");
					String userId =  br.readLine();
					
					while(!manager.userExists(userId)) {
						System.out.println("user id doesn't exists, please enter correct userID");
						userId =  br.readLine();
					}
					System.out.print("Enter Food(item) Name :");
					String item =  br.readLine();
					System.out.print("Enter Quantity of the provided Food(item) :");
					int quantity =  Integer.parseInt(br.readLine());
					
					manager.addOrder(userId, item, quantity);
					
					break;
				}
				case 5:{
					System.out.print("Enter User Id :");
					String userId =  br.readLine();
					
					while(!manager.userExists(userId)) {
						System.out.println("user id doesn't exists, please enter correct userID");
						userId =  br.readLine();
					}
					
					manager.placeOrder(userId);
					break;
				}
				case 6:{
					System.out.print("Enter User Id :");
					String userId =  br.readLine();
					
					while(!manager.userExists(userId)) {
						System.out.println("user id doesn't exists, please enter correct userID");
						userId =  br.readLine();
					}
					manager.history(userId);
					break;
				}
				case 7:{
					System.out.print("Enter Resturant Id :");
					long resturantId =  Long.parseLong(br.readLine());
					
					while(!manager.resturantExists(resturantId)) {
						System.out.println("resturant id exists, please enter different resturantId");
						resturantId =  Long.parseLong(br.readLine());
					}
					
					manager.getPowerOfResturant(resturantId);
					break;
				}
				case 8:{
					System.out.print("Enter Resturant Id :");
					long resturantId =  Long.parseLong(br.readLine());
					
					while(!manager.resturantExists(resturantId)) {
						System.out.println("resturant id exists, please enter different resturantId");
						resturantId =  Long.parseLong(br.readLine());
					}
					manager.getPriceList(resturantId);
					break;
				}
				case 9: {
					System.exit(0);
				}
				
			}
			}
		}catch (IOException e) {
			System.out.println("Exception : " + e);
		}
		
	}

}
