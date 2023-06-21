package ifma.lpweb.lab06.controllers;


import ifma.lpweb.lab06.models.Time;
import ifma.lpweb.lab06.services.TimeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
        if (!timeService.existeTimeCom(id)) {
            return ResponseEntity.notFound().build();
        } else {
            time.setId(id);
            Time timeAtualizado = timeService.atualizar(time);
            return ResponseEntity.ok(timeAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Time> deletar(@PathVariable Long id) {
        boolean timeExiste = timeService.existeTimeCom(id);
        if (timeExiste) {
            timeService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Time>> listar() {
        List<Time> times = timeService.listar();
        return ResponseEntity.ok(times);
    }

    @GetMapping("/timesporcampeonato/{campeonatoId}")
    public ResponseEntity<List<Time>> findByCampeonatoId(@PathVariable Long campeonatoId) {
        List<Time> times = timeService.findByCampeonatoId(campeonatoId);
        return ResponseEntity.ok(times);
    }
}
