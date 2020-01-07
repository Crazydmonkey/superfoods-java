package com.briup.smart.bean;

public class OrderData {
	//新增订单数量
	private int added;
	//催单数量
	private int reminder;
	//申请退单数量
	private int chargeback;
	public int getAdded() {
		return added;
	}
	public void setAdded(int added) {
		this.added = added;
	}
	public int getReminder() {
		return reminder;
	}
	public void setReminder(int reminder) {
		this.reminder = reminder;
	}
	public int getChargeback() {
		return chargeback;
	}
	public void setChargeback(int chargeback) {
		this.chargeback = chargeback;
	}
	@Override
	public String toString() {
		return "OrderData [added=" + added + ", reminder=" + reminder + ", chargeback=" + chargeback + "]";
	}
	
	

}
