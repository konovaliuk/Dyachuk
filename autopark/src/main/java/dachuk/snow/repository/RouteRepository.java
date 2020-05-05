package dachuk.snow.repository;

import dachuk.snow.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
    Route findByDriverId(int id);
}
