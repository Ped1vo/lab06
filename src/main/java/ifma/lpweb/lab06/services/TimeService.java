package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {
    private final TimeRepository timeRepository;
    @Autowired
    public TimeService(TimeRepository timeRepository){
        this.timeRepository = timeRepository;
    }
}
