package com.briup.smart.bean;

public class OrderInfo {
	
	private UserOrder userOrder;
	
	private Customer customer;
	
	private Deliveryman deliveryman;

	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Deliveryman getDeliveryman() {
		return deliveryman;
	}

	public void setDeliveryman(Deliveryman deliveryman) {
		this.deliveryman = deliveryman;
	}

	@Override
	public String toString() {
		return "OrderInfo [userOrder=" + userOrder + ", customer=" + customer + ", deliveryman=" + deliveryman + "]";
	}
	
	
	

}
