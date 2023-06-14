package ifma.lpweb.lab06.mapper;

import ifma.lpweb.lab06.dtos.output.JogadorResponse;
import ifma.lpweb.lab06.models.Jogador;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class JogadorMapper {
    private ModelMapper modelMapper;

    public JogadorResponse toJogadorResponse(Jogador jogador) {
        return modelMapper.map(jogador, JogadorResponse.class);
    }
}
