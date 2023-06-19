package ifma.lpweb.lab06.controllers;

import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.models.Resultados;
import ifma.lpweb.lab06.services.JogadorService;
import ifma.lpweb.lab06.services.ResultadoService;
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
@RequestMapping("/resultados")
public class ResultadoController {
    private final ResultadoService resultadoService;

    @PostMapping
    public ResponseEntity<Resultados> cadastrar(@Valid @RequestBody Resultados resultados,
                                                UriComponentsBuilder builder) {
        final Object resultadoSalvo = resultadoService.cadastrar(resultados);
        final URI uri = builder.path("/resultados/{idResultado}").buildAndExpand(resultados.getId()).toUri();
        return ResponseEntity.created(uri).body((Resultados) resultadoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resultados> buscarPorId(@PathVariable Long id) {
        return resultadoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Resultados> atualizar(@PathVariable Long id, @Valid @RequestBody Resultados resultados) {
        if(resultadoService.naoExisteResultadoCom(id)) {
            return ResponseEntity.notFound().build();
        }else {
            resultados.setId(id);
            Resultados resultadosAtualizado = resultadoService.atualizar(resultados);
            return ResponseEntity.ok(resultadosAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Resultados> deletar(@PathVariable Long id) {
        Optional<Resultados> resultadoOptional = resultadoService.buscarPorId(id);
        if (resultadoOptional.isPresent()) {
            resultadoService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Resultados>> listar() {
        Iterable<Resultados> resultados = resultadoService.listar();
        return ResponseEntity.ok(resultados);
    }


    @GetMapping("pagina/{numeroPagina}/{quantidadePagina}")
    public Iterable<Resultados> listarPaginado(@PathVariable Integer numeroPagina, @PathVariable Integer quantidadePagina) {
        if (quantidadePagina > 5) quantidadePagina = 5;
        PageRequest paginacao = PageRequest.of(numeroPagina, quantidadePagina, Sort.by("nome"));
        return resultadoService.listarPaginado(paginacao);
    }


    @GetMapping("/paginacao")
    public Page<Resultados> listarPaginado(@RequestParam(required = false)Long idResultado, @PageableDefault(
            sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao){
        if (idResultado == null) {
            return resultadoService.listarPaginado(paginacao);
        } else {
            return resultadoService.listarPorId(idResultado, paginacao);
        }
    }
}
