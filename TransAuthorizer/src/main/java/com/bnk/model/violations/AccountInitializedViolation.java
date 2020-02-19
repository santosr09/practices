package com.bnk.model.violations;

public class AccountInitializedViolation extends Violation {
	
	private static final long serialVersionUID = 503035959679803396L;

	private static AccountInitializedViolation violation;
	
	final static String VIOLATION_DETAIL = "account-already-initialized";
	
	public static String getViolationDetail() {
		return VIOLATION_DETAIL;
	}
	
	private AccountInitializedViolation() {}
	
	public static AccountInitializedViolation createAccountInitializedViolation() {
		if(violation == null) {
			violation = new AccountInitializedViolation();
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
