package ifma.lpweb.lab06.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidaService {
    private final PartidaService partidaService;
    @Autowired
    public PartidaService(PartidaService partidaService){
        this.partidaService = partidaService;
    }
}
