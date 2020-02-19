package com.bnk.model.violations;

public class InsufficientLimitViolation extends Violation {
	
	private static final long serialVersionUID = 1838658403057843916L;

	private static InsufficientLimitViolation violation;
	
	final static String VIOLATION_DETAIL = "insufficient-limit";
	
	public static String getViolationDetail() {
		return VIOLATION_DETAIL;
	}
	
	private InsufficientLimitViolation() {}
	
	public static InsufficientLimitViolation createInsufficientLimitViolation() {
		if(violation == null) violation = new InsufficientLimitViolation();
		return violation;
	}
	
	@Override
	public String toString() {
		return VIOLATION_DETAIL;
	}

}
