package io.jerney.csv.validation.strategy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class CSVType1Validator implements CSVRowValidationRule {
    private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    
    @Override
    public boolean validateRow(Map<Integer, String> row) {
        String id           = row.get(0);
        String startDateStr = row.get(1);
        String endDateStr   = row.get(2);
        String amount       = row.get(3);
        
        if (id == null || id.trim() == "") { return false; }
        
        try {
        		df.setLenient(false);
          
        		Date startDate = df.parse(startDateStr);
        		Date endDate = df.parse(endDateStr);
          
        		if (endDate.before(startDate)) { return false; }
        } catch (ParseException e) {
        		return false;
        }
        
        if (Double.parseDouble(amount) < 0) { return false; }
        
        return true;
    }

}
