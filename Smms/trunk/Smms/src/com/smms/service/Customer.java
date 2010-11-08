package com.smms.service;



public class Customer {//implements Comparable<Customer> {
  private int    id;
  private String name;
    public Customer() {
    super();
  }

  public Customer(int id, String name){
	  this.id= id;
	  this.name=name;
  }
  

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
  public String toString(){
	  return "id ="+id+" ,name="+name;
	  
  }

  }
