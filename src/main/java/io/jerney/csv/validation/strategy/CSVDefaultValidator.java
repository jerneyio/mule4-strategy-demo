package io.jerney.csv.validation.strategy;

import java.util.Map;

public class CSVDefaultValidator implements CSVRowValidationRule {

	@Override
	public boolean validateRow(Map<Integer, String> row) {
		return row.size() == 5;
	}

}
