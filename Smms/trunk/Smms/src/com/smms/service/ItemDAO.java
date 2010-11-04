package com.smms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemDAO {
	private static List<Item>items = new ArrayList<Item>();
	static{
		items.add(new Item(1,"AA1019999991",new Date(),"ดลยา",1,"XXXXXX","xxxxxx",99999.99,10,100,88888.88,17.0,false,true,false,"99955"));
		items.add(new Item(2,"AB1019999992",new Date(),"XXX",2,"XXXXXX","xxxxxx",99999.99,10,100,88888.88,17.0,false,false,true,"99956"));
		items.add(new Item(3,"AC1019999993",new Date(),"XXX",3,"XXXXXX","xxxxxx",99999.99,10,100,88888.88,17.0,false,false,true,"99957"));
		items.add(new Item(4,"AD1019999994",new Date(),"XXX",4,"XXXXXX","xxxxxx",99999.99,10,100,88888.88,17.0,false,false,true,"99958"));
		items.add(new Item(5,"AD1019999995",new Date(),"XXX",5,"XXXXXX","xxxxxx",99999.99,10,100,88888.88,17.0,false,false,true,"99959"));
	
	}
	public static List<Item> getItems(){
		return items;
	}

}
