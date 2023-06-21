package ifma.lpweb.lab06.controllers;

import ifma.lpweb.lab06.dtos.request.CampeonatoRequest;
import ifma.lpweb.lab06.dtos.response.CampeonatoResponse;
import ifma.lpweb.lab06.mapper.CampeonatoMapper;
import ifma.lpweb.lab06.models.Campeonato;
import ifma.lpweb.lab06.services.CampeonatoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    private final CampeonatoService campeonatoService;
    private final CampeonatoMapper campeonatoMapper;

    @PostMapping
    public ResponseEntity<CampeonatoResponse> cadastrar(@Valid @RequestBody CampeonatoRequest campeonatoRequest,
                                                        UriComponentsBuilder builder) {
        Campeonato campeonato = campeonatoMapper.toCampeonato(campeonatoRequest);
        Campeonato campeonatoSalvo = campeonatoService.cadastrar(campeonato);
        CampeonatoResponse campeonatoResponse = campeonatoMapper.toCampeonatoResponse(campeonatoSalvo);

        final URI uri = builder.path("/campeonatos/{id}").buildAndExpand(campeonatoResponse.getIdCampeonato()).toUri();
        return ResponseEntity.created(uri).body(campeonatoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampeonatoResponse> buscarPorId(@PathVariable Long id) {
        Optional<CampeonatoResponse> campeonatoOptional = campeonatoService.buscarPorId(id);
        if (campeonatoOptional.isPresent()) {
            CampeonatoResponse campeonatoResponse = campeonatoOptional.get();
            return ResponseEntity.ok(campeonatoResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<CampeonatoResponse> atualizar(@PathVariable Long id,
                                                        @Valid @RequestBody CampeonatoRequest campeonatoRequest) {
        if (campeonatoService.naoExisteCampeonatoCom(id)) {
            return ResponseEntity.notFound().build();
        } else {
            CampeonatoResponse campeonatoResponse = campeonatoService.atualizar(campeonatoRequest);
            return ResponseEntity.ok(campeonatoResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<CampeonatoResponse> campeonatoOptional = campeonatoService.buscarPorId(id);
        if (campeonatoOptional.isPresent()) {
            campeonatoService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CampeonatoResponse>> listarCampeonatos() {
        Iterable<Campeonato> campeonatos = campeonatoService.listar();
        List<CampeonatoResponse> campeonatosResponse = campeonatoMapper.toCampeonatoResponseList(campeonatos);
        return ResponseEntity.ok(campeonatosResponse);
    }


}
