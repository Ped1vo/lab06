package ifma.lpweb.lab06.controllers;

import ifma.lpweb.lab06.models.Partida;
import ifma.lpweb.lab06.services.PartidaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/partidas")
public class PartidaController {
    private final PartidaService partidaService;

    @PostMapping
    public ResponseEntity<Partida> cadastrar(@Valid @RequestBody Partida partida,
                                             UriComponentsBuilder builder) {
        final Object partidaSalvo = partidaService.cadastrar(partida);
        final URI uri = builder.path("/jogadores/{idJogador}").buildAndExpand(partida.getId()).toUri();
        return ResponseEntity.created(uri).body((Partida) partidaSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> buscarPorId(@PathVariable Long id) {
        return partidaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Partida> atualizar(@PathVariable Long id, @Valid @RequestBody Partida partida) {
        if(partidaService.naoExistePartidaCom(id)) {
            return ResponseEntity.notFound().build();
        }else {
            partida.setId(id);
            Partida partidaAtualizado = partidaService.atualizar(partida);
            return ResponseEntity.ok(partidaAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Partida> deletar(@PathVariable Long id) {
        Optional<Partida> partidaOptional = partidaService.buscarPorId(id);
        if (partidaOptional.isPresent()) {
            partidaService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Partida>> listar() {
        Iterable<Partida> partidas = partidaService.listar();
        return ResponseEntity.ok(partidas);
    }


    @GetMapping("pagina/{numeroPagina}/{quantidadePagina}")
    public Iterable<Partida> listarPaginado(@PathVariable Integer numeroPagina, @PathVariable Integer quantidadePagina) {
        if (quantidadePagina > 5) quantidadePagina = 5;
        PageRequest paginacao = PageRequest.of(numeroPagina, quantidadePagina, Sort.by("nome"));
        return partidaService.listarPaginado(paginacao);
    }


    @GetMapping("/paginacao")
    public Page<Partida> listarPaginado(@RequestParam(required = false)Long id, @PageableDefault(
            sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao){
        if (id == null) {
            return partidaService.listarPaginado(paginacao);
        } else {
            return partidaService.listarPorId(id, paginacao);
        }
    }

    @GetMapping("/ocorridas/{campeonatoId}")
    public List<Partida> findPartidaOcorridaByCampeonatoId(@PathVariable Long campeonatoId) {
        return partidaService.findPartidaOcorridaByCampeonatoId(campeonatoId);
    }

    @GetMapping("/nao-ocorridas/{campeonatoId}")
    public List<Partida> findPartidasNaoOcorridasByCampeonatoId(@PathVariable Long campeonatoId) {
        return partidaService.findPartidasNaoOcorridasByCampeonatoId(campeonatoId);
    }
}
