package adeo.leroymerlin.cdp.repositories;

import adeo.leroymerlin.cdp.entities.Event;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EventRepository extends Repository<Event, Long> {

    @Modifying
    @Query("delete from Event e where e.id=:eventId")
    void delete(@Param("eventId") Long eventId);

    List<Event> findAllBy();

    @Modifying
    @Query("update Event e set e.comment=:comment where e.id=:eventId")
    void updateEvent(@Param("eventId") Long id, @Param("comment") String comment);
}
