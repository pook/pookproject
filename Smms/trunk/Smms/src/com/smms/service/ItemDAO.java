package com.smms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemDAO {
	private static List<Item>items = new ArrayList<Item>();
	static{
		items.add(new Item(1,new Date(),1,"xxxx","xxxxxx",99999.99,10,100));
		items.add(new Item(2,new Date(),2,"xxxx","xxxxxx",99999.99,10,100));
		items.add(new Item(3,new Date(),3,"xxxx","xxxxxx",99999.99,10,100));
		items.add(new Item(4,new Date(),4,"xxxx","xxxxxx",99999.99,10,100));
		items.add(new Item(5,new Date(),5,"xxxx","xxxxxx",99999.99,10,100));
	}
	public static List<Item> getItems(){
		return items;
	}

}
