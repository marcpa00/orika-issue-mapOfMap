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
    }
}
