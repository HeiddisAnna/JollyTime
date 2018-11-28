package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.Event;
import project.model.JollyUser;
import project.persistence.repositories.EventRepository;
import project.service.EventService;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Service
public class EventServiceImplementation implements EventService {

    // Instance Variables
    EventRepository repository;

    // Dependency Injection
    @Autowired
    public EventServiceImplementation(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public Event save(Event event) {
        return repository.save(event);
    }

    @Override
    public void delete(Event event) {
        repository.delete(event);
    }

    @Override
    public List<Event> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Event> findAllReverseOrder() {
        // Get all the Postit notes
        List<Event> events = repository.findAll();

        // Reverse the list
        Collections.reverse(events);

        return events;
    }

    @Override
    public Event findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Event> getAllEventsInMonth(int year, int month) {
    	Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		Timestamp from = new Timestamp(calendar.getTimeInMillis());
		
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		Timestamp to = new Timestamp(calendar.getTimeInMillis());
		
		return repository.findAllInRange(from, to);
	} 
}
