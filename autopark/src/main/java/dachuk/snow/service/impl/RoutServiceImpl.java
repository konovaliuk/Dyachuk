package dachuk.snow.service.impl;

import dachuk.snow.model.Route;
import dachuk.snow.repository.RouteRepository;
import dachuk.snow.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoutServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RoutServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route create(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route update(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route findById(int id) {
        return routeRepository.getOne(id);
    }

    @Override
    public ArrayList<Route> findAll() {
        return (ArrayList<Route>) routeRepository.findAll();
    }

    @Override
    public Route findByDriverId(int id) {
        return routeRepository.findByDriverId(id);
    }
}
