package ifma.lpweb.lab06.services;

import ifma.lpweb.lab06.dtos.request.CampeonatoRequest;
import ifma.lpweb.lab06.dtos.response.CampeonatoResponse;
import ifma.lpweb.lab06.mapper.CampeonatoMapper;
import ifma.lpweb.lab06.models.Campeonato;
import ifma.lpweb.lab06.repositories.CampeonatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class CampeonatoService {
    private final CampeonatoRepository campeonatoRepository;
    private final CampeonatoMapper campeonatoMapper;

    @Autowired
    public CampeonatoService(CampeonatoRepository campeonatoRepository, CampeonatoMapper campeonatoMapper){
        this.campeonatoRepository = campeonatoRepository;
        this.campeonatoMapper = campeonatoMapper;
    }

    @Transactional
    public Campeonato cadastrar(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public Optional<CampeonatoResponse> buscarPorId(Long id) {
        Optional<Campeonato> campeonatoOptional = campeonatoRepository.findById(id);
        return campeonatoOptional.map(campeonatoMapper::toCampeonatoResponse);
    }

    public CampeonatoResponse atualizar(CampeonatoRequest campeonatoRequest) {
        Campeonato campeonato = campeonatoMapper.toCampeonato(campeonatoRequest);
        Campeonato campeonatoAtualizado = campeonatoRepository.save(campeonato);
        return campeonatoMapper.toCampeonatoResponse(campeonatoAtualizado);
    }


    @Transactional
    public void deletar(Long id) {
        campeonatoRepository.deleteById(id);
    }

    public Iterable<Campeonato> listar() {
        return campeonatoRepository.findAll();
    }




    public boolean naoExisteCampeonatoCom(Long id) {
        return !campeonatoRepository.existsById(id);
    }
}

