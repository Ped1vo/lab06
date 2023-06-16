package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.repositories.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultadoService {
    private final ResultadoRepository resultadoRepository;

    @Autowired
    public ResultadoService(ResultadoRepository resultadoRepository){
        this.resultadoRepository = resultadoRepository;
    }
}
