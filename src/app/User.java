package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class User {
	private String Id;
	private String name;
	private String mail;
	private String contact;
	private HashMap<String, Integer> orderedItems;
	private ArrayList<OrderDetails> history;
	
	public User(String Id, String name, String mail, String contact) {
		this.Id=Id;
		this.name=name;
		this.mail=mail;
		this.contact=contact;
		this.orderedItems=new HashMap<String, Integer>();
		this.history=new ArrayList<OrderDetails>();
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public void placeOrder(String foodName, int quantity){
		orderedItems.put(foodName, quantity);
	}
	
	public HashMap<String, Integer> orderDetails(){
		return this.orderedItems;
	}

	
	public void pay(String resturantName, float orderPrice) {
		HashMap<String, Integer> copyItems=new HashMap<String, Integer>();
		for(Map.Entry<String, Integer> entry: orderedItems.entrySet()) {
			copyItems.put(entry.getKey(), entry.getValue());
		}
		OrderDetails od=new OrderDetails(resturantName, orderPrice, copyItems);
		this.history.add(od);
		this.orderedItems.clear();
	}

	public ArrayList<OrderDetails> getHistory() {
		return history;
	}

}
