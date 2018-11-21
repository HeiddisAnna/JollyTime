package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.Calendar;
import project.model.JollyUser;
import project.persistence.repositories.CalendarRepository;
import project.persistence.repositories.EventRepository;
import project.service.CalendarService;
import project.service.EventService;

import java.util.Collections;
import java.util.List;

@Service
public class CalendarServiceImplementation implements CalendarService {

    // Instance Variables
    CalendarRepository repository;

    // Dependency Injection
    @Autowired
    public CalendarServiceImplementation(CalendarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Calendar save(Calendar calendar) {
        return repository.save(calendar);
    }

    @Override
    public void delete(Calendar calendar) {
        repository.delete(calendar);
    }

    @Override
    public List<Calendar> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Calendar> findAllReverseOrder() {
        List<Calendar> calendars = repository.findAll();

        // Reverse the list
        Collections.reverse(calendars);

        return calendars;
    }

    @Override
    public Calendar findOne(Long id) {
        return repository.findOne(id);
    }

}
