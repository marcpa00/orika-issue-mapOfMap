package ca.marcpa;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateToIntegerToStringMapTest {

    MapperFactory mapperFactory;

    @Before public void setUp() throws Exception {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(DateToIntegerToStringMap.class, DateToIntegerToStringMap.class).byDefault().register();
    }

    @Test public void testClone() {
        DateToIntegerToStringMap original = new DateToIntegerToStringMap();
        Date now = new Date();
        Integer value = 5;
        String text = "five";
        Map<Integer, String> integerStringMap = new HashMap<Integer, String>();
        integerStringMap.put(value, text);
        Map<Date, Map<Integer, String>> dateMapMap = new HashMap<Date, Map<Integer, String>>();
        dateMapMap.put(now, integerStringMap);
        original.setDateIntegerStringMap(dateMapMap);

        DateToIntegerToStringMap copy = mapperFactory.getMapperFacade().map(original, DateToIntegerToStringMap.class);

        assert copy != null;
        assert copy.getDateIntegerStringMap() != null;
        assert original.getDateIntegerStringMap().isEmpty() == copy.getDateIntegerStringMap().isEmpty();
        for (Map.Entry<Date, Map<Integer, String>> originalEntries : original.getDateIntegerStringMap().entrySet()) {
            Date dateInOriginal = originalEntries.getKey();
            assert copy.getDateIntegerStringMap().containsKey(dateInOriginal);
            for (Map.Entry<Integer, String> originalEntriesByDate : originalEntries.getValue().entrySet()) {
                Integer integerInOriginal = originalEntriesByDate.getKey();
                assert copy.getDateIntegerStringMap().get(dateInOriginal).get(integerInOriginal) != null;
                assert copy.getDateIntegerStringMap().get(dateInOriginal).get(integerInOriginal).equals(originalEntriesByDate.getValue());
            }
        }
    }
}
