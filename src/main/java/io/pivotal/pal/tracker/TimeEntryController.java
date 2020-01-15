package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(timeEntryRepository.create(timeEntryToCreate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        timeEntryRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);

        if (timeEntry ==null)
        {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(timeEntry);



    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return ResponseEntity.ok(
                timeEntryRepository.list()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity update(long id, @RequestBody TimeEntry expected) {
        TimeEntry timeEntry =  timeEntryRepository.update(id, expected);

        if (timeEntry ==null)
        {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(timeEntry);
    }


}

