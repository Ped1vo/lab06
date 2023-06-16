package ifma.lpweb.lab06.controllers;

import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.services.JogadorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private final JogadorService jogadorService;

    @PostMapping
    public ResponseEntity<Jogador> cadastrar(@Valid @RequestBody Jogador jogador,
                                             UriComponentsBuilder builder) {
        final Object jogadorSalvo = jogadorService.cadastrar(jogador);
        final URI uri = builder.path("/jogadores/{idJogador}").buildAndExpand(jogador.getId()).toUri();
        return ResponseEntity.created(uri).body((Jogador) jogadorSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarPorId(@PathVariable Long id) {
        return jogadorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizar(@PathVariable Long id, @Valid @RequestBody Jogador jogador) {
        if(jogadorService.naoExisteJogadorCom(id)) {
            return ResponseEntity.notFound().build();
        }else {
            jogador.setId(id);
            Jogador jogadorAtualizado = jogadorService.atualizar(jogador);
            return ResponseEntity.ok(jogadorAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Jogador> deletar(@PathVariable Long id) {
        Optional<Jogador> jogadorOptional = jogadorService.buscarPorId(id);
        if (jogadorOptional.isPresent()) {
            jogadorService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Jogador>> listar() {
        Iterable<Jogador> jogadores = jogadorService.listar();
        return ResponseEntity.ok(jogadores);
    }


    @GetMapping("pagina/{numeroPagina}/{quantidadePagina}")
    public Iterable<Jogador> listarPaginado(@PathVariable Integer numeroPagina, @PathVariable Integer quantidadePagina) {
        if (quantidadePagina > 5) quantidadePagina = 5;
        PageRequest paginacao = PageRequest.of(numeroPagina, quantidadePagina, Sort.by("nome"));
        return jogadorService.listarPaginado(paginacao);
    }


    @GetMapping("/paginacao")
    public Page<Jogador> listarPaginado(@RequestParam(required = false)String nome, @PageableDefault(
                            sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao){
        if (nome == null) {
            return jogadorService.listarPaginado(paginacao);
        } else {
            return jogadorService.listarPorNome(nome, paginacao);
        }
    }
}


