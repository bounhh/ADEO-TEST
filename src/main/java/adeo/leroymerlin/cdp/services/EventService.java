package adeo.leroymerlin.cdp.services;

import adeo.leroymerlin.cdp.repositories.EventRepository;
import adeo.leroymerlin.cdp.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAllBy();
    }

    public void delete(Long id) {
        eventRepository.delete(id);
    }

    public List<Event> getFilteredEvents(String query) {
        List<Event> events = eventRepository.findAllBy();

        // Filter the events list in pure JAVA here
        return events.stream().filter(
                        event -> event.getBands().stream()
                                .anyMatch(band -> band.getMembers().stream().anyMatch(member -> member.getName().toLowerCase().contains(query.toLowerCase())))).collect(Collectors.toList());
    }
}
