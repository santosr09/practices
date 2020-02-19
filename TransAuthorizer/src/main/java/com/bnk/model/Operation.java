package com.bnk.model;

import java.util.List;

import com.bnk.model.violations.Violation;

public interface Operation {
	
	void setViolations(List<Violation> violations);

}
