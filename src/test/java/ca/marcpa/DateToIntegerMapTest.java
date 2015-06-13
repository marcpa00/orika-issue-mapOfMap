package ca.marcpa;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateToIntegerMapTest {

    MapperFactory mapperFactory;

    @Before public void setUp() throws Exception {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(DateToIntegerMap.class, DateToIntegerMap.class).byDefault().register();
    }

    @Test public void testClone() {
        DateToIntegerMap original = new DateToIntegerMap();
        Date now = new Date();
        Integer value = 5;
        Map<Date, Integer> oneEntryMap = new HashMap<Date, Integer>();
        oneEntryMap.put(now, value);
        original.setDateIntegerMap(oneEntryMap);

        DateToIntegerMap copy = mapperFactory.getMapperFacade().map(original, DateToIntegerMap.class);

        assert copy != null;
        assert copy.getDateIntegerMap() != null;
        assert original.getDateIntegerMap().isEmpty() == copy.getDateIntegerMap().isEmpty();
        for (Map.Entry<Date, Integer> originalEntries : original.getDateIntegerMap().entrySet()) {
            assert copy.getDateIntegerMap().containsKey(originalEntries.getKey());
            assert copy.getDateIntegerMap().get(originalEntries.getKey()).equals(originalEntries.getValue());
        }
    }
}
