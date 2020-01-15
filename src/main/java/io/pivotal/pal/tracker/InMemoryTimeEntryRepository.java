package io.pivotal.pal.tracker;

import java.lang.reflect.Array;
import java.util.*;

public class InMemoryTimeEntryRepository  implements  TimeEntryRepository{


    private final Map<Long, TimeEntry> timeEntryMap  = new HashMap<Long, TimeEntry>();
    private long lid;

    @Override
    public TimeEntry find(Long id) {
        return timeEntryMap.get(id);
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        lid = ++lid;

        TimeEntry timeEntryCreated = new TimeEntry(
                lid,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        timeEntryMap.put(lid,timeEntryCreated);
        return timeEntryCreated;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

        if (timeEntryMap.containsKey(id)) {
            TimeEntry timeEntryUpdated = new TimeEntry(
                    id,
                    timeEntry.getProjectId(),
                    timeEntry.getUserId(),
                    timeEntry.getDate(),
                    timeEntry.getHours()
            );

            timeEntryMap.put(id, timeEntryUpdated);

            return timeEntryUpdated;
        } else {
            return null;
        }
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
