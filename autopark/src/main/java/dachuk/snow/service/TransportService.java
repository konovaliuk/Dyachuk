package dachuk.snow.service;

import dachuk.snow.model.Transport;

import java.util.ArrayList;

public interface TransportService {
    Transport create(Transport transport);
    Transport update(Transport transport);

    Transport findById(int id);
    ArrayList<Transport> findAll();

    Transport findByRouteId(int id);
}
