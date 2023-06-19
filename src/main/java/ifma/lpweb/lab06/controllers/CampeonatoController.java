package ifma.lpweb.lab06.controllers;

import ifma.lpweb.lab06.dtos.CampeonatoDTO;
import ifma.lpweb.lab06.models.Campeonato;
import ifma.lpweb.lab06.models.Time;
import ifma.lpweb.lab06.services.CampeonatoService;
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
@RequestMapping("/campeonatos")
public class CampeonatoController {
    private final CampeonatoService campeonatoService;

    @PostMapping
    public ResponseEntity<Campeonato> cadastrar(@Valid @RequestBody Campeonato campeonato,
                                                UriComponentsBuilder builder) {
        final Object campeonatoSalvo = campeonatoService.cadastrar(campeonato);
        final URI uri = builder.path("/campeonatos/{id}").buildAndExpand(campeonato.getId()).toUri();
        return ResponseEntity.created(uri).body((Campeonato) campeonatoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampeonatoDTO> buscarPorId(@PathVariable Long id) {
        Optional<Campeonato> campeonatoOptional = campeonatoService.buscarPorId(id);
        if (campeonatoOptional.isPresent()) {
            Campeonato campeonato = campeonatoOptional.get();
            CampeonatoDTO campeonatoDTO = new CampeonatoDTO();
            campeonatoDTO.setId(campeonato.getId());
            campeonatoDTO.setNome(campeonato.getNome());
            return ResponseEntity.ok(campeonatoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Campeonato> atualizar(@PathVariable Long id, @Valid @RequestBody Campeonato campeonato) {
        if(campeonatoService.naoExisteCampeonatoCom(id)) {
            return ResponseEntity.notFound().build();
        }else {
            campeonato.setId(id);
            Campeonato campeonatoAtualizado = campeonatoService.atualizar(campeonato);
            return ResponseEntity.ok(campeonatoAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Campeonato> deletar(@PathVariable Long id) {
        Optional<Campeonato> campeonatoOptional = campeonatoService.buscarPorId(id);
        if (campeonatoOptional.isPresent()) {
            campeonatoService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Campeonato>> listar() {
        Iterable<Campeonato> campeonatos = campeonatoService.listar();
        return ResponseEntity.ok(campeonatos);
    }


    @GetMapping("pagina/{numeroPagina}/{quantidadePagina}")
    public Iterable<Campeonato> listarPaginado(@PathVariable Integer numeroPagina, @PathVariable Integer quantidadePagina) {
        if (quantidadePagina > 5) quantidadePagina = 5;
        PageRequest paginacao = PageRequest.of(numeroPagina, quantidadePagina, Sort.by("nome"));
        return campeonatoService.listarPaginado(paginacao);
    }


    @GetMapping("/paginacao")
    public Page<Campeonato> listarPaginado(@RequestParam(required = false)String nome, @PageableDefault(
            sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao){
        if (nome == null) {
            return campeonatoService.listarPaginado(paginacao);
        } else {
            return campeonatoService.listarPorNome(nome, paginacao);
        }
    }
}
