package dachuk.snow.service.impl;

import dachuk.snow.model.Transport;
import dachuk.snow.repository.TransportRepository;
import dachuk.snow.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransportServiceImpl implements TransportService {
    private final TransportRepository transportRepository;

    @Autowired
    public TransportServiceImpl(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @Override
    public Transport create(Transport transport) {
        return transportRepository.save(transport);
    }

    @Override
    public Transport update(Transport transport) {
        return transportRepository.save(transport);
    }

    @Override
    public Transport findById(int id) {
        return transportRepository.getOne(id);
    }

    @Override
    public ArrayList<Transport> findAll() {
        return (ArrayList<Transport>) transportRepository.findAll();
    }

    @Override
    public Transport findByRouteId(int id) {
        return transportRepository.findByRouteId(id);
    }
}
