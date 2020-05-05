package dachuk.snow.repository;

import dachuk.snow.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer>  {
    Transport findByRouteId(int id);
}
