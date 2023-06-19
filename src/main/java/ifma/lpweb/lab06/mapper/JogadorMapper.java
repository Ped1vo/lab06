package ifma.lpweb.lab06.mapper;

import ifma.lpweb.lab06.dtos.request.JogadorRequest;
import ifma.lpweb.lab06.dtos.response.JogadorResponse;
import ifma.lpweb.lab06.models.Jogador;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class JogadorMapper {
    private ModelMapper modelMapper;

    public static Jogador toEntity(JogadorRequest jogadorRequest) {
        Jogador jogador = new Jogador();
        jogador.setNome(jogadorRequest.getNome());
        jogador.setDataNascimento(jogadorRequest.getDataNascimento());
        jogador.setGenero(jogadorRequest.getGenero());
        jogador.setAltura(jogadorRequest.getAltura());

        return jogador;
    }

    public JogadorResponse toJogadorResponse(Jogador jogador) {
        return modelMapper.map(jogador, JogadorResponse.class);
    }

    public Jogador toJogador(JogadorRequest jogadorRequest) {
        return modelMapper.map(jogadorRequest, Jogador.class);
    }

    public List<JogadorResponse> toResponseList(Iterable<Jogador> jogadores) {
        List<JogadorResponse> jogadoresResponse = new ArrayList<>();
        for (Jogador jogador : jogadores) {
            JogadorResponse jogadorResponse = toJogadorResponse(jogador);
            jogadoresResponse.add(jogadorResponse);
        }
        return jogadoresResponse;
    }


    public Page<JogadorResponse> toResponsePage(Page<Jogador> jogadoresPage) {
        List<JogadorResponse> jogadoresResponse = jogadoresPage.stream()
                .map(this::toJogadorResponse)
                .collect(Collectors.toList());

        return new PageImpl<>(jogadoresResponse, jogadoresPage.getPageable(), jogadoresPage.getTotalElements());
    }

}
