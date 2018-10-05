package com.JordanAmeri100Internship.Beans;

import java.util.List;

public class Customer {
	private int CustomerID = -1;
	private String CustomerName;
	private int CustomerManagerID;
	private String State;
	private String Region;
	private String Industry;
	private int CustomerRevenue;
	private String CustomerClassification;
	private String BasisForCustomerClassification;
	

	
	
	

	public Customer(){
		
	}
	public Customer(int CustomerID, String CustomerName,int CustomerManagerID, String State, String Region, String Industry, int CustomerRevenue, String CustomerClassification, String BasisForCustomerClassification ){
		this.CustomerID = CustomerID;
		this.CustomerName = CustomerName;
		this.CustomerManagerID = CustomerManagerID;
		this.State = State;
		this.Region = Region;
		this.Industry= Industry;
		this.CustomerRevenue = CustomerRevenue;
		this.CustomerClassification = CustomerClassification;
		this.BasisForCustomerClassification = BasisForCustomerClassification;
	}
	public int getCustomerID(){
		return CustomerID;
	}
	public String getCustomerName(){
		return CustomerName;
	}
	public int getCustomerManagerID(){
		return CustomerManagerID;
	}
	public String getState(){
		return State;
	}
	public String getRegion(){
		return Region;
	}
	public String getIndustry(){
		return Industry;
	}
	public int getCustomerRevenue(){
		return CustomerRevenue;
	}
	public String getCustomerClassification(){
		return CustomerClassification;
	}
	public String getBasisForCustomerClassification(){
		return BasisForCustomerClassification;
	}
	public void setCustomerID(int cust_id){
		this.CustomerID = cust_id;
	}
	public void setCustomerName(String CustomerName){
		this.CustomerName = CustomerName;
	}
	public void setBasisForCustomerClassification(String BasisForCustomerClassification){
		this.BasisForCustomerClassification = BasisForCustomerClassification;
	}
	public void setCustomerManagerID(int CustomerManagerID){
		this.CustomerManagerID = CustomerManagerID;
	}
	public void setState(String State){
		this.State = State;
	}
	public void setRegion(String Region){
		this.Region = Region;
	}
	public void setIndustry(String Industry){
		this.Industry = Industry;
	}
	public void setCustomerRevenue(int CustomerRevenue){
		this.CustomerRevenue = CustomerRevenue;
	}
	public void setCustomerClassification(String CustomerClassification){
		this.CustomerClassification = CustomerClassification;
	}
	
	public void showCustomer () {
		System.out.println(CustomerID);
		System.out.println(CustomerName);
		System.out.println(CustomerManagerID);
		System.out.println(State);
		System.out.println(Region);
		System.out.println(Industry);
		System.out.println(CustomerRevenue);
		System.out.println(CustomerClassification);
		System.out.println(BasisForCustomerClassification);

	}

	public void setRevenue () {
		System.out.println(CustomerID);
		System.out.println(CustomerName);
		System.out.println(CustomerManagerID);
		System.out.println(State);
		System.out.println(Region);
		System.out.println(Industry);
		System.out.println(CustomerRevenue);
		System.out.println(CustomerClassification);
		System.out.println(BasisForCustomerClassification);

	}

	public void showRevenue () {
		System.out.println(CustomerID);
		System.out.println(CustomerName);
		System.out.println(CustomerManagerID);
		System.out.println(State);
		System.out.println(Region);
		System.out.println(Industry);
		System.out.println(CustomerRevenue);
		System.out.println(CustomerClassification);
		System.out.println(BasisForCustomerClassification);

	}
	
	public boolean exists (){
		
		return ((CustomerID != -1));
	}

}
