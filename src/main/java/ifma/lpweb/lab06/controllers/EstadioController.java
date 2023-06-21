package ifma.lpweb.lab06.controllers;

import ifma.lpweb.lab06.models.Estadio;
import ifma.lpweb.lab06.services.EstadioService;
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
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/estadios")
public class EstadioController {
    private final EstadioService estadioService;

    @PostMapping
    public ResponseEntity<Estadio> cadastrar(@Valid @RequestBody Estadio estadio,
                                             UriComponentsBuilder builder) {
        Estadio estadioSalvo = estadioService.cadastrar(estadio);
        final URI uri = builder.path("/estadios/{id}").buildAndExpand(estadioSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(estadioSalvo);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Estadio> buscarPorId(@PathVariable Long id) {
        return estadioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Estadio> atualizar(@PathVariable Long id, @Valid @RequestBody Estadio estadio) {
        if (estadioService.naoExisteEstadioCom(id)) {
            return ResponseEntity.notFound().build();
        }
        estadio.setId(id);
        Estadio estadioAtualizado = estadioService.atualizar(estadio);
        return ResponseEntity.ok(estadioAtualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (estadioService.buscarPorId(id).isPresent()) {
            estadioService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public ResponseEntity<Iterable<Estadio>> listar() {
        Iterable<Estadio> estadios = estadioService.listar();
        return ResponseEntity.ok(estadios);
    }


    @GetMapping("pagina/{numeroPagina}/{quantidadePagina}")
    public Iterable<Estadio> listarPaginado(@PathVariable Integer numeroPagina, @PathVariable Integer quantidadePagina) {
        if (quantidadePagina > 5) quantidadePagina = 5;
        PageRequest paginacao = PageRequest.of(numeroPagina, quantidadePagina, Sort.by("nome"));
        return estadioService.listarPaginado(paginacao);
    }


    @GetMapping("/paginacao")
    public Page<Estadio> listarPaginado(@RequestParam(required = false)String nome, @PageableDefault(
            sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao){
        if (nome == null) {
            return estadioService.listarPaginado(paginacao);
        } else {
            return estadioService.listarPorNome(nome, paginacao);
        }
    }
}
