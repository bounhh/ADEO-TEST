package adeo.leroymerlin.cdp;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface EventRepository extends Repository<Event, Long> {

    void delete(Long eventId);

    List<Event> findAllBy();
}
