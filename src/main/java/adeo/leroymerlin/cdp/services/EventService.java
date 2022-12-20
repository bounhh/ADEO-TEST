package adeo.leroymerlin.cdp.services;

import adeo.leroymerlin.cdp.entities.Band;
import adeo.leroymerlin.cdp.entities.Member;
import adeo.leroymerlin.cdp.repositories.EventRepository;
import adeo.leroymerlin.cdp.entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    private String _query;

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
        _query = query;

        List<Event> events = eventRepository.findAllBy();

        return getFiltredEvents(events);
    }

    public void updateEvent(Long id, Event event){
        eventRepository.updateEvent(id, event.getComment());
    }

    /**
     * Filter Events by band
     * @param events
     * @return
     */
    private List<Event> getFiltredEvents(List<Event> events){
        List<Event> result = events.stream().map(event -> {
            event.setBands(
                    getFiltredBand(event)
            );
            return event;
        }).filter(event -> event.getBands().size() > 0).collect(Collectors.toList());

        // BONUS
        List<Event> _result = result.stream().map(event -> {

            String newTitle = event.getTitle().concat(" [".concat(String.valueOf(event.getBands().size())).concat("]"));

            List<Band> bonusBands = event.getBands().stream().map(band -> {
                // create new Ban object
                Band bonusBand = new Band();

                String newName = band.getName().concat(" [".concat(String.valueOf(band.getMembers().size())).concat("]"));

                bonusBand.setName(newName);
                bonusBand.setMembers(band.getMembers());
                return bonusBand;
            }).collect(Collectors.toList());

            event.setTitle(newTitle);
            event.setBands(new HashSet<>(bonusBands));
            return event;
        }).collect(Collectors.toList());

        return _result;
    }

    /**
     * Filter bands of Event
     * @param event
     * @return
     */
    private Set<Band> getFiltredBand(Event event){
        List<Band> result = event.getBands().stream().map(band -> {
                    Set<Member> filtredMember = getFiltredMember(band);
                    band.setMembers(getFiltredMember(band));
                    return band;
                }).filter(band -> band.getMembers().size() > 0).collect(Collectors.toList());

        return new HashSet<>(result);
    }

    /**
     * Filter Members of band by query
     * @param band
     * @return
     */
    private Set<Member> getFiltredMember(Band band){
        List<Member> result = band.getMembers().stream().filter(member -> member.getName().toLowerCase().contains(_query.toLowerCase())).collect(Collectors.toList());
        return new HashSet<>(result);
    }
}
