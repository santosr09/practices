package com.bnk.model.violations;

public class AccountNotInitializedViolation extends Violation {
	
	private static final long serialVersionUID = -3077135209012512366L;

	private static AccountNotInitializedViolation violation;
	
	final static String VIOLATION_DETAIL = "account-not-initialized";
	
	public static String getViolationDetail() {
		return VIOLATION_DETAIL;
	}
	
	private AccountNotInitializedViolation(){}
	
	public static AccountNotInitializedViolation createAccountNotInitializedViolation() {
		if(violation == null) {
			violation = new AccountNotInitializedViolation();
			return violation;
		}else {
			return violation;
		}
	}
	
	@Override
	public String toString() {
		return VIOLATION_DETAIL;
	}

}
