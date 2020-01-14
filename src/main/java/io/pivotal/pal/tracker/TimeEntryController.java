package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {
    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }


    @RequestMapping("/time-entries")
    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.CREATED);


    }


    public ResponseEntity delete(long timeEntryId) {
        return new ResponseEntity<Object>(HttpStatus.CREATED);

    }


    public ResponseEntity<TimeEntry> read(long timeEntryId) {
         TimeEntry timeEntry =timeEntryRepository.find(timeEntryId);
        return new ResponseEntity<TimeEntry>(HttpStatus.OK);
    }


    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>(HttpStatus.CREATED);
    }


    public ResponseEntity update(long timeEntryId, TimeEntry expected) {
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }


}

