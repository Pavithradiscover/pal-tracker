package io.pivotal.pal.tracker;



import java.util.List;


public interface TimeEntryRepository {



    TimeEntry find(Long id);

    TimeEntry create(TimeEntry timeEntry);

    TimeEntry update(long id, TimeEntry timeEntry);

    void delete(long id);

    List<TimeEntry> list();
}
