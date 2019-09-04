package app;

import java.util.ArrayList;
import java.util.HashMap;

public class Resturant {
	private long Id;
	private String name;
	private int power;
	private HashMap<String, Float> priceList;
	
	public Resturant(long Id, String name, int power) {
		this.Id=Id;
		this.name=name;
		this.power=power;
		this.priceList=new HashMap<String, Float> ();
	}
	
	public float getPrice(String item) {
		if(priceList.containsValue(item)) {
			return priceList.get(item);
		}
		else
			return -1;
	}
	
	public void setPrice(String item, float price) {
		if(priceList.containsValue(item)) {
			priceList.replace(item, price);
		}
		else
			priceList.put(item, price);
	}
	
	public float getTotalPrice(ArrayList<String> items) {
		float total=0;
		for(String item: items) {
			if(!priceList.containsValue(item))
				return -1;
			else {
				total+=priceList.get(item);
			}
		}
		return total;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public void setPower(int power) {
		this.power=power;
	}
	

	public long getId() {
		return Id;
	}
	

	public void setId(long id) {
		Id = id;
	}
	

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public HashMap<String, Float> getPriceList() {
		return priceList;
	}
	

	public void setPriceList(HashMap<String, Float> priceList) {
		this.priceList = priceList;
	}
}
