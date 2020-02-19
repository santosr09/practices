package com.bnk.model;

import java.util.List;

import com.bnk.model.violations.Violation;

public class Transaction implements Operation{
	private String merchant;
	private double amount;
	private String time;
	private List<Violation> violations;

	public List<Violation> getViolations() {
		return violations;
	}
	
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	private Transaction() {
		
	}
	
	public static Transaction createTransaction(String merchant, double amount, String time) {
		Transaction transaction = new Transaction();
		transaction.merchant = merchant;
		transaction.amount = amount;
		transaction.time = time;
		return transaction;
		
	}
	
	@Override
	public void setViolations(List<Violation> violations) {
		this.violations = violations;
		
	}

	@Override
	public String toString() {
		return "Transaction [merchant=" + merchant + ", amount=" + amount + ", time=" + time + ", violations="
				+ violations + "]";
	}
	

}
