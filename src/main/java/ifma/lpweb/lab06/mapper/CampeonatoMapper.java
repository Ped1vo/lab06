package ifma.lpweb.lab06.mapper;

import ifma.lpweb.lab06.dtos.request.CampeonatoRequest;
import ifma.lpweb.lab06.dtos.response.CampeonatoResponse;
import ifma.lpweb.lab06.models.Campeonato;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;



@AllArgsConstructor
@Component
public class CampeonatoMapper {
    private ModelMapper modelMapper;

    public Campeonato toEntity(CampeonatoRequest campeonatoRequest) {
        return modelMapper.map(campeonatoRequest, Campeonato.class);
    }

    public CampeonatoResponse toCampeonatoResponse(Campeonato campeonato) {
        return modelMapper.map(campeonato, CampeonatoResponse.class);
    }

    public Campeonato toCampeonato(CampeonatoRequest campeonatoRequest) {
        return modelMapper.map(campeonatoRequest, Campeonato.class);
    }


    public List<CampeonatoResponse> toCampeonatoResponseList(Iterable<Campeonato> campeonatos) {
        List<CampeonatoResponse> campeonatosResponse = new ArrayList<>();
        for (Campeonato campeonato : campeonatos) {
            CampeonatoResponse campeonatoResponse = toCampeonatoResponse(campeonato);
            campeonatosResponse.add(campeonatoResponse);
        }
        return campeonatosResponse;
    }

}
