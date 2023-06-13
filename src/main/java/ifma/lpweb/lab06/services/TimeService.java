package ifma.lpweb.lab06.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {
    private final TimeService timeService;
    @Autowired
    public TimeService(TimeService timeService){
        this.timeService = timeService;
    }
}
