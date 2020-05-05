package dachuk.snow.service;

import dachuk.snow.model.Route;

import java.util.ArrayList;

public interface RouteService {
    Route create(Route route);
    Route update(Route route);

    Route findById(int id);
    ArrayList<Route> findAll();

    Route findByDriverId(int id);
}
