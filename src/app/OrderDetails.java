package app;

import java.util.HashMap;

public class OrderDetails {
	private String resturantName;
	private Float price;
	private HashMap<String, Integer> items;
	
	public OrderDetails(String resturantName, Float price, HashMap<String, Integer> items) {
		this.resturantName=resturantName;
		this.price=price;
		this.items=items;
	}
	
	public String getResturantName() {
		return resturantName;
	}
	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public HashMap<String, Integer> getItems() {
		return items;
	}
	public void setItems(HashMap<String, Integer> items) {
		this.items = items;
	}
}
