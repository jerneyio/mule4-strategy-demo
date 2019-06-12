package io.jerney.csv.validation;
import java.util.List;
import java.util.Map;

import io.jerney.csv.validation.strategy.CSVRowValidationRule;

public class CSVValidator {
	private CSVRowValidationRule rule;
  
	public CSVValidator(CSVRowValidationRule rule) {
		this.rule = rule;
	}

	public boolean validate(List<Map<Integer, String>> csv) {
		for (Map<Integer, String> row : csv) {
			if (! rule.validateRow(row)) {
				return false;
			}
		}
    
		return true;
	}
}