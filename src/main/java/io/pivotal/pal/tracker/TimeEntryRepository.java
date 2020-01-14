package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface TimeEntryRepository {



    TimeEntry find(Long id);

    TimeEntry create(TimeEntry timeEntry);

    TimeEntry update(long id, TimeEntry timeEntry);

    void delete(long id);

    List<TimeEntry> list();
}
