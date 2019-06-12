package io.jerney.csv.validation.strategy;
import java.util.Map;

public interface CSVRowValidationRule {
    public boolean validateRow(Map<Integer, String> row);
}
