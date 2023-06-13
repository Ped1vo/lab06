package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.repositories.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadioService {
    private final EstadioRepository estadioRepository;

    @Autowired
    public EstadioService(EstadioRepository estadioRepository){
        this.estadioRepository = estadioRepository;
    }
}
