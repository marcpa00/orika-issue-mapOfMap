package ca.marcpa;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateToIntegerToStringMap {

    public Map<Date, Map<Integer, String>> getDateIntegerStringMap() {
        return dateIntegerStringMap;
    }

    public void setDateIntegerStringMap(Map<Date, Map<Integer, String>> dateIntegerStringMap) {
        this.dateIntegerStringMap = dateIntegerStringMap;
    }

    private Map<Date, Map<Integer, String>> dateIntegerStringMap;
}
