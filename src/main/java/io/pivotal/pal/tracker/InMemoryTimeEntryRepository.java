package io.pivotal.pal.tracker;

import java.lang.reflect.Array;
import java.util.*;

public class InMemoryTimeEntryRepository  implements  TimeEntryRepository{


    Map<Long, TimeEntry> timeEntryMap  = new HashMap<Long, TimeEntry>();
     long lid;

    @Override
    public TimeEntry find(Long id) {
        return timeEntryMap.get(id);
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
      //  timeEntryMap.clear();
        lid = ++lid;
        timeEntry.setId(lid);

        timeEntryMap.put(lid,timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

        if(timeEntryMap.containsKey(id)){
            timeEntry.setId(id);
            timeEntryMap.put(id, timeEntry);
            return timeEntry;}
        return null;
    }

    @Override
    public void delete(long id) {
        timeEntryMap.remove(id);

    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntryMap.values());
    }
}
