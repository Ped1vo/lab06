package ifma.lpweb.lab06.controllers;

import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.models.Time;
import ifma.lpweb.lab06.services.TimeService;
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
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;

    @PostMapping
    public ResponseEntity<Time> cadastrar(@Valid @RequestBody Time time,
                                          UriComponentsBuilder builder) {
        final Object timeSalvo = timeService.cadastrar(time);
        final URI uri = builder.path("/times/{id}").buildAndExpand(time.getId()).toUri();
        return ResponseEntity.created(uri).body((Time) timeSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> buscarPorId(@PathVariable Long id) {
        return timeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Time> atualizar(@PathVariable Long id, @Valid @RequestBody Time time) {
        if(timeService.naoExisteTimeCom(id)) {
            return ResponseEntity.notFound().build();
        }else {
            time.setId(id);
            Time timeAtualizado = timeService.atualizar(time);
            return ResponseEntity.ok(timeAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Time> deletar(@PathVariable Long id) {
        Optional<Time> jogadorOptional = timeService.buscarPorId(id);
        if (jogadorOptional.isPresent()) {
            timeService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Time>> listar() {
        Iterable<Time> times = timeService.listar();
        return ResponseEntity.ok(times);
    }


    @GetMapping("pagina/{numeroPagina}/{quantidadePagina}")
    public Iterable<Time> listarPaginado(@PathVariable Integer numeroPagina, @PathVariable Integer quantidadePagina) {
        if (quantidadePagina > 5) quantidadePagina = 5;
        PageRequest paginacao = PageRequest.of(numeroPagina, quantidadePagina, Sort.by("nome"));
        return timeService.listarPaginado(paginacao);
    }


    @GetMapping("/paginacao")
    public Page<Time> listarPaginado(@RequestParam(required = false)String nome, @PageableDefault(
            sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao){
        if (nome == null) {
            return timeService.listarPaginado(paginacao);
        } else {
            return timeService.listarPorNome(nome, paginacao);
        }
    }
    @GetMapping("timesporcampeonato/{campeonatoId}")
    public List<Time> findByCampeonatoId(@PathVariable Long campeonatoId) {
        return timeService.findByCampeonatoId(campeonatoId);
    }
}
