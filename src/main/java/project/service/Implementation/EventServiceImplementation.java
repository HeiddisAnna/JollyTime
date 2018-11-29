package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Service;

import project.model.Event;
import project.model.JollyUser;
import project.persistence.repositories.EventRepository;
import project.service.EventService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.TemporalType;

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
    	Calendar from = Calendar.getInstance();
		from.set(Calendar.YEAR, year);
		from.set(Calendar.MONTH, month);
		from.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar to = Calendar.getInstance();
		to.set(Calendar.DAY_OF_MONTH, to.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		List<Event> all = repository.findAll();
		ArrayList<Event> result = new ArrayList<Event>();
		
		for (int i = 0; i < all.size(); i++) {
			Event event = all.get(i);
			long fromMillis = from.getTimeInMillis();
			long toMillis = to.getTimeInMillis();
			if (event.getStartDate().getTimeInMillis() >= fromMillis && event.getEndDate().getTimeInMillis() <= toMillis ) {
				result.add(event);
			}
		}
		return result;
	} 
}
