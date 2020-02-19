package com.bnk.model;

import java.util.ArrayList;
import java.util.List;

import com.bnk.model.violations.Violation;

public class Account implements Operation{
	private boolean active;
	private double availableLimit;
	private List<Violation> violations = new ArrayList<Violation>();

	public List<Violation> getViolations() {
		return violations;
	}
	public void setViolations(List<Violation> violations) {
		this.violations = violations;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public double getAvailableLimit() {
		return availableLimit;
	}
	public void setAvailableLimit(double availableLimit) {
		this.availableLimit = availableLimit;
	}
	
	private Account() {
		
	}
	
	public static Account createAccount(boolean status, double limit) {
		Account account = new Account();
		account.active = status;
		account.availableLimit = limit;
		return account;
	}
	
	public static Account createAccount(String status, String limit) {
		Account account = new Account();
		account.active = Boolean.parseBoolean(status);
		account.availableLimit = Double.parseDouble(limit);
		return account;
	}
	
	@Override
	public String toString() {
		return "Account [active=" + active + ", availableLimit=" + availableLimit + ", violations=" + violations + "]";
	}
	
}
